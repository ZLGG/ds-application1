package com.zlg.bs.user.ctrl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.user.service.UserServiceImpl;
import com.zlg.bs.user.util.MailUtil;
import com.zlg.bs.user.util.VerifyCodeUtils;
import com.zlg.bs.vo.Constans;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    MailUtil mailUtil;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/getUserById")
    public ResponseDto getUserById() {

        ResponseDto user = userService.getUserById(1);
        return user;
    }

    @RequestMapping("/getUser")
    public String getUser(UserEo userEo) {
        userService.getUser(userEo);
        return null;
    }

    public String registerUser(UserEo userEo) {
        ResponseDto<List<UserEo>> user = userService.getUser(userEo);
        if (user == null) {
            userService.insertUser(userEo);
            return "success";
        }
        return "error";
    }

   /* @RequestMapping("/getMail")
    public String mail() {
        String send = mailUtil.send();
        return send;
    }*/

    @RequestMapping(value = "/verifyCode",method = RequestMethod.GET)
    public String verifyCode(String email, HttpSession session) throws Exception{
       /* ServletOutputStream outputStream = response.getOutputStream();
        *//*String code = VerifyCodeUtils.generateVerifyCode(4);*//*
        String code = VerifyCodeUtils.outputVerifyImage(200, 80, outputStream, 4);
        session.setAttribute("code", code);*/
        //String email1 = request.getParameter("email");
        String code = VerifyCodeUtils.generateVerifyCode(4);
        UserEo userEo = new UserEo();
        userEo.setMobile(email);
        userEo.setPassword(code);
        userEo.setNickName("zlg");
        session.setAttribute("user",userEo);
        mailUtil.send(email);
        return "{\n" +
                "  \"status\":0,\n" +
                "  \"result\":\"logo\"\n" +
                "}";
    }

    @RequestMapping("/verifyCation")
    public String verifyCation(HttpSession session,String code) {
        String verifyCode = (String)session.getAttribute("code");
        if (verifyCode.equals(code)) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("/login")
    public ResponseDto login(UserEo userEo,HttpSession session) {
        UserEo user1 = (UserEo)session.getAttribute("user");
        //ResponseDto<List<UserEo>> user = userService.getUser(userEo);
        if (!userEo.getMobile().equals(user1.getMobile())){
            return new ResponseDto(ResponseDto.RESULT_FAIL, "账号不对");
        }
        if (!userEo.getPassword().equals(user1.getPassword())) {
            return new ResponseDto(ResponseDto.RESULT_FAIL, "验证码错我");
        }
        else {
            return new ResponseDto(user1);
        }
    }
}

package com.zlg.bs.user.ctrl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.taobao.diamond.domain.Page;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.user.AdminVo;
import com.zlg.bs.user.service.UserServiceImpl;
import com.zlg.bs.user.util.MailUtil;
import com.zlg.bs.user.util.UuidUtil;
import com.zlg.bs.user.util.VerifyCodeUtils;
import com.zlg.bs.vo.Constans;
import com.zlg.bs.vo.Result;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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



   /* @RequestMapping("/getMail")
    public String mail() {
        String send = mailUtil.send();
        return send;
    }*/

    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    public String verifyCode(String email, HttpSession session) throws Exception {
        /* ServletOutputStream outputStream = response.getOutputStream();
         *//*String code = VerifyCodeUtils.generateVerifyCode(4);*//*
        String code = VerifyCodeUtils.outputVerifyImage(200, 80, outputStream, 4);
        session.setAttribute("code", code);*/
        //String email1 = request.getParameter("email");
        String code = VerifyCodeUtils.generateVerifyCode(4);
        UserEo userEo = new UserEo();
        userEo.setEmail(email);
        userEo.setPassword(code);
        session.setAttribute("user", userEo);
        mailUtil.send(email);
        return "{\n" +
                "  \"status\":0,\n" +
                "  \"result\":\"logo\"\n" +
                "}";
    }

    @RequestMapping("/verifyCation")
    public String verifyCation(HttpSession session, String code) {
        String verifyCode = (String) session.getAttribute("code");
        if (verifyCode.equals(code)) {
            return "success";
        }
        return "false";
    }

    @RequestMapping(value = "/login")
    public ResponseDto login(HttpSession session, String email, String pnum) {

        UserEo user1 = (UserEo) session.getAttribute("user");
        //ResponseDto<List<UserEo>> user = userService.getUser(userEo);
        if (user1 == null) {
            return new ResponseDto(ResponseDto.RESULT_FAIL, "请重新获取验证码");
        }
        if (!email.equals(user1.getEmail())) {
            return new ResponseDto(ResponseDto.RESULT_FAIL, "账号不对");
        }
        if (!pnum.equals(user1.getPassword())||user1.getPassword()==null) {
            return new ResponseDto(ResponseDto.RESULT_FAIL, "验证码错误");
        } else {
            String accountId = UuidUtil.generateString(new SecureRandom(), UuidUtil.SOURCES, 13);
            //昵称暂时也与accountId相同
            ResponseDto<List<UserEo>> user = userService.getUser(user1);
            if (user.getData().size() == 0) {
                user1.setAccountId("ds_" + accountId);
                user1.setNickName("ds_" + accountId);
                userService.insertUser(user1);
                session.setAttribute("user",user1);
                return new ResponseDto(user1);
            }
            session.setAttribute("user",user.getData().get(0));
            return new ResponseDto(user.getData().get(0));
        }
    }

    @ResponseBody
    @RequestMapping("/getAdminList")
    public String getAdminList(String page,String limit) {

        return "{\n" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"\"\n" +
                "  ,\"count\": 300\n" +
                "  ,\"data\": [{\n" +
                "    \"id\": \"10001\"\n" +
                "    ,\"username\": \"zlg\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"点击此处，显示更多。当内容超出时，点击单元格会自动显示更多内容。\"\n" +
                "    ,\"experience\": \"116\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"108\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }]" +
                "}";
    }

    @ResponseBody
    @RequestMapping("/addAdmin")
    public ResponseDto addAdmin(AdminVo adminVo) {
        return new ResponseDto<>("");
    }

}

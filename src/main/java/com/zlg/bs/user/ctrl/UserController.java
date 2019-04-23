package com.zlg.bs.user.ctrl;

import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.user.eo.UserEo;
import com.zlg.bs.user.service.UserServiceImpl;
import com.zlg.bs.user.util.MailUtil;
import com.zlg.bs.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    MailUtil MailUtil;

    @RequestMapping("/getAdminList")
    public Result getAdminList(Integer page, Integer limit, HttpSession HttpSession,
                               @RequestParam(name = "start",required = false)String start,
                               @RequestParam(name = "end" ,required = false)String end,
                               @RequestParam(name = "userName" ,required = false)String userName) {
        UserEo userEo = new UserEo();
        userEo.setId(1L);
        HttpSession.setAttribute("user",userEo);
        UserEo user = (UserEo)HttpSession.getAttribute("user");
        Result result = userService.selectUserList(user.getId(), page, limit);
        for (UserEo eo : (List<UserEo>) result.getData()) {
            if (eo.getRole() == 0) {
                eo.setRoleName("学生");
            } else if (eo.getRole() == 1) {
                eo.setRoleName("工作人员");
            } else {
                eo.setRoleName("管理员");
            }
        }
        return result;
    }

    @RequestMapping("/addAdmin")
    public Result addAdmin(UserEo UserEo) {
        UserEo userEo = userService.selectAdminById(UserEo.getAccountId());
        if (userEo != null) {
            return new Result(-1, "", "");
        }
        userService.insertAdmin(UserEo);
        return new Result(200, "", "");
    }

    @RequestMapping("/getUser")
    public Result selectUser(Integer page, Integer limit) {
        Result result = userService.selectUser(page, limit);
        return result;
    }

    @RequestMapping("/deleteAdmin")
    public Result deleteAdmin(@RequestParam(name = "id") Integer id) {
        userService.deleteAdmin(id);
        return new Result(0, "", "");
    }

    @RequestMapping("/verifyCode")
    public ResponseDto verifyCode(String email,HttpSession HttpSession) {
        String code = MailUtil.send(email);
        HttpSession.setAttribute("verifyCode",code);
        return new ResponseDto(1);
    }

    @RequestMapping("/session")
    public String addSession(HttpSession session) {
        UserEo userEo = new UserEo();
        userEo.setId(2l);
        session.setAttribute("user",userEo);
        return "success";
    }
}

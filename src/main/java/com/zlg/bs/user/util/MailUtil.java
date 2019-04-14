package com.zlg.bs.user.util;

import com.zlg.bs.vo.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;*/

import javax.mail.internet.MimeMessage;
import java.io.File;
@Service
public class MailUtil {
    /*@Autowired
    TemplateEngine templateEngine;*/
    @Autowired
    private JavaMailSender jms;



    public String send(String email){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("17633901170@163.com ");
        //接收者
        mainMessage.setTo(email);
        //发送的标题
        mainMessage.setSubject("你登录需要的验证码");
        //发送的内容
        String code = VerifyCodeUtils.generateVerifyCode(4);
        mainMessage.setText(code);
        jms.send(mainMessage);
        return code;
    }
    /*@RequestMapping("/sendhtml")
    public String sendHtml() throws Exception{
        MimeMessage mimeMessage = jms.createMimeMessage();
        Context context = new Context();
        context.setVariable("id",1996);
        String mailTemplate = templateEngine.process("MailTemplate", context);
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("17633901170@163.com");
        mimeMessageHelper.setTo("376781958@qq.com");
        mimeMessageHelper.setSubject("zlg");
        mimeMessageHelper.setText(mailTemplate,true);
        jms.send(mimeMessage);
        return "success";
    }
    public String sendFile() throws Exception{
        String path = "D:\\Downloads\\SpotifySetup.exe";
        File file = new File(path);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        String fileName = path.substring(path.lastIndexOf(File.separator));
        MimeMessage mimeMessage = jms.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("17633901170@163.com");
        mimeMessageHelper.setTo("376781958@qq.com");
        mimeMessageHelper.setSubject("资源");
        mimeMessageHelper.setText("↓资源");
        mimeMessageHelper.addAttachment(fileName,fileSystemResource);
        jms.send(mimeMessage);
        return "success";
    }*/
}

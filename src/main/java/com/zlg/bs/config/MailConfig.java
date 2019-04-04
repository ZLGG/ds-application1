package com.zlg.bs.config;

import com.zlg.bs.vo.Constans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Bean("jms")
    public JavaMailSender jms() throws Exception{
       // String config = ConfigService.getConfig("MailNumber", "zlg", 3000L);
       // String[] split = config.split(":");
        /*Constans.mail = split[0];
        Constans.password = split[1];
        Constans.host = split[2];*/
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost( Constans.host);
        javaMailSender.setPort(25);
        javaMailSender.setUsername(Constans.mail);
        javaMailSender.setPassword(Constans.password);
        javaMailSender.setProtocol("smtp");
        javaMailSender.setDefaultEncoding("UTF-8");
        //javaMailSender.setJavaMailProperties();
        /*String config = ConfigService.getConfig("MailNumber", "zlg", 3000L);
        Constans.mail = config;*/

        return javaMailSender;
    }
  /*  @Bean
    public void getMail() {
        *//*String mail = ConfigService.getConfig("MailNumber", "zlg", 3000L);
        Constans.mail = mail;*//*
        //动态监听edas配置更新
        ConfigService.addListener("MailNumber", "zlg", new ConfigChangeListener() {
            @Override
            public void receiveConfigInfo(String s)  {
                String[] split = s.split(":");
                Constans.mail = split[0];
                Constans.password = split[1];
                Constans.host = split[2];
                try {
                    jms();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }*/
}

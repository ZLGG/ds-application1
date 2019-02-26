package com.zlg.bs.user.ctrl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.user.service.UserServiceImpl;
import com.zlg.bs.user.util.MailUtil;
import com.zlg.bs.vo.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    MailUtil mailUtil;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/getUserById")
    public String getUserById() {

        String user = userService.getUserById(1);
        return user;
    }

    @RequestMapping("/getUser")
    public String getUser(UserEo userEo) {
        String user = userService.getUser(userEo);
        return user;
    }

    public String registerUser(UserEo userEo) {
        String user = userService.getUser(userEo);
        if (user == null) {
            userService.insertUser(userEo);
            return "success";
        }
        return "error";
    }

    @RequestMapping("/getMail")
    public String mail() {
        String send = mailUtil.send();
        return send;
    }

    @RequestMapping("/")
    public String toMailHtml(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String tradeNo = request.getParameter("trade_no");
        String outTradeNo = request.getParameter("out_trade_no");
        String totalAmount = request.getParameter("total_amount");

        return "success";
    }

    String SERVER_URL = "https://openapi.alipaydev.com/gateway.do";
    String APP_ID = "2016092400582212";
    String FORMAT = "json";
    String CHARSET = "utf-8";
    String SINGN_TYPE = "RSA2";
    String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDEGmNQ4uBaxUiOC2M/oMIC1XAt2PnLTgF+Lam8jqlOT7ZO8aRPhsMu9nnfiD8VGjA/etLq1SRAXQCdq4QFqAc7XZx956ZN/PahoEVkdjwKx2QSg3uKlFBXhGtalqlLpHApRv6QpOgTCaHnjr1eKTSqLMGvvQMPxm1ahqRpaxm4DW44XWdadPkKRgZA6iXx4bRyNOg5ZPHAvS+kCv+pK/wexggl5ZDbuKdNOOiXTBcze3IdCMoHN7U0QGRksYQ+VlXzUouptVNNCq/E9U4/x30Lwnmr/6qlQhvjPEqEyL3eKjDoYXsCRsA7IsIFhX+kQiEYnrr5v59YHlSUhQcEA4/BAgMBAAECggEACoSLzRvOArBQGuY7dX8uyK4f7SWVCDVv2Q+j6ewQ4pVd5tAJCwbkUxF/KeEJ2Rzld5Ij29qArj8OuGYpl5ASizmTGiGhhs9JfxO0hRXeVImrMV8B8kXQJVGB3IL2I4t3RI99Oc7Ob671kxDR0UoOfA4YeU9+6Yqv9MoB6XGIGJnvxMIo7fEMSwc4/rv7YzzT2jGBHMt2Jj8K2X7jW6jQtMJD8Am1RLo7DHHNUdjq6PPBcik0ZDKxw8CP3G6+HDVbm5uh8FNtHlswRTqHhCXh7w2qSw9ecAW7UVfLfap70lkb2Z7P4yYSY2VHMVv06WVYgdqbCCDCOg8v8OcHbmz13QKBgQDjusHNundjWVpElEqFEIAXzpUPlmSrWoKS81yNoNokSmHfuMFr4Rz+nBdDdKhlsYfbq8lpoC5YCG0Cfovrtko7ACSZ6z93p8TppEZC/hhF40rVrv6wJqial6750g76zwqIvtgHhU1H3v/SUixRnGEZC+m7uqvoAXxGyDnZfgReqwKBgQDccorx0MnuP2nAgxyY2l+2M4MOSory4j7m8DV7+G4TJRb6vUfhzBsOYyP+KPVas/AQE2TqwGTE7CXa3wnOyzxnyfCUvf8vMsKiC8vCAyqoV3jtIV73et94eifNId3/AtIBQQNVMYZbxrZNiHCvNPFHnccRQUb2kZiDVxx4EahbQwKBgQCLrIwZpnh7Ut5umZVrL8eg0m/Sc6ejAYx8nQ7zPukMwSJumV7oz9V8xDfwg6iVVuHA9gg+5KQIEoLpuLwRAmlc7qWEUilHNnsr4jnF9RrmIpZPoVlMqSlYSBhl2VSeuEX5wTO2ySexITE+ym+sToGvXwMoxUGStvaGY2A36Xa8qQKBgHC1M2rNB+EClOvzXNSdmZ/LGG9fF0l0+RoTqBS5AHZTWTtbOPwt4YtqjsVsZX05UDy33bnUIfE4l2Ye8KHE8R5Tdehmd6jG+BHnnAaWneGxz0bV7/rx3H15Xw4XCaxO4dX4Sl7tUjdsElrzrkE1/UJTXarpyAFakTJdgFW3GW+HAoGBALV1l+1sBoh0v3BoubTmc04lY8bAEt1+/7QyuZuEjbMIE749bS6s4ZRfJ5N8RoDDTNoxo+RnWSp82EbYDOgZ/+3BL0qTDX/M7AxxUiNuaDEDR/OyvQjighU84995xTqtgLkOn/0gMVHkAHi4kRUi+8UV7+u+aGfeplQmR1T/xJ6e";
    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAum32xhRl1km2Uwp3tvNr3FSWuDVbovpTNxeALYhwgWWncpkL7nphOpbooj3fQpq4RkPiMsv5CiEW+cWNTp61RSlWgmJ1fboLHM6S2EAY5ZHmMUxXxjCU0ms9zeR9xY2QxTWUvUyqaP+zgIOiJzRz33TaHTrEz1hy+cI8J/UFdIINIhcYyl3H8GvhB0cKK+RS05FjWHTjPdCCh4eLqMWfyCURSgrzPsH/Sjy83VaTN82+6sKxYxjHgioybdBOlB3t6l+Bng+Q/AMBkY9j+Nee1e3om6JZAVihGddiTHbavziD4duRf8Bw6rJei7f5j0aZOh1am2Cng/whdPDuOE9rSQIDAQAB";
    @RequestMapping("/alipay")
    public void alipay(HttpServletResponse httpResponse) throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(Constans.SERVER_URL, Constans.APP_ID, Constans.PRIVATE_KEY,
                Constans.FORMAT, Constans.CHARSET,Constans.ALIPAY_PUBLIC_KEY , Constans.SINGN_TYPE); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
/*
        http://domain.com/CallBack/return_url.jsp
                String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());

*/
        String date = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        alipayRequest.setReturnUrl("http://localhost:8086/");
        alipayRequest.setNotifyUrl("http://localhost:8086/getUser");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":"+date+"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":100," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(form);
        httpResponse.setContentType("text/html;charset= utf-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    //调用退款接口
    @RequestMapping("/returnPay")
    public void returnPay() throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY,
                "json", "utf-8",ALIPAY_PUBLIC_KEY , "RSA2"); //获得初始化的AlipayClient
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101002\"," +
                "    \"trade_no\":\"2019022022001475330500674095\"," +
                "    \"refund_amount\":0.01," +
                "    \"refund_reason\":\"正常退款\"," +
                "    \"out_request_no\":\"HZ01RF001\"," +
                "    \"operator_id\":\"OP001\"," +
                "    \"store_id\":\"NJ_S_001\"," +
                "    \"terminal_id\":\"NJ_T_001\"" +
                "  }");
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

}

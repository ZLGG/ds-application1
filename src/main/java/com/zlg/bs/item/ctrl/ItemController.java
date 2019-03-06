package com.zlg.bs.item.ctrl;

import com.zlg.bs.center.user.vo.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ItemController {
    @ResponseBody
    @RequestMapping("/getCommodity")
    public String getCommodity(HttpServletRequest request) {
        String account = request.getParameter("account");
        String pagesize = request.getParameter("pagesize");
        return "{\n" +
                "  \"status\":0,\n" +
               // "  \"count\":200,\n" +
                "  \"menu\":\n" +
                "    {\"milk\":{\n" +
                "        \"content\":[\n" +
                "          {\"img\":\"/static/img/paging_img1.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img2.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
              /*  "          {\"img\":\"/static/img/paging_img3.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img1.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img2.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img3.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img1.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img2.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img3.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img1.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img2.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +*/
                "          {\"img\":\"/static/img/paging_img3.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"}\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "}\n";
    }

    @RequestMapping("/getCount")
    @ResponseBody
    public String getCommodityCount() {
        return "{\n" +
                "  \"status\":0,\n" +
                 "  \"count\":150,\n" +
                "  \"menu\":\n" +
                "    {\"milk\":{\n" +
                "        \"content\":[\n" +
               /* "          {\"img\":\"/static/img/paging_img1.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img2.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img3.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥200\",\"nub\":\"1266付款\"}\n" +*/
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "}\n";
    }

    @ResponseBody
    @RequestMapping("/ajaxtest")
    public ResponseDto ajaxtest() {
        return new ResponseDto("success");
    }
}

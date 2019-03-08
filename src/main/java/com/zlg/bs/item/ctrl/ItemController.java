package com.zlg.bs.item.ctrl;

import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.vo.Item;
import com.zlg.bs.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {
    @ResponseBody
    @RequestMapping("/getCommodity")
    public String getCommodity(HttpServletRequest request) {
        String account = request.getParameter("account");
        String pagesize = request.getParameter("pagesize");
        return "{\n" +
                "  \"status\":0,\n" +
                "  \"count\":150,\n" +
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
    @RequestMapping("/getCount1")
    @ResponseBody
    public String getCommodityCount1() {
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
    @RequestMapping("/getCommodity1")
    public String getCommodity1(HttpServletRequest request) {
        String account = request.getParameter("account");
        String pagesize = request.getParameter("pagesize");
        return "{\n" +
                "  \"status\":0,\n" +
                // "  \"count\":200,\n" +
                "  \"menu\":\n" +
                "    {\"milk\":{\n" +
                "        \"content\":[\n" +
                "          {\"img\":\"/static/img/paging_img1.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥2000\",\"nub\":\"12660付款\"},\n" +
                "          {\"img\":\"/static/img/paging_img2.jpg\",\"title\":\"森系小清新四件套\",\"pri\":\"￥2000\",\"nub\":\"12660付款\"},\n" +
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

    @ResponseBody
    @RequestMapping("/ajaxtest")
    public ResponseDto ajaxtest(Item item) {
        if (item != null) {
            System.out.println(item.toString());
        }
        return new ResponseDto("success");
    }

    public String getCatalog() {
        return null;
    }

    @ResponseBody
    @RequestMapping("/getItemList")
    public Result getItemList() {
        Item item = new Item();
        item.setColor("hong");
        item.setCiurPic("$200");
        item.setImg("jfsfj");
        item.setDiscount("5zhe");
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        return new Result(0,"chenggong",items);
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "adminIndex";
    }
}

package com.zlg.bs.item.ctrl;

import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.vo.Item;
import com.zlg.bs.vo.Result;
import eo.Catalog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        item.setId("123");
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

    @ResponseBody
    @RequestMapping("/getOrderList")
    public Result getOrderList(@RequestParam(name="id",required=false,defaultValue="0")String id
                                ,@RequestParam(name="isPay",required=false,defaultValue="0")String isPay
                                ,@RequestParam(name="start",required=false,defaultValue="0")String start
                                ,@RequestParam(name="end",required=false,defaultValue="0")String end
                                ,@RequestParam(name="status",required=false,defaultValue="0")String status) {
        Item item = new Item();
        if (id.equals("1")) {
            item.setId("123");
            item.setColor("hong");
            item.setCiurPic("$200");
            item.setImg("jfsfj");
            item.setDiscount("5zhe");
        } else {
            item = new Item();
            item.setId("4234");
            item.setColor("fsf");
            item.setCiurPic("$500");
            item.setImg("/img/a.jpg");
            item.setDiscount("6zhe");
        }

        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        if (id.equals("1")) {
            return new Result(0,"chenggong",items,50);
        }
        return new Result(0,"chenggong",items,100);

    }

    @ResponseBody
    @RequestMapping("/getTopCatalog")
    public ResponseDto getTopCatalog(HttpSession session) {
        Catalog catalog = new Catalog();
        List catalogs = new ArrayList<Catalog>();
        catalog.setId(1L);
        catalog.setName("护肤");
        Catalog catalog1 = new Catalog();
        catalog1.setId(2L);
        catalog1.setName("清洁");
        catalogs.add(catalog);
        catalogs.add(catalog1);
        session.setAttribute("topCatalog",catalogs);
        return new ResponseDto<>(catalogs);
    }

    @ResponseBody
    @RequestMapping("/addCatalog")
    public ResponseDto addCatalog() {
        Catalog catalog = new Catalog();
        return new ResponseDto(catalog);
    }

    @ResponseBody
    @RequestMapping("/getCatalog")
    public ResponseDto getCatalog(HttpSession session ) {
        Catalog catalog = new Catalog();
        List catalogs = new ArrayList<Catalog>();
        catalog.setId(1L);
        catalog.setName("奶粉");
        Catalog catalog1 = new Catalog();
        catalog1.setId(2L);
        catalog1.setName("辅食");
        catalogs.add(catalog);
        catalogs.add(catalog1);
        session.setAttribute("catalog",catalogs);
        return new ResponseDto<>(catalogs);

    }

    @ResponseBody
    @RequestMapping("/addItem")
    public ResponseDto addItem(HttpServletRequest request) {
        String imgUrl = request.getParameter("imgUrl");
        imgUrl = "/image/" + imgUrl;
        return new ResponseDto<>("增加成功");
    }
}

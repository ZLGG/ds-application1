package com.zlg.bs.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.zlg.bs.app.service.MallService;
import com.zlg.bs.item.service.ItemService;
import com.zlg.bs.user.eo.UserEo;
import com.zlg.bs.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FrontController {
    @Autowired
    MallService MallService;
    @Autowired
    private ItemService ItemService;

    @ResponseBody
    @RequestMapping("/getInformation")
    public ImformationResultVo getInformation(HttpServletRequest servletRequest) {
        String account = servletRequest.getParameter("account");
        String pagesize = servletRequest.getParameter("pagesize");
        Integer page = 1;
        Integer limit = 10;
        if (!(account == null || pagesize == null)) {
            page = Integer.parseInt(account);
            limit = Integer.parseInt(pagesize);
        }
        ImformationResultVo imformationResultVo = MallService.selectFrontInformation(page, limit);
        return imformationResultVo;


    }
    @ResponseBody
    @RequestMapping("/getBlackGetInformation")
    public Result getBlackGetInformation(Integer page,Integer limit) {

        Result result = MallService.selectInformation(page, limit);
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteInformation")
    public ResponseDto deleteInformation(Integer id) {
        //根据id删除
        MallService.deleteInformation(id);
        return new ResponseDto("成功删除");
    }

    @ResponseBody
    @RequestMapping("/addInformation")
    public ResponseDto addInformation(Information information) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = simpleDateFormat.format(date);
        information.setData(data);
        information.setImg("/static/img/new1.jpg");
        MallService.addInformation(information);
        return ResponseDto.TRUE;
    }

    @ResponseBody
    @RequestMapping("/getIndex")
    public IndexResultVo getIndex() {
        IndexResultVo indexResultVo = new IndexResultVo();
        Floor floor = new Floor();
        Banner banner = new Banner();
        Banner banner1 = new Banner();
        List<Item> items1 = ItemService.selectItemCount();
        for (Item item : items1) {
            double i = Double.parseDouble(item.getOriginal()) * Double.parseDouble(item.getDiscount())/10;
            item.setPrice(String.valueOf(i));
        }
        ArrayList<Banner> banners = new ArrayList<>();
        if (items1.size() > 4) {
            banner.setCont(items1.subList(0, 4));
            banners.add(banner);
            if (items1.size() > 8) {
                banner1.setCont(items1.subList(4, 7));
                banners.add(banner);
            } else {
                banner1.setCont(items1.subList(4, items1.size()));
                banners.add(banner1);
            }
        } else {
            banner.setCont(items1);
            banners.add(banner);
        }
        floor.setBanner(banners);
        indexResultVo.setFloor(floor);
        List<Item> items = ItemService.selectItemProductList();
        for (Item item : items) {
            item.setText(item.getTitle());
            item.setPrice(item.getOriginal());
        }
        IndexProductList indexProductList = new IndexProductList();
        indexProductList.setItem(items);
        indexProductList.setTitle("热销推荐");
        indexResultVo.setProductList(indexProductList);
        indexResultVo.setStatus(0);
        return indexResultVo;
    }

    @RequestMapping(value = "/todetail", method = RequestMethod.GET)
    public String todetail(Integer id, HttpSession session) {
        Item item = ItemService.selectItemById(id);
        if (item.getDiscount().equals("0")) {
            item.setPrice(item.getOriginal());
        } else {
            double i = Double.parseDouble(item.getOriginal()) * Double.parseDouble(item.getDiscount())/10;
            item.setPrice(String.valueOf(i));
        }
        session.setAttribute("item", item);
        return "details";
    }
    @ResponseBody
    @RequestMapping("/setAdress")
    public Result setAdress(HttpServletRequest servletRequest,HttpSession session) {
        UserEo user = (UserEo) session.getAttribute("user");
        if (user == null) {
            return new Result(-1, "", "");
        }
        String province = servletRequest.getParameter("province");
        String city = servletRequest.getParameter("city");
        String area = servletRequest.getParameter("area");
        String address = servletRequest.getParameter("address");
        address = province + city + area + address;
        MallService.setAddress(user.getId(),address);
        return new Result(0,"","");
    }
}

package com.zlg.bs.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.zlg.bs.app.service.MallService;
import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.item.service.ItemService;
import com.zlg.bs.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getInformation() {
        Information information = new Information();
        return "{\n" +
                "   \"status\":0,\n" +
                "  \"listCont\":[\n" +
                "    {\"img\":\"/static/img/new1.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"},\n" +
                "    {\"img\":\"/static/img/new2.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"}\n" +
                "  ]\n" +
                "}";
    }
    @ResponseBody
    @RequestMapping("/getBlackGetInformation")
    public Result getBlackGetInformation(Integer page,Integer limit) {
        /*Information information = new Information();
        information.setData("neirong");
        information.setInfoCont("infocont");
        information.setText("text");
        List informationList = new ArrayList<>();
        informationList.add(information);*/
        Result result = MallService.selectInformation(page, limit);
        return result;
        /*return "{\n" +
                "   \"status\":0,\n" +
                "  \"listCont\":[\n" +
                "    {\"img\":\"/static/img/new1.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"},\n" +
                "    {\"img\":\"/static/img/new2.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"}\n" +
                "  ]\n" +
                "}";*/
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
}

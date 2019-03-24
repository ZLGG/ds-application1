package com.zlg.bs.app;

import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.vo.Information;
import com.zlg.bs.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FrontController {
    @ResponseBody
    @RequestMapping("/getInformation")
    public String getInformation() {
        Information information = new Information();
        return "{\n" +
                "   \"status\":0,\n" +
                "  \"listCont\":[\n" +
                "    {\"img\":\"../res/img/new1.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"},\n" +
                "    {\"img\":\"../res/img/new2.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"}\n" +
                "  ]\n" +
                "}";
    }
    @ResponseBody
    @RequestMapping("/getBlackGetInformation")
    public Result getBlackGetInformation() {
        Information information = new Information();
        information.setData("neirong");
        information.setInfoCont("infocont");
        information.setText("text");
        List informationList = new ArrayList<>();
        informationList.add(information);
        return new Result(0,"chenggong",informationList);
        /*return "{\n" +
                "   \"status\":0,\n" +
                "  \"listCont\":[\n" +
                "    {\"img\":\"../res/img/new1.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"},\n" +
                "    {\"img\":\"../res/img/new2.jpg\",\"text\":\"周岁内的宝宝消化不良拉肚子怎么办?\",\"data\":\"2016-12-24 16:33:26\",\"infoCont\":\"宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子\"}\n" +
                "  ]\n" +
                "}";*/
    }

    @ResponseBody
    @RequestMapping("/deleteInformation")
    public ResponseDto deleteInformation(String id) {
        //根据id删除
        return new ResponseDto("成功删除");
    }

    @ResponseBody
    @RequestMapping("/addInformation")
    public ResponseDto addInformation(Information information) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = simpleDateFormat.format(date);
        information.setData(data);
        return new ResponseDto(information);
    }
}

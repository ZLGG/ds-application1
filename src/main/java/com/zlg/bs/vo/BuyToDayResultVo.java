package com.zlg.bs.vo;

import lombok.Data;

import java.util.List;
@Data
public class BuyToDayResultVo {
    private int status;
    private List<Item> productList;
    private List<Item> footerList;
}

package com.zlg.bs.vo;

import lombok.Data;

@Data
public class CommodityResultVo {
    private Integer status;
    private Integer count;
    private Menu menu;

    public CommodityResultVo(Integer status, Integer count, Menu menu) {
        this.status = status;
        this.count = count;
        this.menu = menu;
    }
}

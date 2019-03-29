package com.zlg.bs.vo;

import lombok.Data;

import java.util.List;
@Data
public class IndexResultVo {
    private String status;
    private Floor floor;
    private HotCon hotCon;
    private List<Proct> proct;
    private IndexProductList productList;
}

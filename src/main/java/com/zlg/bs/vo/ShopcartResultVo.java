package com.zlg.bs.vo;

import lombok.Data;

import java.util.List;
@Data
public class ShopcartResultVo {
    private String status;
    private List<Item> infoList;
}

package com.zlg.bs.vo;

import lombok.Data;

@Data
public class OrderRequestVo {
    private String orderId;
    private String start;
    private String end;
    private Integer isPay;
    private Integer status;
}

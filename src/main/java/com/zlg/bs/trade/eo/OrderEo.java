package com.zlg.bs.trade.eo;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
@Table
@Data
public class OrderEo {
        private Long id;
        private Integer itemId;
        private String orderNo;
        private Long tradeNo;
        private Long accountId;
        private Integer status;
        private Integer totalItemNum;
        private Double payAmount;
        private Double itemAmount;
        private String orderTime;
        private String payTime;
        private String shippingTime;
        private String collectTime;
        private String finishTime;
        private String cancelTime;
        private String abortTime;
        private Integer isPay;
        private String createTime;
        private String updateTime;
        private Integer dr;


}

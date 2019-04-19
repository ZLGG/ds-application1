package com.zlg.bs.vo;

import lombok.Data;

import java.util.List;
@Data
public class ImformationResultVo {
    private Integer status;
    private List<Information> listCont;
    private Integer count;

    public ImformationResultVo(Integer status, List<Information> listCont,Integer count) {
        this.status = status;
        this.listCont = listCont;
        this.count = count;
    }
}

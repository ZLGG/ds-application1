package com.zlg.bs.trade.service;

import com.zlg.bs.mapper.trade.OrderMapper;
import com.zlg.bs.trade.eo.OrderEo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OrderMapper OrderMapper;
    public void insertOrder(OrderEo orderEo) {
        OrderMapper.InsertOrder(orderEo);

    }
}

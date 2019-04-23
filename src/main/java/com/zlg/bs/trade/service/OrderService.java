package com.zlg.bs.trade.service;

import com.zlg.bs.mapper.trade.OrderMapper;
import com.zlg.bs.trade.eo.OrderEo;
import com.zlg.bs.vo.OrderRequestVo;
import com.zlg.bs.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderMapper OrderMapper;
    public void insertOrder(OrderEo orderEo) {
        OrderMapper.InsertOrder(orderEo);
    }

    public Result selectOrder(OrderRequestVo OrderEo) {
        List<OrderEo> orderEos = OrderMapper.selectOrder(OrderEo);
        Integer count = OrderMapper.selectCount();
        return new Result(0, "", orderEos, count);
    }

    public OrderEo selectOrderByOrderNo(String orderNo) {
        OrderEo orderEo = OrderMapper.selectOrderByOrderNo(orderNo);
        return orderEo;
    }

    public void orderPay(OrderEo orderEo) {
        OrderMapper.orderPay(orderEo);
    }
}

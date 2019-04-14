package com.zlg.bs.mapper.trade;

import com.zlg.bs.trade.eo.OrderEo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    @Insert("insert into tr_order (item_id,order_no,trade_no,account_id,status,pay_amount,pay_time) values(#{eo.itemId},#{eo.orderNo},#{eo.tradeNo},#{eo.accountId},2,#{eo.payAmount},now())")
    void InsertOrder(@Param("eo") OrderEo orderEo);
}

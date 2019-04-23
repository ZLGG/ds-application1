package com.zlg.bs.mapper.trade;

import com.zlg.bs.trade.eo.OrderEo;
import com.zlg.bs.vo.OrderRequestVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {
    @Select("SELECT FOUND_ROWS() as count;")
    Integer selectCount();

    @Insert("insert into tr_order (item_id,order_no,account_id,status,pay_amount,create_time,address,is_pay) values(#{eo.itemId},#{eo.orderNo},#{eo.accountId},1,#{eo.payAmount},now(),#{eo.address},0)")
    void InsertOrder(@Param("eo") OrderEo orderEo);

    @Select("<script>" +
            "select SQL_CALC_FOUND_ROWS * from tr_order where dr=0" +
            "<if test='eo.orderId!=null'>and order_no = #{eo.orderId}</if>" +
            "<if test='eo.start!=null'>and (pay_time &gt;= #{eo.start} or create_time &gt;= #{eo.start})</if>" +
            "<if test='eo.end!=null'>and (pay_time &lt;= #{eo.end} or create_time &lt;= #{eo.end})</if>" +
            "<if test='eo.isPay!=null'>and is_Pay=#{eo.isPay}</if>" +
            "<if test='eo.status!=null'>and status=#{eo.status}</if>" +
            "</script>")
    List<OrderEo> selectOrder(@Param("eo")OrderRequestVo eo);

    @Select("select * from tr_order where dr=0 and order_no=#{orderNo}")
    OrderEo selectOrderByOrderNo(@Param("orderNo") String orderNo);

    @Update("update tr_order set trade_no=#{eo.tradeNo} , status=2 ,is_pay=1 ,pay_time=now()   where order_no=#{eo.orderNo}")
    void orderPay(@Param("eo") OrderEo eo);
}

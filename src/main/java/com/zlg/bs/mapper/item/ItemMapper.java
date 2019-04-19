package com.zlg.bs.mapper.item;

import com.zlg.bs.vo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemMapper {
    @Select("SELECT FOUND_ROWS() as count;")
    Integer selectCount();

    @Insert("insert into it_item (img,discount, original,title,color,create_time) values(#{eo.img},#{eo.discount},#{eo.original},#{eo.title},#{eo.color},now()) ")
    void insetItem(@Param("eo") Item Item);

    @Select("select  SQL_CALC_FOUND_ROWS * from it_item where dr=0 limit #{page},#{limit};")
    List<Item> selectItem(@Param("page") Integer page,@Param("limit") Integer limit);

    @Update("update it_item set dr=1 where id=#{id}")
    void delItem(@Param("id") Integer id);

    @Select("select * from it_item where dr = 0 and id=#{id}")
    Item selectItemById(@Param("id") Integer id);

    @Select("select * from it_item where dr = 0 and discount=0")
    List<Item> selectItemProductList();

    @Select("select * from it_item where dr = 0 and discount!= 0  ORDER BY id DESC limit 0,8")
    List<Item> selectItemCount();

    @Select("select SQL_CALC_FOUND_ROWS * from it_item where dr = 0 limit #{page},#{limit}")
    List<Item> selectItemAll(@Param("page") Integer page, @Param("limit") Integer limit);

}

package com.zlg.bs.item.service;

import com.zlg.bs.mapper.item.ItemMapper;
import com.zlg.bs.vo.Item;
import com.zlg.bs.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemService {
    @Resource
    private ItemMapper ItemMapper;

    public void insetItem(Item Item) {
        ItemMapper.insetItem(Item);
    }

    public Result selectItem(Integer page,Integer limit) {
        page = (page - 1) * limit;
        List<Item> items = ItemMapper.selectItem(page, limit);
        Integer count = ItemMapper.selectCount();
        return new Result(0, "", items, count);
    }

    public void delItem(Integer id) {
        ItemMapper.delItem(id);
    }

    public List<Item> selectItemProductList() {
        List<Item> items = ItemMapper.selectItemProductList();
        return items;
    }

    public List<Item> selectItemCount() {
        List<Item> items = ItemMapper.selectItemCount();
        return items;
    }

    public Item selectItemById(Integer id) {
        Item item = ItemMapper.selectItemById(id);
        return item;
    }
}

package com.zlg.bs.app.service;

import com.zlg.bs.mapper.mall.InformationMapper;
import com.zlg.bs.vo.Information;
import com.zlg.bs.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MallService {
    @Resource
    InformationMapper InformationMapper;

    public void  addInformation(Information Information) {
        InformationMapper.addInformation(Information);
    }

    public Result selectInformation(Integer page,Integer limit) {
        page = (page - 1) * limit;
        List<Information> information = InformationMapper.selectInformation(page, limit);
        Integer count = InformationMapper.selectCount();
        return new Result<>(0, "", information, count);
    }

    public void deleteInformation(Integer id) {
        InformationMapper.deleteInformation(id);
    }
}

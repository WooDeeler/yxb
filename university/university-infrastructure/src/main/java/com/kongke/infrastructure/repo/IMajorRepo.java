package com.kongke.infrastructure.repo;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.entity.MajorEntity;
import com.kongke.domain.univ.model.vo.MajorVO;
import com.kongke.domain.univ.repo.MajorRepo;
import com.kongke.domain.univ.utils.Convert;
import com.kongke.infrastructure.dao.MajorDao;
import com.kongke.infrastructure.po.MajorPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IMajorRepo implements MajorRepo {

    @Autowired
    private MajorDao majorDao;

    @Override
    public boolean save(MajorVO vo) {
        return majorDao.save(Convert.convert(vo, MajorPO.class));
    }

    @Override
    public boolean update(MajorVO vo) {
        return majorDao.updateById(Convert.convert(vo, MajorPO.class));
    }

    @Override
    public boolean delete(Integer id) {
        return majorDao.removeById(id);
    }

    @Override
    public PageQueryRsp<MajorEntity> query(ConditionReq req) {
        if (req == null || req.getUnivId() == null){
            return new PageQueryRsp<>();
        }
        Page<MajorPO> page = new Page<>(req.getPage(), req.getSize());
        LambdaQueryWrapper<MajorPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MajorPO::getUniversityId, req.getUnivId());
        wrapper.eq(StrUtil.isNotBlank(req.getYears()), MajorPO::getYears, req.getYears());
        wrapper.eq(StrUtil.isNotBlank(req.getType()), MajorPO::getType, req.getType());
        wrapper.orderByDesc(MajorPO::getYears);
        Page<MajorPO> res = majorDao.page(page, wrapper);
        List<MajorPO> pos = res.getRecords();
        if (pos != null && !pos.isEmpty()) {
            List<MajorEntity> collect = pos.stream().map(po -> Convert.convert(po, MajorEntity.class)).collect(Collectors.toList());
            return new PageQueryRsp<>(res.getTotal(), collect);
        }
        return new PageQueryRsp<>();
    }




}













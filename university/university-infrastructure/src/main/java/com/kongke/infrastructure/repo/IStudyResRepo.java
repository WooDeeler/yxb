package com.kongke.infrastructure.repo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.entity.StudyResEntity;
import com.kongke.domain.univ.model.vo.StudyResVO;
import com.kongke.domain.univ.repo.StudyResRepo;
import com.kongke.domain.univ.utils.Convert;
import com.kongke.infrastructure.dao.StudyResDao;
import com.kongke.infrastructure.po.StudyResPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class IStudyResRepo implements StudyResRepo {

    @Autowired
    private StudyResDao studyResDao;

    @Override
    public PageQueryRsp<StudyResEntity> query(ConditionReq req) {
        Page<StudyResPO> page = new Page<>(req.getPage(), req.getSize());
        LambdaQueryWrapper<StudyResPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(req.getFileType() != null,StudyResPO::getFileType, req.getFileType());
        wrapper.eq(req.getMaterialType() != null, StudyResPO::getMaterialType, req.getMaterialType());
        wrapper.orderByDesc(StudyResPO::getUpdateTime);
        Page<StudyResPO> res = studyResDao.page(page, wrapper);
        List<StudyResPO> pos = res.getRecords();
        if (CollUtil.isEmpty(pos))
            return new PageQueryRsp<>();
        List<StudyResEntity> entities = new ArrayList<>();
        for (StudyResPO po : pos) {
            entities.add(Convert.convert(po, StudyResEntity.class));
        }
        return new PageQueryRsp<>(res.getTotal(), entities);
    }

    @Override
    public boolean delete(Integer id) {
        return studyResDao.removeById(id);
    }

    @Override
    public boolean add(StudyResVO vo) {
      return studyResDao.save(Convert.convert(vo, StudyResPO.class));
    }
}

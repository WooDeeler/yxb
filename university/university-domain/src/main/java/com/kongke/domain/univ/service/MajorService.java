package com.kongke.domain.univ.service;

import cn.hutool.core.collection.CollUtil;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.entity.MajorEntity;
import com.kongke.domain.univ.model.vo.MajorVO;
import com.kongke.domain.univ.repo.MajorRepo;
import com.kongke.domain.univ.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorRepo majorRepo;

    public boolean add(MajorVO vo) {
        return majorRepo.save(vo);
    }

    public boolean update(MajorVO vo) {
        if (vo == null || vo.getId() == null)
            return false;
        return majorRepo.update(vo);
    }

    public boolean delete(Integer id) {
        if (id == null)
            return false;
        return majorRepo.delete(id);
    }

    public List<MajorVO> conditionQuery(ConditionReq req) {
        List<MajorEntity> entities = majorRepo.query(req);
        if (CollUtil.isEmpty(entities))
            return Collections.emptyList();
        List<MajorVO> vos = new ArrayList<>();
        for (MajorEntity entity : entities) {
            vos.add(Convert.convert(entity, MajorVO.class));
        }
        return vos;
    }
}

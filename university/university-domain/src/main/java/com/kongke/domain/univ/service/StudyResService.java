package com.kongke.domain.univ.service;

import cn.hutool.core.collection.CollUtil;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.entity.StudyResEntity;
import com.kongke.domain.univ.model.vo.StudyResVO;
import com.kongke.domain.univ.repo.StudyResRepo;
import com.kongke.domain.univ.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudyResService {

    @Autowired
    private StudyResRepo studyResRepo;

    public List<StudyResVO> query(ConditionReq req) {
        if (req == null)
            return Collections.emptyList();
        List<StudyResEntity> entities = studyResRepo.query(req);
        if (CollUtil.isEmpty(entities))
            return Collections.emptyList();
        ArrayList<StudyResVO> vos = new ArrayList<>();
        for (StudyResEntity entity : entities) {
            vos.add(Convert.convert(entity, StudyResVO.class));
        }
        return vos;
    }

    public boolean delete(Integer id) {
        if (id == null)
            return false;
        return studyResRepo.delete(id);
    }

    public boolean add(StudyResVO vo) {
        return false;
    }
}

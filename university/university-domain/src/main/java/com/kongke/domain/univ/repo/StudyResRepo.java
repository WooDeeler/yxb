package com.kongke.domain.univ.repo;

import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.entity.StudyResEntity;
import com.kongke.domain.univ.model.vo.StudyResVO;

import java.util.List;

public interface StudyResRepo {
    PageQueryRsp<StudyResEntity> query(ConditionReq req);

    boolean delete(Integer id);
}

package com.kongke.domain.univ.repo;

import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.entity.MajorEntity;
import com.kongke.domain.univ.model.vo.MajorVO;

import java.util.List;

public interface MajorRepo {
    boolean save(MajorVO vo);

    boolean update(MajorVO vo);

    boolean delete(Integer id);

    PageQueryRsp<MajorEntity> query(ConditionReq req);
}

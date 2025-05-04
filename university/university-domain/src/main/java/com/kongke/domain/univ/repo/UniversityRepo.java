package com.kongke.domain.univ.repo;

import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.entity.UniversityEntity;
import com.kongke.domain.univ.model.vo.UniversityVO;
import com.kongke.types.common.PageParam;

import java.util.List;

public interface UniversityRepo {
    List<UniversityEntity> pageList(PageParam pageParam);

    UniversityEntity getById(Integer id);

    boolean addUniv(UniversityVO vo);

    boolean update(UniversityVO vo);

    boolean delete(Integer id);

    List<UniversityEntity> conditionQuery(ConditionReq req);
}

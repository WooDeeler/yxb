package com.kongke.api;

import com.kongke.api.dto.ConditionDTO;
import com.kongke.api.dto.UnivDTO;

import java.util.List;

public interface IUniversityService {
    UnivDTO getUnivById(Integer id);

    List<UnivDTO> condQuery(ConditionDTO req);
}

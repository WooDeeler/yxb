package com.kongke.api;

import com.kongke.api.dto.ConditionDTO;
import com.kongke.api.dto.UnivDTO;

import java.util.List;

/**
 * UniversityApi接口
 *
 * @author kongke
 * @date 2025/05/08
 */
public interface IUniversityService {
    UnivDTO getUnivById(Integer id);
    List<UnivDTO> condQuery(ConditionDTO req);
}

package com.kongke.trigger.rpc;

import com.kongke.api.IUniversityService;
import com.kongke.api.dto.ConditionDTO;
import com.kongke.api.dto.UnivDTO;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.vo.UniversityVO;
import com.kongke.domain.univ.service.UniversityService;
import com.kongke.domain.univ.utils.Convert;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@DubboService
public class UniversityRpcService implements IUniversityService {

    @Autowired
    private UniversityService universityService;

    @Override
    public UnivDTO getUnivById(Integer id) {
        UniversityVO vo = universityService.getById(id);
        return Convert.convert(vo, UnivDTO.class);
    }

    @Override
    public List<UnivDTO> condQuery(ConditionDTO req) {
        PageQueryRsp<UniversityVO> rsp = universityService.conditionQuery(Convert.convert(req, ConditionReq.class));
        return rsp.getList().stream().map(univ -> Convert.convert(univ, UnivDTO.class)).collect(Collectors.toList());
    }
}

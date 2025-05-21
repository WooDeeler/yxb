package com.kongke.domain.univ.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.entity.MajorEntity;
import com.kongke.domain.univ.model.entity.UniversityEntity;
import com.kongke.domain.univ.model.vo.MajorVO;
import com.kongke.domain.univ.repo.MajorRepo;
import com.kongke.domain.univ.repo.UniversityRepo;
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

    @Autowired
    private UniversityRepo universityRepo;

    public boolean add(MajorVO vo) {
        if (vo == null || vo.getUniversityId() == null || StrUtil.isBlank(vo.getUniversityName()))
            return false;
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

    public PageQueryRsp<MajorVO> conditionQuery(ConditionReq req) {
        ConditionReq creq = new ConditionReq();
        creq.setUnivName(req.getUnivName());
        creq.setPage(1);
        creq.setSize(1);
        PageQueryRsp<UniversityEntity> rsp = universityRepo.conditionQuery(creq);
        if (rsp == null || rsp.getTotal() != 1)
            return new PageQueryRsp<>();
        UniversityEntity ue = rsp.getList().get(0);
        req.setUnivId(ue.getId());
        PageQueryRsp<MajorEntity> res = majorRepo.query(req);
        List<MajorEntity> entities = res.getList();
        if (CollUtil.isEmpty(entities))
            return new PageQueryRsp<>();
        List<MajorVO> vos = new ArrayList<>();
        for (MajorEntity entity : entities) {
            MajorVO vo = Convert.convert(entity, MajorVO.class);
            vo.setUniversityName(ue.getName());
            vo.setUniversityId(ue.getId());
            vos.add(vo);
        }
        return new PageQueryRsp<>(res.getTotal(), vos);
    }
}

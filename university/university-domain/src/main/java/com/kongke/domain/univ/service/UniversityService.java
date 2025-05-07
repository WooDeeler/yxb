package com.kongke.domain.univ.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.entity.UniversityEntity;
import com.kongke.domain.univ.model.vo.UniversityVO;
import com.kongke.domain.univ.repo.UniversityRepo;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepo universityRepo;

    private List<UniversityVO> listEntityConvertVO (List<UniversityEntity> list) {
        List<UniversityVO> vos = new ArrayList<>();
        if (list.isEmpty())
            return vos;
        for (UniversityEntity e : list){
            UniversityVO vo = new UniversityVO();
            BeanUtil.copyProperties(e, vo);
            vos.add(vo);
        }
        return vos;
    }

    public PageQueryRsp<UniversityVO> pageList(PageParam pageParam) {
        PageQueryRsp<UniversityEntity> rsp = universityRepo.pageList(pageParam);
        return new PageQueryRsp<>(rsp.getTotal(), listEntityConvertVO(rsp.getList()));
    }

    public UniversityVO getById(Integer id) {
        UniversityEntity entity = universityRepo.getById(id);
        if (entity == null)
            return null;
        UniversityVO vo = new UniversityVO();
        BeanUtil.copyProperties(entity, vo);
        return vo;
    }

    public boolean addUniv(UniversityVO vo) {
        return universityRepo.addUniv(vo);
    }

    public boolean update(UniversityVO vo) {
        return universityRepo.update(vo);
    }

    public boolean delete(Integer id) {
        return universityRepo.delete(id);
    }

    public PageQueryRsp<UniversityVO> conditionQuery(ConditionReq req) {
        PageQueryRsp<UniversityEntity> rsp = universityRepo.conditionQuery(req);
        return new PageQueryRsp<>(rsp.getTotal(), listEntityConvertVO(rsp.getList()));
    }
}

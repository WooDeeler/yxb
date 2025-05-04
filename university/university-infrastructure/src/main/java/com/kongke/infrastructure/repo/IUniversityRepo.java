package com.kongke.infrastructure.repo;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.entity.UniversityEntity;
import com.kongke.domain.univ.model.vo.UniversityVO;
import com.kongke.domain.univ.repo.UniversityRepo;
import com.kongke.infrastructure.dao.UniversityDao;
import com.kongke.infrastructure.po.UniversityPO;
import com.kongke.infrastructure.utils.Convert;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IUniversityRepo implements UniversityRepo {

    @Autowired
    private UniversityDao universityDao;

    @Override
    public List<UniversityEntity> pageList(PageParam pageParam) {
        if (pageParam == null)
            return Collections.emptyList();
        Page<UniversityPO> page = new Page<>(pageParam.getPage(), pageParam.getSize());
        Page<UniversityPO> res = universityDao.page(page);
        return res.getRecords().stream()
                .map(po -> Convert.convert(po, UniversityEntity.class))
                .collect(Collectors.toList());
    }

    @Override
    public UniversityEntity getById(Integer id) {
        return Convert.convert(universityDao.getById(id), UniversityEntity.class);
    }

    @Override
    public boolean addUniv(UniversityVO vo) {
        return universityDao.save(Convert.convert(vo, UniversityPO.class));
    }

    @Override
    public boolean update(UniversityVO vo) {
        if (vo == null || vo.getId() == null)
            return false;
        return universityDao.updateById(Convert.convert(vo, UniversityPO.class));
    }

    @Override
    public boolean delete(Integer id) {
        return universityDao.removeById(id);
    }

    @Override
    public List<UniversityEntity> conditionQuery(ConditionReq req) {
        if (req == null)
            return Collections.emptyList();
        LambdaQueryWrapper<UniversityPO> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(StrUtil.isNotBlank(req.getCity()), UniversityPO::getCity, req.getCity());
        wrapper.eq(StrUtil.isNotBlank(req.getType()),UniversityPO::getType, req.getType());
        wrapper.like(StrUtil.isNotBlank(req.getName()),UniversityPO::getName, req.getName());
        List<UniversityPO> list = universityDao.list(wrapper);
        if (list != null && !list.isEmpty()) {
            return list.stream().map(po -> Convert.convert(po, UniversityEntity.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}

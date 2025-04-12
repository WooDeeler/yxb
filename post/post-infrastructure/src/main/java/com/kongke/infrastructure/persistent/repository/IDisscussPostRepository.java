package com.kongke.infrastructure.persistent.repository;

import com.kongke.domain.discussPost.model.entity.DiscussPostEntity;
import com.kongke.domain.discussPost.repository.DiscussPostRepository;
import com.kongke.infrastructure.persistent.dao.DiscussPostDao;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.infrastructure.persistent.po.DiscussPostPO;
import cn.hutool.core.bean.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IDisscussPostRepository implements DiscussPostRepository {

    @Autowired
    private DiscussPostDao discussPostDao;


    private DiscussPostPO convertToPO(DiscussPostEntity entity) {
        if (entity == null) {
            return null;
        }
        DiscussPostPO po = new DiscussPostPO();
        BeanUtil.copyProperties(entity, po);
        return po;
    }

    private DiscussPostEntity convertToEntity(DiscussPostPO po) {
        if (po == null) {
            return null;
        }
        DiscussPostEntity entity = new DiscussPostEntity();
        BeanUtil.copyProperties(po, entity);
        return entity;
    }

    @Override
    public List<DiscussPostEntity> getDiscussPostList(PageParam page) {
        Page<DiscussPostPO> pageParam = new Page<>(page.getPageNum(), page.getPageSize());
        Page<DiscussPostPO> poPage = discussPostDao.page(pageParam);
        return poPage.getRecords().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public boolean createDiscussPost(DiscussPostEntity discussPostEntity) {
        DiscussPostPO po = convertToPO(discussPostEntity);
        return discussPostDao.save(po);
    }

    @Override
    public boolean updateDiscussPost(DiscussPostEntity discussPostEntity) {
        DiscussPostPO po = convertToPO(discussPostEntity);
        return discussPostDao.updateById(po);
    }

    @Override
    public boolean deleteDiscussPost(Long pid) {
        return discussPostDao.removeById(pid);
    }
}

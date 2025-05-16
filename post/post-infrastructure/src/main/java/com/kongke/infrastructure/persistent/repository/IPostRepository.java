package com.kongke.infrastructure.persistent.repository;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kongke.domain.discussPost.model.dto.ConditionReq;
import com.kongke.domain.discussPost.model.dto.PageQueryRsp;
import com.kongke.domain.discussPost.model.entity.PostEntity;
import com.kongke.domain.discussPost.model.vo.PostVO;
import com.kongke.domain.discussPost.repository.PostRepository;
import com.kongke.infrastructure.persistent.dao.PostDao;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.infrastructure.persistent.po.PostPO;
import cn.hutool.core.bean.BeanUtil;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPostRepository implements PostRepository {

    @Autowired
    private PostDao postDao;

    private PostPO VOConvertToPO(PostVO vo) {
        if (vo == null) {
            return null;
        }
        PostPO po = new PostPO();
        BeanUtil.copyProperties(vo, po);
        return po;
    }

    private PostEntity convertToEntity(PostPO po) {
        if (po == null) {
            return null;
        }
        PostEntity entity = new PostEntity();
        BeanUtil.copyProperties(po, entity);
        return entity;
    }

    public String imagesJoin(List<String> list){
        return String.join(", ", list);
    }

    @Override
    public PageQueryRsp<PostEntity> getPostList(PageParam page) {
        if (page == null)
            return new PageQueryRsp<>();
        Page<PostPO> pageParam = new Page<>(page.getPage(), page.getSize());
        LambdaQueryWrapper<PostPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(PostPO::getUpdateTime);
        Page<PostPO> poPage = postDao.page(pageParam, wrapper);
        if (poPage.getRecords().isEmpty()) {
            return new PageQueryRsp<>();
        }
        List<PostEntity> collect = poPage.getRecords().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        return new PageQueryRsp<>(poPage.getTotal(), collect);
    }

    @Override
    public boolean createPost(PostVO vo) {
        PostPO po = VOConvertToPO(vo);
        po.setImageList(imagesJoin(vo.getImageList()));
        return postDao.save(po);
    }

    @Override
    public boolean updatePost(PostVO vo) {
        PostPO po = VOConvertToPO(vo);
        return postDao.updateById(po);
    }

    @Override
    public boolean deletePost(Long pid) {
        return postDao.removeById(pid);
    }

    @Override
    public PostEntity getPostById(Long postId) {
        PostPO po = postDao.getById(postId);
        return convertToEntity(po);
    }

    @Override
    public List<PostEntity> getPostByUid(Integer uid) {
        LambdaQueryWrapper<PostPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PostPO::getAuthorId, uid);
        wrapper.orderByDesc(PostPO::getUpdateTime);
        List<PostPO> postPOList = postDao.list(wrapper);
        if (postPOList.isEmpty()) {
            return Collections.emptyList();
        }
        return postPOList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

    }

    @Override
    public PageQueryRsp<PostEntity> condQuery(ConditionReq req) {
        if (StrUtil.isBlank(req.getTitle()) && StrUtil.isBlank(req.getTag()))
            return new PageQueryRsp<>();
        LambdaQueryWrapper<PostPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(req.getTitle()),PostPO::getTitle, req.getTitle());
        wrapper.like(StrUtil.isNotBlank(req.getTag()), PostPO::getTags, req.getTag());
        wrapper.orderByDesc(PostPO::getUpdateTime);
        List<PostPO> list = postDao.list(wrapper);
        if (list.isEmpty()) {
            return new PageQueryRsp<>();
        }
        List<PostEntity> collect = list.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        return new PageQueryRsp<>((long) list.size(), collect);

    }
}

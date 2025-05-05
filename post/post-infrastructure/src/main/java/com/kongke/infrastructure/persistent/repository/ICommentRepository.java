package com.kongke.infrastructure.persistent.repository;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kongke.domain.discussPost.model.entity.CommentEntity;
import com.kongke.domain.discussPost.model.vo.CommentVO;
import com.kongke.domain.discussPost.repository.CommentRepository;
import com.kongke.infrastructure.persistent.dao.CommentDao;
import com.kongke.infrastructure.persistent.po.CommentPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ICommentRepository implements CommentRepository {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentEntity> getComments(Long postId) {
        LambdaQueryWrapper<CommentPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommentPO::getPostId, postId);
        List<CommentPO> list = commentDao.list(wrapper);
        ArrayList<CommentEntity> res = new ArrayList<>();
        for (CommentPO po : list) {
            CommentEntity entity = new CommentEntity();
            BeanUtil.copyProperties(po, entity);
            res.add(entity);
        }
        return res;
    }

    @Override
    public boolean createComment(CommentVO vo) {
        CommentPO po = new CommentPO();
        BeanUtil.copyProperties(vo, po);
        return commentDao.save(po);
    }

    @Override
    public boolean delComment(Long id) {
        return commentDao.removeById(id);
    }
}

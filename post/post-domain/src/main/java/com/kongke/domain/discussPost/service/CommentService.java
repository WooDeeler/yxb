package com.kongke.domain.discussPost.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.domain.discussPost.model.entity.CommentEntity;
import com.kongke.domain.discussPost.model.vo.CommentVO;
import com.kongke.domain.discussPost.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentVO> getComments(Long postId) {
        List<CommentEntity> comments = commentRepository.getComments(postId);
        ArrayList<CommentVO> res = new ArrayList<>();
        for (CommentEntity c : comments) {
            CommentVO vo = new CommentVO();
            BeanUtil.copyProperties(c, vo);
            res.add(vo);
        }
        return res;
    }

    public boolean createComment(CommentVO vo) {
        return commentRepository.createComment(vo);
    }

    public boolean delComment(Long id) {
        return commentRepository.delComment(id);
    }
}

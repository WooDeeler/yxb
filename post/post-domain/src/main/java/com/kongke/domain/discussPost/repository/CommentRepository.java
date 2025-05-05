package com.kongke.domain.discussPost.repository;

import com.kongke.domain.discussPost.model.entity.CommentEntity;
import com.kongke.domain.discussPost.model.vo.CommentVO;

import java.util.List;

public interface CommentRepository {
    List<CommentEntity> getComments(Long postId);


    boolean createComment(CommentVO vo);

    boolean delComment(Long id);
}

package com.kongke.domain.discussPost.repository;


import com.kongke.domain.discussPost.model.entity.PostEntity;
import com.kongke.domain.discussPost.model.vo.PostVO;
import com.kongke.types.common.PageParam;

import java.util.List;

/**
 * 讨论帖子
 *
 * @author kongke
 * @date 2025/04/10
 */
public interface PostRepository {


    List<PostEntity> getPostList(PageParam page);

    // 创建帖子
    boolean createPost(PostEntity postEntity);

    // 更新帖子
    boolean updatePost(PostEntity postEntity);

    // 删除帖子
    boolean deletePost(Long pid);

    PostEntity getPostById(Long postId);
}

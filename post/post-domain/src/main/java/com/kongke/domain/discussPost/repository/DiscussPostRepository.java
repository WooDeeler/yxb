package com.kongke.domain.discussPost.repository;


import com.kongke.domain.discussPost.model.entity.DiscussPostEntity;
import com.kongke.types.common.PageParam;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 讨论帖子
 *
 * @author kongke
 * @date 2025/04/10
 */
public interface DiscussPostRepository {


    List<DiscussPostEntity> getDiscussPostList(PageParam page);

    // 创建帖子
    boolean createDiscussPost(DiscussPostEntity discussPostEntity);

    // 更新帖子
    boolean updateDiscussPost(DiscussPostEntity discussPostEntity);

    // 删除帖子
    boolean deleteDiscussPost(Long pid);
}

package com.kongke.domain.discussPost.service;

import com.kongke.domain.discussPost.model.entity.DiscussPostEntity;
import com.kongke.types.common.PageParam;

import java.util.List;

/**
 * 讨论帖子服务接口
 *
 * @author kongke
 * @date 2025/04/10
 */
public interface DiscussPostService {
    /**
     * 获取讨论帖子列表
     * @param page 分页参数
     * @return 帖子列表
     */
    List<DiscussPostEntity> getDiscussPostList(PageParam page);

    /**
     * 创建帖子
     * @param discussPostEntity 帖子信息
     * @return 创建是否成功
     */
    boolean createDiscussPost(DiscussPostEntity discussPostEntity);

    /**
     * 更新帖子
     * @param discussPostEntity 帖子信息
     * @return 更新是否成功
     */
    boolean updateDiscussPost(DiscussPostEntity discussPostEntity);

    /**
     * 删除帖子
     * @param pid 帖子ID
     * @return 删除是否成功
     */
    boolean deleteDiscussPost(Long pid);
}
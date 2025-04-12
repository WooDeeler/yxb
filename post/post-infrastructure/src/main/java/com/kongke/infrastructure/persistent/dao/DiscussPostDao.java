package com.kongke.infrastructure.persistent.dao;

import com.kongke.infrastructure.persistent.po.DiscussPostPO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mico
* @description 针对表【discuss_post】的数据库操作Service
* @createDate 2025-04-10 14:54:29
*/
public interface DiscussPostDao extends IService<DiscussPostPO> {
    /**
     * 获取讨论帖子列表
     * @param offset 偏移量
     * @param limit 限制数量
     * @return 帖子列表
     */
    List<DiscussPostPO> getDiscussPostList(int offset, int limit);

    /**
     * 创建讨论帖子
     * @param discussPostPO 帖子信息
     */
    boolean createDiscussPost(DiscussPostPO discussPostPO);

    /**
     * 更新讨论帖子
     * @param discussPostPO 帖子信息
     * @return 更新是否成功
     */
    boolean updateDiscussPost(DiscussPostPO discussPostPO);

    /**
     * 删除讨论帖子
     * @param pid 帖子ID
     * @return 删除是否成功
     */
    boolean deleteDiscussPost(Long pid);
}

package com.kongke.domain.discussPost.service;

import com.kongke.domain.discussPost.model.entity.DiscussPostEntity;
import com.kongke.domain.discussPost.repository.DiscussPostRepository;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 讨论帖子服务实现类
 *
 * @author kongke
 * @date 2025/04/10
 */
@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostRepository discussPostRepository;

    public List<DiscussPostEntity> getDiscussPostList(PageParam page) {
        return discussPostRepository.getDiscussPostList(page);
    }

    public boolean createDiscussPost(DiscussPostEntity discussPostEntity) {
        return discussPostRepository.createDiscussPost(discussPostEntity);
    }

    public boolean updateDiscussPost(DiscussPostEntity discussPostEntity) {
        return discussPostRepository.updateDiscussPost(discussPostEntity);
    }

    public boolean deleteDiscussPost(Long pid) {
        return discussPostRepository.deleteDiscussPost(pid);
    }
}
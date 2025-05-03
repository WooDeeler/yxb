package com.kongke.domain.discussPost.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.api.IUserService;
import com.kongke.api.dto.UserDTO;
import com.kongke.domain.discussPost.model.entity.PostEntity;
import com.kongke.domain.discussPost.model.vo.PostVO;
import com.kongke.domain.discussPost.repository.PostRepository;
import com.kongke.types.common.PageParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 讨论帖子服务实现类
 *
 * @author kongke
 * @date 2025/04/10
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @DubboReference(check = false, application = "user-service-provider")
    private IUserService userService;

    public List<PostVO> getPostList(PageParam page) {
        List<PostEntity> postList = postRepository.getPostList(page);
        List<PostVO> res = new ArrayList<>();
        UserDTO dto = userService.getUserById(1L);

        for (PostEntity post : postList) {
            PostVO postVO = new PostVO();
            BeanUtil.copyProperties(post, postVO);
            postVO.setUserName(dto.getUsername());
            postVO.setAvatar(dto.getAvatar());
            postVO.setUserUniversity(dto.getTargetUniversity());
            res.add(postVO);
        }
        return res;
    }

    public boolean createPost(PostEntity postEntity) {
        return postRepository.createPost(postEntity);
    }

    public boolean updatePost(PostEntity postEntity) {
        return postRepository.updatePost(postEntity);
    }

    public boolean deletePost(Long pid) {
        return postRepository.deletePost(pid);
    }

    public PostVO getPostById(Long postId) {
        PostEntity entity = postRepository.getPostById(postId);
        PostVO vo = new PostVO();
        BeanUtil.copyProperties(entity, vo);
        return vo;
    }
}
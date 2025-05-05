package com.kongke.domain.discussPost.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.api.IUserService;
import com.kongke.api.dto.UserDTO;
import com.kongke.domain.discussPost.model.entity.PostEntity;
import com.kongke.domain.discussPost.model.vo.PostVO;
import com.kongke.domain.discussPost.repository.PostRepository;
import com.kongke.types.common.PageParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
        List<Integer> uids = new ArrayList<>();
        postList.forEach(entity -> uids.add(entity.getAuthorId()));
        Map<Integer, UserDTO> map = userService.batchQueryByIds(uids);
        for (PostEntity post : postList) {
            UserDTO dto = map.get(post.getAuthorId());
            if (dto == null) {
                continue;
            }
            PostVO postVO = new PostVO();
            BeanUtil.copyProperties(post, postVO);
            postVO.setUserName(dto.getUsername());
            postVO.setAvatar(dto.getAvatar());
            postVO.setUserUniversity(dto.getTargetUniversity());
            res.add(postVO);
        }
        return res;
    }

    public boolean createPost(PostVO vo) {
        return postRepository.createPost(vo);
    }

    public boolean updatePost(PostVO vo) {
        return postRepository.updatePost(vo);
    }

    public boolean deletePost(Long pid) {
        return postRepository.deletePost(pid);
    }

    public PostVO getPostById(Long postId) {
        PostEntity entity = postRepository.getPostById(postId);
        if (entity == null){
            return null;
        }
        PostVO vo = new PostVO();
        UserDTO dto = userService.getUserById(entity.getAuthorId());
        BeanUtil.copyProperties(entity, vo);
        vo.setUserName(dto.getUsername());
        vo.setAvatar(dto.getAvatar());
        vo.setUserUniversity(dto.getTargetUniversity());
        return vo;
    }

    public List<PostVO> getPostByUid(Integer uid) {
        List<PostEntity> posts =  postRepository.getPostByUid(uid);
        List<PostVO> vos = new ArrayList<>();
        List<Integer> uids = new ArrayList<>();
        posts.forEach(entity -> uids.add(entity.getAuthorId()));
        Map<Integer, UserDTO> map = userService.batchQueryByIds(uids);
        for (PostEntity entity : posts) {
            PostVO vo = new PostVO();
            UserDTO dto = map.get(entity.getAuthorId());
            if (dto == null) {
                continue;
            }
            BeanUtil.copyProperties(entity, vo);
            vo.setUserName(dto.getUsername());
            vo.setAvatar(dto.getAvatar());
            vo.setUserUniversity(dto.getTargetUniversity());
            vos.add(vo);
        }
        return vos;
    }
}
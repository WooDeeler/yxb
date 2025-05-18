package com.kongke.domain.discussPost.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.api.IUserService;
import com.kongke.api.dto.UserDTO;
import com.kongke.domain.discussPost.model.entity.CommentEntity;
import com.kongke.domain.discussPost.model.vo.CommentVO;
import com.kongke.domain.discussPost.repository.CommentRepository;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @DubboReference(check = false, application = "user-service-provider")
    private IUserService userService;

    public List<CommentVO> getComments(Long postId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<CommentEntity> comments = commentRepository.getComments(postId);
        ArrayList<Integer> uids = new ArrayList<>();
        for (CommentEntity c: comments){
            if (c.getUid() != null){
                uids.add(c.getUid());
            }
        }

        Map<Integer, UserDTO> map = new HashMap<>();
        if (!uids.isEmpty()){
            map = userService.batchQueryByIds(uids);
        }
        ArrayList<CommentVO> res = new ArrayList<>();
        for (CommentEntity c : comments) {
            CommentVO vo = new CommentVO();
            BeanUtil.copyProperties(c, vo);
            vo.setCreateTime(sdf.format(c.getCreateTime()));
            if (c.getUid() > 0){
                vo.setUsername(map.get(c.getUid()).getUsername());
                vo.setAvatar(map.get(c.getUid()).getAvatar());
            }
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

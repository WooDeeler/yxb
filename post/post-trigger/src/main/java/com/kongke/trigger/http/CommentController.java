package com.kongke.trigger.http;

import com.kongke.domain.discussPost.model.vo.CommentVO;
import com.kongke.domain.discussPost.service.CommentService;
import com.kongke.types.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 评论接口
 *
 * @author kongke
 * @date 2025/05/04
 */
@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获取评论列表
     *
     * @param postId 帖子 ID
     * @return {@link Result }<{@link List }<{@link CommentVO }>>
     */
    @GetMapping("/comments")
    public Result<List<CommentVO>> getComments(@RequestParam("postId") Long postId) {
        return Result.success(commentService.getComments(postId));
    }

    /**
     * 创建评论
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/createComment")
    public Result<Boolean> createComment(@RequestBody CommentVO vo) {
        return Result.success(commentService.createComment(vo));
    }

    /**
     * 删除评论
     *
     * @param id 身份证
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/delComment")
    public Result<Boolean> deleteComment(@RequestParam("commentId") Long id) {
        return commentService.delComment(id) ? Result.success(true) : Result.failed("删除评论失败");
    }
}

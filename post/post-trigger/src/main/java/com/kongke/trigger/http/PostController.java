package com.kongke.trigger.http;

import com.kongke.domain.discussPost.model.entity.PostEntity;
import com.kongke.domain.discussPost.model.vo.PostVO;
import com.kongke.domain.discussPost.service.PostService;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 帖子接口
 *
 * @author kongke
 * @date 2025/04/10
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 获取帖子列表
     *
     * @param page 分页参数
     * @return 帖子列表
     */
    @PostMapping("/list")
    public Result<List<PostVO>> getPosts(@RequestBody PageParam page) {
        List<PostVO> posts = postService.getPostList(page);
        return Result.success(posts);
    }

    /**
     * 按 ID 获取帖子
     *
     * @param postId 帖子 ID
     * @return {@link Result }<{@link PostVO }>
     */
    @PostMapping("/detail")
    public Result<PostVO> getPostById(@RequestParam("postId") Long postId){
        return Result.success(postService.getPostById(postId));
    }

    /**
     * 查询用户帖子
     *
     * @param uid uid
     * @return {@link Result }<{@link List }<{@link PostVO }>>
     */
    @PostMapping("/userPost")
    public Result<List<PostVO>> getPostByUid(@RequestParam("uid") Integer uid){
        return Result.success(postService.getPostByUid(uid));
    }

    /**
     * 创建帖子
     *
     * @param post 帖子信息
     * @return 创建结果
     */
    @PostMapping("/create")
    public Result<Void> createPost(@RequestBody PostVO post) {
        boolean success = postService.createPost(post);
        return success ? Result.success() : Result.failed("创建帖子失败");
    }

    /**
     * 更新帖子
     *
     * @param post   帖子信息
     * @return 更新结果
     */
    @PostMapping("/update")
    public Result<Void> updatePost(@RequestBody PostVO post) {
        boolean success = postService.updatePost(post);
        return success ? Result.success() : Result.failed("更新帖子失败");
    }

    /**
     * 删除帖子
     *
     * @param postId 帖子ID
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Result<Void> deletePost(@RequestParam("postId") Long postId) {
        boolean success = postService.deletePost(postId);
        return success ? Result.success() : Result.failed("删除帖子失败");
    }
}
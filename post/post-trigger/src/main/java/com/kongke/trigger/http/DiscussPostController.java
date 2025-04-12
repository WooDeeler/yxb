package com.kongke.trigger.http;

import com.kongke.domain.discussPost.model.entity.DiscussPostEntity;
import com.kongke.domain.discussPost.service.DiscussPostService;
import com.kongke.types.common.PageParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * POST 控制器
 *
 * @author kongke
 * @date 2025/04/10
 */
@RestController
@RequestMapping("/discuss")
public class DiscussPostController {
    private final DiscussPostService discussPostService;

    public DiscussPostController(DiscussPostService discussPostService) {
        this.discussPostService = discussPostService;
    }

    /**
     * 获取帖子列表
     *
     * @param page 分页参数
     * @return 帖子列表
     */
    @PostMapping("/posts/list")
    public Result<List<DiscussPostEntity>> getDiscussPosts(@RequestBody PageParam page) {
        List<DiscussPostEntity> posts = discussPostService.getDiscussPostList(page);
        return Result.success(posts);
    }

    /**
     * 创建帖子
     *
     * @param post 帖子信息
     * @return 创建结果
     */
    @PostMapping("/posts")
    public Result<Void> createDiscussPost(@RequestBody DiscussPostEntity post) {
        boolean success = discussPostService.createDiscussPost(post);
        return success ? Result.success() : Result.failed("创建帖子失败");
    }

    /**
     * 更新帖子
     *
     * @param post   帖子信息
     * @return 更新结果
     */
    @PostMapping("/posts/update")
    public Result<Void> updateDiscussPost(@RequestBody DiscussPostEntity post) {
        boolean success = discussPostService.updateDiscussPost(post);
        return success ? Result.success() : Result.failed("更新帖子失败");
    }

    /**
     * 删除帖子
     *
     * @param postId 帖子ID
     * @return 删除结果
     */
    @PostMapping("/posts/delete/{postId}")
    public Result<Void> deleteDiscussPost(@PathVariable("postId") Long postId) {
        boolean success = discussPostService.deleteDiscussPost(postId);
        return success ? Result.success() : Result.failed("删除帖子失败");
    }
}
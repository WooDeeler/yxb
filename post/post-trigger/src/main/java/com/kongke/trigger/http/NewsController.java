package com.kongke.trigger.http;

import com.kongke.domain.discussPost.model.vo.NewsVO;
import com.kongke.domain.discussPost.service.NewsService;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 新闻接口
 *
 * @author kongke
 * @date 2025/05/04
 */
@RequestMapping("/news")
@RestController
public class NewsController {

    @Autowired
    private NewsService service;

    /**
     * 查询新闻列表
     *
     * @param pageParam 分页参数
     * @return {@link Result}<{@link List}<{@link NewsVO}>>
     */
    @PostMapping("/list")
    public Result<List<NewsVO>> listNews(@RequestBody PageParam pageParam) {
        return Result.success(service.listNews(pageParam));
    }

    /**
     * 根据ID查询新闻
     *
     * @param id 身份证
     * @return {@link Result }<{@link NewsVO }>
     */
    @PostMapping("/detail")
    public Result<NewsVO> getDetail(@RequestParam("id") Integer id) {
        return Result.success(service.getById(id));
    }

    /**
     * 创建新闻
     *
     * @param news 新闻对象
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/create")
    public Result<Boolean> createNews(@RequestBody NewsVO news) {
        return Result.success(service.createNews(news));
    }

    /**
     * 更新新闻
     *
     * @param news 新闻对象
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/update")
    public Result<Boolean> updateNews(@RequestBody NewsVO news) {
        if (news == null || news.getId() == null)
            return Result.failed("新闻ID不能为空");
        return Result.success(service.updateNews(news));
    }

    /**
     * 删除新闻
     *
     * @param id 新闻ID
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/delete")
    public Result<Boolean> deleteNews(@RequestParam("id") Integer id) {
        return Result.success(service.deleteNews(id));
    }
}

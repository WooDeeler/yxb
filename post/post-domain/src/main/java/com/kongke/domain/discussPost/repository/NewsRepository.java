package com.kongke.domain.discussPost.repository;

import com.kongke.domain.discussPost.model.entity.NewsEntity;
import com.kongke.domain.discussPost.model.vo.NewsVO;
import com.kongke.types.common.PageParam;

import java.util.List;

public interface NewsRepository {
    List<NewsEntity> listNews(PageParam pageParam);

    boolean createNews(NewsVO news);

    boolean updateNews(NewsVO news);

    boolean deleteNews(Integer id);

    NewsEntity getById(Integer id);
}

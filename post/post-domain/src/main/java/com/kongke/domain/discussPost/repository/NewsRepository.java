package com.kongke.domain.discussPost.repository;

import com.kongke.domain.discussPost.model.dto.ConditionReq;
import com.kongke.domain.discussPost.model.dto.PageQueryRsp;
import com.kongke.domain.discussPost.model.entity.NewsEntity;
import com.kongke.domain.discussPost.model.vo.NewsVO;
import com.kongke.types.common.PageParam;

import java.util.List;

public interface NewsRepository {
    PageQueryRsp<NewsEntity> listNews(PageParam pageParam);

    boolean createNews(NewsVO news);

    boolean updateNews(NewsVO news);

    boolean deleteNews(Integer id);

    NewsEntity getById(Integer id);

    PageQueryRsp<NewsEntity> query(ConditionReq req);
}

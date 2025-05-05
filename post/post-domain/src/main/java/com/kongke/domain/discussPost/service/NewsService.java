package com.kongke.domain.discussPost.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.domain.discussPost.model.entity.NewsEntity;
import com.kongke.domain.discussPost.model.vo.NewsVO;
import com.kongke.domain.discussPost.repository.NewsRepository;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsVO> listNews(PageParam pageParam) {
        List<NewsEntity> entities = newsRepository.listNews(pageParam);
        List<NewsVO> vos = new ArrayList<>();
        for(NewsEntity e : entities) {
            NewsVO vo = new NewsVO();
            BeanUtil.copyProperties(e, vo);
            vos.add(vo);
        }
        return vos;
    }

    public boolean createNews(NewsVO news) {
        return newsRepository.createNews(news);
    }

    public boolean updateNews(NewsVO news) {
        return newsRepository.updateNews(news);
    }

    public boolean deleteNews(Integer id) {
        return newsRepository.deleteNews(id);
    }

    public NewsVO getById(Integer id) {
        NewsEntity entity = newsRepository.getById(id);
        if (entity == null)
            return null;
        NewsVO vo = new NewsVO();
        BeanUtil.copyProperties(entity, vo);
        return vo;
    }
}

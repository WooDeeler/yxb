package com.kongke.domain.discussPost.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.api.IUniversityService;
import com.kongke.api.IUserService;
import com.kongke.domain.discussPost.model.dto.ConditionReq;
import com.kongke.domain.discussPost.model.dto.PageQueryRsp;
import com.kongke.domain.discussPost.model.entity.NewsEntity;
import com.kongke.domain.discussPost.model.vo.NewsVO;
import com.kongke.domain.discussPost.repository.NewsRepository;
import com.kongke.types.common.PageParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public PageQueryRsp<NewsVO> listNews(PageParam pageParam) {
        PageQueryRsp<NewsEntity> rsp = newsRepository.listNews(pageParam);
        List<NewsEntity> entities = rsp.getList();
        List<NewsVO> vos = new ArrayList<>();
        for(NewsEntity e : entities) {
            NewsVO vo = new NewsVO();
            BeanUtil.copyProperties(e, vo);
            vos.add(vo);
        }
        return new PageQueryRsp<>(rsp.getTotal(), vos);
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

    public PageQueryRsp<NewsVO> condQuery(ConditionReq req) {
        PageQueryRsp<NewsEntity> rsp =  newsRepository.query(req);
        List<NewsEntity> entities = rsp.getList();
        List<NewsVO> vos = new ArrayList<>();
        for(NewsEntity e : entities) {
            NewsVO vo = new NewsVO();
            BeanUtil.copyProperties(e, vo);
            vos.add(vo);
        }
        return new PageQueryRsp<>(rsp.getTotal(), vos);
    }
}

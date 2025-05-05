package com.kongke.infrastructure.persistent.repository;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.domain.discussPost.model.entity.NewsEntity;
import com.kongke.domain.discussPost.model.entity.PostEntity;
import com.kongke.domain.discussPost.model.vo.NewsVO;
import com.kongke.domain.discussPost.repository.NewsRepository;
import com.kongke.infrastructure.persistent.dao.NewsDao;
import com.kongke.infrastructure.persistent.po.NewsPO;
import com.kongke.infrastructure.persistent.po.PostPO;
import com.kongke.types.common.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class INewsRepository implements NewsRepository {

    @Autowired
    private NewsDao newsDao;

    private NewsPO VOConvertToPO(NewsVO vo) {
        if (vo == null) {
            return null;
        }
        NewsPO po = new NewsPO();
        BeanUtil.copyProperties(vo, po);
        return po;
    }

    private NewsEntity convertToEntity(NewsPO po) {
        if (po == null) {
            return null;
        }
        NewsEntity entity = new NewsEntity();
        BeanUtil.copyProperties(po, entity);
        return entity;
    }

    @Override
    public List<NewsEntity> listNews(PageParam pageParam) {
        if (pageParam == null)
            return Collections.emptyList();
        Page<NewsPO> page = new Page<>(pageParam.getPage(), pageParam.getSize());
        Page<NewsPO> res = newsDao.page(page);
        if (res.getRecords().isEmpty()) {
            return Collections.emptyList();
        }
        return res.getRecords().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public boolean createNews(NewsVO news) {
        return newsDao.save(VOConvertToPO(news));
    }

    @Override
    public boolean updateNews(NewsVO news) {
        return newsDao.updateById(VOConvertToPO(news));
    }

    @Override
    public boolean deleteNews(Integer id) {
        return newsDao.removeById(id);
    }

    @Override
    public NewsEntity getById(Integer id) {
        return convertToEntity(newsDao.getById(id));
    }
}

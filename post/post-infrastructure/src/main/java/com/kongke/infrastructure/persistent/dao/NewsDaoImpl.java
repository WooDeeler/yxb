package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.po.NewsPO;
import com.kongke.infrastructure.persistent.mapper.NewsMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【news】的数据库操作Service实现
* @createDate 2025-05-04 17:43:28
*/
@Service
public class NewsDaoImpl extends ServiceImpl<NewsMapper, NewsPO>
    implements NewsDao {

}





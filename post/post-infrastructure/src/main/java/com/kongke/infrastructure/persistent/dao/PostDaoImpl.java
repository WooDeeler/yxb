package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.mapper.PostMapper;
import com.kongke.infrastructure.persistent.po.PostPO;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【posts】的数据库操作Service实现
* @createDate 2025-05-04 00:07:44
*/
@Service
public class PostDaoImpl extends ServiceImpl<PostMapper, PostPO>
    implements PostDao {

}





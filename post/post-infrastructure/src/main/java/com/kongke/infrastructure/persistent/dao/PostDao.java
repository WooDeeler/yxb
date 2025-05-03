package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kongke.infrastructure.persistent.po.PostPO;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【posts】的数据库操作Service
* @createDate 2025-05-04 00:07:44
*/
public interface PostDao extends IService<PostPO> {

}

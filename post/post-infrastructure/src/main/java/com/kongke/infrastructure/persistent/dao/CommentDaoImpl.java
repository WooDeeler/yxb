package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.po.CommentPO;
import com.kongke.infrastructure.persistent.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【comments】的数据库操作Service实现
* @createDate 2025-05-04 15:24:30
*/
@Service
public class CommentDaoImpl extends ServiceImpl<CommentMapper, CommentPO>
    implements CommentDao {

}





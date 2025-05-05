package com.kongke.infrastructure.persistent.mapper;

import com.kongke.infrastructure.persistent.po.CommentPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【comments】的数据库操作Mapper
* @createDate 2025-05-04 15:24:30
* @Entity com.kongke.infrastructure.persistent.po.CommentPO
*/
@Mapper
public interface CommentMapper extends BaseMapper<CommentPO> {

}





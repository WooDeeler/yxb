package com.kongke.infrastructure.persistent.mapper;

import com.kongke.infrastructure.persistent.po.PostPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【posts】的数据库操作Mapper
* @createDate 2025-05-04 00:07:44
* @Entity com.kongke.infrastructure.persistent.po.PostPO
*/
@Mapper
public interface PostMapper extends BaseMapper<PostPO> {

}





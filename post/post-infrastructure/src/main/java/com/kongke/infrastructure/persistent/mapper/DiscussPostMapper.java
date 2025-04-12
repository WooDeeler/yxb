package com.kongke.infrastructure.persistent.mapper;

import com.kongke.infrastructure.persistent.po.DiscussPostPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【discuss_post】的数据库操作Mapper
* @createDate 2025-04-10 14:54:29
* @Entity com.kongke.infrastructure.persistent.po.DiscussPostPO
*/
@Mapper
public interface DiscussPostMapper extends BaseMapper<DiscussPostPO> {

}





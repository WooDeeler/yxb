package com.kongke.infrastructure.persistent.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kongke.infrastructure.persistent.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author kongke
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-04-06 01:59:29
* @Entity com.kongke.infrastructure.persistent.po.UserPO
*/
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}





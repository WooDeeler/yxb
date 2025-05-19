package com.kongke.infrastructure.persistent.mapper;

import com.kongke.infrastructure.persistent.po.GroupListPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【group_list】的数据库操作Mapper
* @createDate 2025-05-18 17:53:25
* @Entity com.kongke.infrastructure.persistent.po.GroupListPO
*/
@Mapper
public interface GroupListMapper extends BaseMapper<GroupListPO> {

}





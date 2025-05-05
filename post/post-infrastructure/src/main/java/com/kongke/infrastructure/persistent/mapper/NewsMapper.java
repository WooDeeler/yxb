package com.kongke.infrastructure.persistent.mapper;

import com.kongke.infrastructure.persistent.po.NewsPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【news】的数据库操作Mapper
* @createDate 2025-05-04 17:43:28
* @Entity com.kongke.infrastructure.persistent.po.NewsPO
*/
@Mapper
public interface NewsMapper extends BaseMapper<NewsPO> {

}





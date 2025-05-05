package com.kongke.infrastructure.mapper;

import com.kongke.infrastructure.po.UniversityPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【university_info】的数据库操作Mapper
* @createDate 2025-05-04 19:11:12
* @Entity com.kongke.infrastructure.po.UniversityPO
*/
@Mapper
public interface UniversityMapper extends BaseMapper<UniversityPO> {

}





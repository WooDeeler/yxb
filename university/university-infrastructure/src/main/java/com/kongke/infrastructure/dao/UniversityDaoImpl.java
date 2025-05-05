package com.kongke.infrastructure.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.po.UniversityPO;
import com.kongke.infrastructure.mapper.UniversityMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【university_info】的数据库操作Service实现
* @createDate 2025-05-04 19:11:12
*/
@Service
public class UniversityDaoImpl extends ServiceImpl<UniversityMapper, UniversityPO>
    implements UniversityDao {

}





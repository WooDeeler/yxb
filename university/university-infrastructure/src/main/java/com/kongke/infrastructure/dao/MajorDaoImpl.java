package com.kongke.infrastructure.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.po.MajorPO;
import com.kongke.infrastructure.mapper.MajorMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【major】的数据库操作Service实现
* @createDate 2025-05-05 16:07:05
*/
@Service
public class MajorDaoImpl extends ServiceImpl<MajorMapper, MajorPO>
    implements MajorDao {

}





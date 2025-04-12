package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kongke.infrastructure.persistent.po.UserPO;
import org.springframework.stereotype.Service;

@Service
public interface UserDao extends IService<UserPO> {

}

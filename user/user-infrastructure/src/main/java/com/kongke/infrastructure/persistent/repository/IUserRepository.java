package com.kongke.infrastructure.persistent.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kongke.domain.userlogin.model.entity.UserEntity;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.repository.UserRepository;
import com.kongke.infrastructure.persistent.dao.UserDao;

import cn.hutool.core.bean.BeanUtil;

import com.kongke.infrastructure.persistent.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IUserRepository implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public UserVO getUserById(Integer id) {
        UserPO po = userDao.getById(id);
        UserVO vo = new UserVO();
        BeanUtil.copyProperties(po, vo);
        return vo;
    }

    @Override
    public List<UserVO> getUsersByPage(int page, int size) {
        Page<UserPO> pageParam = new Page<>(page, size);
        Page<UserPO> pageResult = userDao.page(pageParam);
        return pageResult.getRecords().stream()
                .map(po -> {
                    UserVO vo = new UserVO();
                    BeanUtil.copyProperties(po, vo);
                    return vo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserPO po = userDao.lambdaQuery()
                .eq(UserPO::getUsername, username)
                .one();
        if (po == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        BeanUtil.copyProperties(po, entity);
        return entity;
    }

    @Override
    public Boolean upsertProfile(UserVO vo) {
        UserPO po = new UserPO();
        BeanUtil.copyProperties(vo, po);
        return userDao.updateById(po);
    }

    @Override
    public List<UserEntity> batchQueryByIds(List<Integer> ids) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(UserPO::getId, ids);
        List<UserPO> pos = userDao.list(wrapper);
        ArrayList<UserEntity> entities = new ArrayList<>();
        for (UserPO po : pos) {
            UserEntity entity = new UserEntity();
            BeanUtil.copyProperties(po, entity);
            entities.add(entity);
        }
        return entities;
    }
}

package com.kongke.infrastructure.persistent.mapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.po.DiscussPostPO;
import com.kongke.infrastructure.persistent.dao.DiscussPostDao;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @author kongke
* @description 针对表【discuss_post】的数据库操作Service实现
* @createDate 2025-04-10 14:54:29
*/
@Service
public class DiscussPostDaoImpl extends ServiceImpl<DiscussPostMapper, DiscussPostPO>
    implements DiscussPostDao {

    @Override
    public List<DiscussPostPO> getDiscussPostList(int offset, int limit) {
        return lambdaQuery()
                .last(String.format("LIMIT %d,%d", offset, limit))
                .list();
    }

    @Override
    public boolean createDiscussPost(DiscussPostPO discussPostPO) {
        return save(discussPostPO);
    }

    @Override
    public boolean updateDiscussPost(DiscussPostPO discussPostPO) {
        return updateById(discussPostPO);
    }

    @Override
    public boolean deleteDiscussPost(Long pid) {
        return removeById(pid);
    }
}





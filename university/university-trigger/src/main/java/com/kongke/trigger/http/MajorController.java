package com.kongke.trigger.http;

import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.vo.MajorVO;
import com.kongke.domain.univ.service.MajorService;
import com.kongke.types.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专业信息接口
 *
 * @author kongke
 * @date 2025/05/05
 */
@RequestMapping("/major")
@RestController
public class MajorController {


    @Autowired
    private MajorService majorService;

    /**
     * 新增专业信息
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody MajorVO vo) {
        return Result.success(majorService.add(vo));
    }

    /**
     * 更新专业信息
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody MajorVO vo) {
        if (vo == null || vo.getId() == null)
            return Result.failed("参数错误");
        return Result.success(majorService.update(vo));
    }

    /**
     * 删除专业信息
     *
     * @param id id
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam("id") Integer id) {
        return Result.success(majorService.delete(id));
    }

    /**
     * 查询专业信息
     *
     * @param req 要求
     * @return {@link Result }<{@link List }<{@link MajorVO }>>
     */
    @PostMapping("/condQuery")
    public Result<PageQueryRsp<MajorVO>> Query(@RequestBody ConditionReq req) {
        return Result.success(majorService.conditionQuery(req));
    }


}

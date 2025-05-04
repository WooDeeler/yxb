package com.kongke.trigger.http;

import com.kongke.domain.univ.model.vo.UniversityVO;
import com.kongke.domain.univ.service.UniversityService;
import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.types.common.PageParam;
import com.kongke.types.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 院校接口
 *
 * @author kongke
 * @date 2025/05/04
 */
@RequestMapping("/univ")
@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    /**
     * 分页查询院校信息
     *
     * @param pageParam page 参数
     * @return {@link Result }<{@link List }<{@link UniversityVO }>>
     */
    @PostMapping("/page")
    public Result<List<UniversityVO>> page(@RequestBody PageParam pageParam) {
        return Result.success(universityService.pageList(pageParam));
    }

    /**
     * 按 ID 查询院校信息
     *
     * @param id id
     * @return {@link Result }<{@link UniversityVO }>
     */
    @PostMapping("/getById")
    public Result<UniversityVO> getById(@RequestParam("id") Integer id) {
        return Result.success(universityService.getById(id));
    }

    /**
     * 条件查询院校信息
     *
     * @param req 要求
     * @return {@link Result }<{@link List }<{@link UniversityVO }>>
     */
    @PostMapping("/condQuery")
    public Result<List<UniversityVO>> conditionQuery(@RequestBody ConditionReq req) {
        return Result.success(universityService.conditionQuery(req));
    }

    /**
     * 新增院校信息
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody UniversityVO vo) {
        return Result.success(universityService.addUniv(vo));
    }

    /**
     * 更新院校信息
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody UniversityVO vo) {
        if (vo == null || vo.getId() == null)
            return Result.failed("参数错误");
        return Result.success(universityService.update(vo));
    }

    /**
     * 删除院校信息
     *
     * @param id id
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam("id") Integer id) {
        return Result.success(universityService.delete(id));
    }

}

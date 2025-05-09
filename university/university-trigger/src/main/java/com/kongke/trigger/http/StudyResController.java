package com.kongke.trigger.http;

import com.kongke.domain.univ.model.dto.ConditionReq;
import com.kongke.domain.univ.model.dto.PageQueryRsp;
import com.kongke.domain.univ.model.vo.StudyResVO;
import com.kongke.domain.univ.service.StudyResService;
import com.kongke.types.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学习资料接口
 *
 * @author kongke
 * @date 2025/05/05
 */
@RequestMapping("/study")
@RestController
public class StudyResController {

    @Autowired
    private StudyResService studyResService;

    /**
     * 查询学习资料
     *
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/query")
    public Result<PageQueryRsp<StudyResVO>> query(@RequestBody ConditionReq req) {
        return Result.success(studyResService.query(req));
    }

    /**
     * 删除学习资料
     *
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam Integer id) {
        return Result.success(studyResService.delete(id));
    }


    /**
     * 添加学习资料
     *
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody StudyResVO vo) {
        return Result.success(studyResService.add(vo));
    }


}

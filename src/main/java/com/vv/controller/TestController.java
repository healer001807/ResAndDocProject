package com.vv.controller;

import com.vv.pojo.TemplateDocVo;
import com.vv.util.ResUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kw
 * @program ResAndDocProject
 * @description 接口文档模板案例api
 * @create 2023 - 12 - 05 20:55
 **/
@Tag(name = "TestController", description = "模板案例api")
@RestController
@RequestMapping("test")
public class TestController {

    @Operation(summary = "test", description = "模板案例方法")
    @PostMapping
    public ResUtils test(@RequestBody TemplateDocVo templateDocVo) {
        return ResUtils.success();
    }
}

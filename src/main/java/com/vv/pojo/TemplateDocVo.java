package com.vv.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kw
 * @program ResAndDocProject
 * @description 实体模板
 * @create 2023 - 12 - 16 11:24
 **/
@Schema(description = "模板demo实体", name = "TemplateDocVo")
@Setter
@Getter
public class TemplateDocVo {

    @Schema(name = "templateId", description = "模板编号")
    private String templateId;
    @Schema(name = "templateId", description = "模板名称")
    private String templateName;
}

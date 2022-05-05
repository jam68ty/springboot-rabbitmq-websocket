package com.example.websocketrabbitmqdemo.dto.response.cases;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "caseDTO")
public class CasesResponse {

    @ApiModelProperty(value = "case編號", position = 0)
    private String caseId;

    @ApiModelProperty(value = "BU", position = 1)
    private String BU;

    @ApiModelProperty(value = "case類型", position = 2)
    private String caseType;

    @ApiModelProperty(value = "參考編號", position = 3)
    private String referenceNo;

    @ApiModelProperty(value = "附件", position = 4)
    private String attachment;

    @ApiModelProperty(value = "描述", position = 5)
    private String description;

    @ApiModelProperty(value = "建立日期", position = 6, example = "0")
    private Long createdDate;

    @ApiModelProperty(value = "更新日期", position = 7, example = "0")
    private Long lastModifiedDate;
}

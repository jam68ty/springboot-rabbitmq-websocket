package com.example.websocketrabbitmqdemo.dto.request.cases;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "caseDTO")
public class CasesRequest {

    @ApiModelProperty(value = "BU", required = true, position = 1)
    private String BU;

    @ApiModelProperty(value = "case類型", required = true, position = 2)
    private String caseType;

    @ApiModelProperty(value = "參考編號", required = true, position = 3)
    private String referenceNo;

    @ApiModelProperty(value = "附件", position = 4)
    private String attachment;

    @ApiModelProperty(value = "描述", position = 5)
    private String description;

}

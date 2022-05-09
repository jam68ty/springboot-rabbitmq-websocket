package com.example.websocketrabbitmqdemo.dto.request.defaultmessage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "default message DTO")
public class DefaultMessageRequest {
    @ApiModelProperty(value = "商戶 id", required = true, position = 0)
    private String merchantId;

    @ApiModelProperty(value = "BU (AllBUs[both], HKTVmall, ESSE)", required = true, position = 1)
    private String BU;

    @ApiModelProperty(value = "預設訊息類型 (greeting, quickReply)", required = true, position = 2)
    private String defaultMessageType;

    @ApiModelProperty(value = "標題", required = true, position = 3)
    private String title;

    @ApiModelProperty(value = "描述", required = true, position = 4)
    private String description;

    @ApiModelProperty(value = "訊息內容", required = true, position = 5)
    private String message;
}

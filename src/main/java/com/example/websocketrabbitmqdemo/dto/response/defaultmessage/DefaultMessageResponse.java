package com.example.websocketrabbitmqdemo.dto.response.defaultmessage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "default message DTO")
public class DefaultMessageResponse {

    @ApiModelProperty(value = "預設訊息 id", position = 0)
    private String defaultMessageId;

    @ApiModelProperty(value = "商戶 id", position = 1)
    private String merchantId;

    @ApiModelProperty(value = "BU", position = 2)
    private String BU;

    @ApiModelProperty(value = "預設訊息類型", position = 3)
    private String defaultMessageType;

    @ApiModelProperty(value = "標題", position = 4)
    private String title;

    @ApiModelProperty(value = "描述", position = 5)
    private String description;

    @ApiModelProperty(value = "訊息內容", position = 6)
    private String message;

    @ApiModelProperty(value = "建立日期", position = 7, example = "0")
    private Long createdDate;

    @ApiModelProperty(value = "更新日期", position = 8, example = "0")
    private Long lastModifiedDate;
}

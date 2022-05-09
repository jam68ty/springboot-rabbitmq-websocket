package com.example.websocketrabbitmqdemo.dto.response.defaultmessage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "default message DTO")
public class DefaultMessageResponse {

    @ApiModelProperty(value = "預設訊息 id", position = 0)
    private String defaultMessageId;

    @ApiModelProperty(value = "商戶 id", position = 1)
    private String merchantId;

    @ApiModelProperty(value = "BU (AllBUs[both], HKTVmall, ESSE)", position = 2)
    private String BU;

    @ApiModelProperty(value = "預設訊息類型 (greeting, quickReply)", position = 3)
    private String defaultMessageType;

    @ApiModelProperty(value = "標題", position = 4)
    private String title;

    @ApiModelProperty(value = "描述", position = 5)
    private String description;

    @ApiModelProperty(value = "訊息內容", position = 6)
    private String message;

    @ApiModelProperty(value = "建立日期", position = 7)
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "更新日期", position = 8)
    private LocalDateTime lastModifiedDate;
}

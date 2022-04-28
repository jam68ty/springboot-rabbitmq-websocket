package com.example.websocketrabbitmqdemo.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "test")
public class DialogueRequest {
    @ApiModelProperty(value = "出價類別", required = true)
    private String listModeId;

    @ApiModelProperty(value = "發送人id", required = true)
    private String sendUserId;

    @ApiModelProperty(value = "接收人id", required = true)
    private String receiveUserId;

    @ApiModelProperty(value = "接收者已讀", required = true)
    private boolean receiverReaded;

    @ApiModelProperty(value = "對話類型(C:文字/I:圖片/M:系統訊息/D:系統敘述)", required = true)
    private String type;

    @ApiModelProperty(value = "對話內容", required = true)
    private String content;

}

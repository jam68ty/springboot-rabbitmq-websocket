package com.example.websocketrabbitmqdemo.dto.response.chat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "對話記錄")
public class DialogueResponse {
    @ApiModelProperty(value = "對話編號", position = 0)
    private String dialogueId;

    @ApiModelProperty(value = "發送人id", position = 1)
    private String sendUserId;

    @ApiModelProperty(value = "接收人id", position = 2)
    private String receiveUserId;

    @ApiModelProperty(value = "接收人已讀", position = 3)
    private boolean receiverReaded;

    @ApiModelProperty(value = "發送人刪除", position = 4)
    private boolean senderDeleted;

    @ApiModelProperty(value = "接收人刪除", position = 5)
    private boolean receiverDeleted;

    @ApiModelProperty(value = "對話類型(C:文字/I:圖片/M:系統訊息)", position = 6)
    private String type;

    @ApiModelProperty(value = "對話內容", position = 7)
    private String content;

    @ApiModelProperty(value = "是否顯示", position = 8)
    private boolean show;

    @ApiModelProperty(value = "更新日期", position = 10, example = "0")
    private Long lastModifiedDate;
}

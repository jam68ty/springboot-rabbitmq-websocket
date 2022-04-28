package com.example.websocketrabbitmqdemo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "對話記錄")
public class DialogueResponse {
    @ApiModelProperty(value = "對話編號", position = 0)
    private String dialogueId;

    @ApiModelProperty(value = "發送人id", position = 5)
    private String sendUserId;

    @ApiModelProperty(value = "接收人id", position = 6)
    private String receiveUserId;

    @ApiModelProperty(value = "接收人已讀", position = 7)
    private boolean receiverReaded;

    @ApiModelProperty(value = "發送人刪除", position = 8)
    private boolean senderDeleted;

    @ApiModelProperty(value = "接收人刪除", position = 9)
    private boolean receiverDeleted;

    @ApiModelProperty(value = "對話類型(C:文字/I:圖片/M:系統訊息)", position = 10)
    private String type;

    @ApiModelProperty(value = "對話內容", position = 11)
    private String content;

    @ApiModelProperty(value = "是否顯示", position = 12)
    private boolean show;

    @ApiModelProperty(value = "建立日期", position = 15)
    private Long createdDate;

    @ApiModelProperty(value = "更新日期", position = 16)
    private Long lastModifiedDate;
}

package com.example.websocketrabbitmqdemo.dto.response.chat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "對話記錄")
public class DialogueResponse {
    @ApiModelProperty(value = "對話編號", position = 0)
    private String dialogueId;

    @ApiModelProperty(value = "發送人id", position = 1)
    private String senderUserId;

    @ApiModelProperty(value = "接收人id", position = 2)
    private String receiverUserId;

    @ApiModelProperty(value = "發送人已讀", position = 3)
    private boolean senderReaded;

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

    @ApiModelProperty(value = "更新日期", position = 9)
    private LocalDateTime lastModifiedDate;

    @ApiModelProperty(value = "聊天室ID", position = 10)
    private String chatroomId;
}

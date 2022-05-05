package com.example.websocketrabbitmqdemo.dto.response.chat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "chatroomListDTO")

public class ChatroomListResponse {

    @ApiModelProperty(value = "聊天室編號", position = 0)
    private String chatroomId;

    @ApiModelProperty(value = "使用者 id", position = 1)
    private String userId;

    @ApiModelProperty(value = "接收人 id", position = 2)
    private String receiverUserId;

    @ApiModelProperty(value = "最新一筆聊天紀錄", position = 3)
    private String latestDialogueId;

    @ApiModelProperty(value = "更新日期", position = 4)
    private LocalDateTime lastModifiedDate;
}

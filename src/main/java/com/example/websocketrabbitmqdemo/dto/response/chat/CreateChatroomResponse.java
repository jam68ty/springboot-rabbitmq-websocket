package com.example.websocketrabbitmqdemo.dto.response.chat;

import com.example.websocketrabbitmqdemo.dao.entity.TriggerEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "createChatroomDTO")
public class CreateChatroomResponse {
    @ApiModelProperty(value = "聊天室編號", position = 0)
    private String chatroomId;

    @ApiModelProperty(value = "發送人 id", position = 1)
    private String senderUserId;

    @ApiModelProperty(value = "接收人 id", position = 2)
    private String receiverUserId;

    @ApiModelProperty(value = "帶入資訊", position = 3)
    private TriggerEntity triggerBy;

    @ApiModelProperty(value = "最新一筆聊天紀錄", position = 4)
    private String latestDialogueId;

    @ApiModelProperty(value = "更新日期", position = 5)
    private LocalDateTime lastModifiedDate;
}

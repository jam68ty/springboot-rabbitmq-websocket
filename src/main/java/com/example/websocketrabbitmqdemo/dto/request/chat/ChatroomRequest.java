package com.example.websocketrabbitmqdemo.dto.request.chat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "chatroomDTO")
public class ChatroomRequest {

    @ApiModelProperty(value = "user id", position = 0, required = true)
    private String userId;

    @ApiModelProperty(value = "trigger by", position = 1, required = true)
    private TriggerObject triggerBy; //can be storeId, skuId, storeId+orderId

}

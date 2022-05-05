package com.example.websocketrabbitmqdemo.dto.request.chat;

import lombok.Data;

@Data
public class TriggerObject {
    private String storeId;
    private String skuId;
    private String orderId;
}

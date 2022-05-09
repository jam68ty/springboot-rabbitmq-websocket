package com.example.websocketrabbitmqdemo.service;

import com.example.websocketrabbitmqdemo.dto.request.chat.DialogueRequest;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.eclipse.paho.client.mqttv3.MqttException;

public interface DialogueService {


    //建立聊天室(多載)
    public ResponseInfo createChatroom(String userId, String storeId, String buType) throws MqttException;

    public ResponseInfo createChatroom(String userId, String storeId, String skuId, String buType) throws MqttException;

    public ResponseInfo createChatroom(String userId, String storeId, String skuId, String orderId, String buType) throws MqttException;

    // 新增對話
    public ResponseInfo createDialogue(DialogueRequest request) throws Exception;

    //取得對話列表
    public ResponseInfo getDialogueList(String userId, String BuType, String status, Integer startIndex, Integer size);

    //取得聊天室對話
    public ResponseInfo getDialogueRecords(String chatroomId, Integer startIndex, Integer size);

}

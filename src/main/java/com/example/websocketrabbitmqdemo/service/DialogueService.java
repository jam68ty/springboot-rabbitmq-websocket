package com.example.websocketrabbitmqdemo.service;

import com.example.websocketrabbitmqdemo.dto.request.chat.ChatroomRequest;
import com.example.websocketrabbitmqdemo.dto.request.chat.DialogueRequest;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.eclipse.paho.client.mqttv3.MqttException;

public interface DialogueService {


    //建立聊天室
    public ResponseInfo createChatroom(ChatroomRequest chatroomRequest) throws MqttException;
    // 新增對話
    public ResponseInfo createDialogue(DialogueRequest request) throws Exception;

    public ResponseInfo getDialogueList(String userId, Integer startIndex, Integer size);

    public ResponseInfo getDialogueRecords(String chatroomId, Integer startIndex, Integer size);
//
//    public ResponseInfo getUnreadCount(String userId);
//
//    public void updateUnreadCount(String dialogueId, Long readDatetime);
}

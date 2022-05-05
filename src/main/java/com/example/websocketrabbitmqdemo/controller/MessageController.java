package com.example.websocketrabbitmqdemo.controller;

import com.example.websocketrabbitmqdemo.dto.request.chat.ChatroomRequest;
import com.example.websocketrabbitmqdemo.dto.request.chat.DialogueRequest;
import com.example.websocketrabbitmqdemo.dto.response.chat.ChatroomResponse;
import com.example.websocketrabbitmqdemo.dto.response.chat.DialogueResponse;
import com.example.websocketrabbitmqdemo.service.DialogueService;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import io.swagger.annotations.*;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Message 對話")
@RestController
@RequestMapping(value = "/api")
public class MessageController {


    @Autowired
    private DialogueService dialogueService;


    @ApiOperation(value = "建立聊天室", notes = "創建新的聊天室")
    @PostMapping(value = "/createChatroom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = ChatroomResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo createChatroom(
            @ApiParam(value = "trigger") @RequestBody ChatroomRequest chatroomRequest) throws MqttException {
        return dialogueService.createChatroom(chatroomRequest);
    }

    @ApiOperation(value = "新增對話", notes = "新增對話")
    @PostMapping(value = "/createDialogue")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "success", response = DialogueResponse.class)})
    public ResponseInfo dialoguePost(@RequestBody DialogueRequest request) throws Exception {
        return dialogueService.createDialogue(request);
    }


    @ApiOperation(value = "對話列表", notes = "查詢user的對話")
    @GetMapping(value = "/dialogueList")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DialogueResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo getMessageList(
            @ApiParam(value = "user的Id") @RequestParam(value = "userId") String userId,
            @ApiParam(value = "起始索引") @RequestParam(value = "startIndex", required = false, defaultValue = "0") int startIndex,
            @ApiParam(value = "筆數") @RequestParam(value = "size", required = false, defaultValue = "0") int size)
    {
        return dialogueService.getDialogueList(userId, startIndex, size);
    }

    @ApiOperation(value = "對話內容", notes = "查詢topic內user的對話")
    @GetMapping(value = "/dialogueRecord")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DialogueResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo getMessages(
            @ApiParam(value = "聊天室") @RequestParam(value = "topicId") String topicId,
            @ApiParam(value = "起始索引") @RequestParam(value = "startIndex", required = false, defaultValue = "0") int startIndex,
            @ApiParam(value = "筆數") @RequestParam(value = "size", required = false, defaultValue = "0") int size) {
        return dialogueService.getDialogueRecords(topicId, startIndex, size);
    }




}

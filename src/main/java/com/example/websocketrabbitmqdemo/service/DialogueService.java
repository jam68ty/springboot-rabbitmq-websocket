package com.example.websocketrabbitmqdemo.service;

import com.example.websocketrabbitmqdemo.dto.request.DialogueRequest;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.springframework.transaction.annotation.Transactional;

public interface DialogueService {

    // 新增對話
    public ResponseInfo createDialogue(DialogueRequest request) throws Exception;

    @Transactional
    public ResponseInfo deleteDialogueById(String dialogueId);


    public ResponseInfo getDialogues(Integer startIndex, Integer size);

    public ResponseInfo getDialogueRecords(Integer startIndex, Integer size);

    public ResponseInfo getUnreadCount(String userId);

    public void updateUnreadCount(String dialogueId, Long readDatetime);
}

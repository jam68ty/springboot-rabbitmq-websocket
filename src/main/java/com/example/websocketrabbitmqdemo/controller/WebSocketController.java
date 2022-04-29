package com.example.websocketrabbitmqdemo.controller;

import com.example.websocketrabbitmqdemo.service.DialogueService;
import com.example.websocketrabbitmqdemo.utils.websocket.WebSocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint(value = "/WebSocketServer/{usernick}")
public class WebSocketController {

    @Autowired
    private DialogueService dialogueService;

    @OnOpen
    public void onOpen(@PathParam(value = "usernick") String userNick, Session session) {
        String message = "有新成員[" + userNick + "]加入聊天室!";
        System.out.println(message);
        WebSocketUtil.addSession(userNick, session);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnClose
    public void onClose(@PathParam(value = "usernick") String userNick, Session session) {
        String message = "成員[" + userNick + "]退出聊天室!";
        System.out.println(message);
        WebSocketUtil.remoteSession(userNick);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnMessage
    public void OnMessage(@PathParam(value = "usernick") String userNick, String message) {
        String info = "成員[" + userNick + "]：" + message;
        System.out.println(info);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("錯誤:" + throwable);
        try {
            session.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }
}

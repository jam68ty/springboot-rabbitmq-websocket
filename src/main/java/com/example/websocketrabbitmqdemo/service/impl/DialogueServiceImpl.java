package com.example.websocketrabbitmqdemo.service.impl;

import com.example.websocketrabbitmqdemo.config.MqttConfig;
import com.example.websocketrabbitmqdemo.dao.entity.DialogueEntity;
import com.example.websocketrabbitmqdemo.dao.entity.ChatroomEntity;
import com.example.websocketrabbitmqdemo.dao.repositroy.DialogueRepository;
import com.example.websocketrabbitmqdemo.dao.repositroy.ChatroomRepository;
import com.example.websocketrabbitmqdemo.dto.request.chat.DialogueRequest;
import com.example.websocketrabbitmqdemo.dto.response.chat.ChatroomListResponse;
import com.example.websocketrabbitmqdemo.dto.response.chat.DialogueResponse;
import com.example.websocketrabbitmqdemo.dto.response.chat.ChatroomResponse;
import com.example.websocketrabbitmqdemo.service.DialogueService;
import com.example.websocketrabbitmqdemo.utils.pagination.OffsetBasedPageRequest;
import com.example.websocketrabbitmqdemo.utils.rabbit.RabbitMQSender;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class DialogueServiceImpl implements DialogueService {

    private Logger logger = LoggerFactory.getLogger(DialogueServiceImpl.class);
    @Autowired
    private DialogueRepository dialogueRepo;

    @Autowired
    private ChatroomRepository chatroomRepository;

    @Autowired
    private RabbitMQSender sender;

    @Autowired
    HttpServletRequest httpServletRequest;

    Executor executor = Executors.newFixedThreadPool(3);


    @Override
    public ResponseInfo createChatroom(String userId, String storeId) throws MqttException {
        LocalDateTime now = LocalDateTime.now();
        String chatroomId = userId + "_" + storeId;
        MqttMessage mqttMessage = new MqttMessage();
        MqttConfig.getInstance().publish(chatroomId, mqttMessage);

        var responseInfo = new ResponseInfo();
        ChatroomResponse response = new ChatroomResponse();
        response.setChatroomId(chatroomId);
        response.setLastModifiedDate(now);
        response.setSenderUserId(userId);
        response.setReceiverUserId(storeId);
        response.setInformation("store information: " + storeId);

        var chatroomEntity = new ChatroomEntity();
        chatroomEntity.setChatroomId(response.getChatroomId());
        chatroomEntity.setCreatedDate(now);
        chatroomEntity.setLastModifiedDate(now);
        chatroomEntity.setCreatedUserId(userId);
        chatroomEntity.setReceiveUserId(storeId);
        chatroomEntity.setTriggerBy("store: " + storeId);

        chatroomRepository.save(chatroomEntity);

        responseInfo.getStatus().setCode("success");
        responseInfo.putData("chatroom", response);

        return responseInfo;

    }

    @Override
    public ResponseInfo createChatroom(String userId, String storeId, String skuId) throws MqttException {
        LocalDateTime now = LocalDateTime.now();
        String chatroomId = userId + "_" + storeId;
        MqttMessage mqttMessage = new MqttMessage();
        MqttConfig.getInstance().publish(chatroomId, mqttMessage);

        var responseInfo = new ResponseInfo();
        ChatroomResponse response = new ChatroomResponse();
        response.setChatroomId(chatroomId);
        response.setLastModifiedDate(now);
        response.setSenderUserId(userId);
        response.setReceiverUserId(storeId);
        response.setInformation("sku information: " + skuId + " and store information: " + storeId);

        var chatroomEntity = new ChatroomEntity();
        chatroomEntity.setChatroomId(response.getChatroomId());
        chatroomEntity.setCreatedDate(now);
        chatroomEntity.setLastModifiedDate(now);
        chatroomEntity.setCreatedUserId(userId);
        chatroomEntity.setReceiveUserId(storeId);
        chatroomEntity.setTriggerBy("sku: " + skuId);

        chatroomRepository.save(chatroomEntity);

        responseInfo.getStatus().setCode("success");
        responseInfo.putData("chatroom", response);

        return responseInfo;

    }

    @Override
    public ResponseInfo createChatroom(String userId, String storeId, String skuId, String orderId) throws MqttException {
        LocalDateTime now = LocalDateTime.now();
        String chatroomId = userId + "_" + storeId;
        MqttMessage mqttMessage = new MqttMessage();
        MqttConfig.getInstance().publish(chatroomId, mqttMessage);

        var responseInfo = new ResponseInfo();
        ChatroomResponse response = new ChatroomResponse();
        response.setChatroomId(chatroomId);
        response.setLastModifiedDate(now);
        response.setSenderUserId(userId);
        response.setReceiverUserId(storeId);
        response.setInformation("information sku: " + skuId + " in order: " + orderId);

        var chatroomEntity = new ChatroomEntity();
        chatroomEntity.setChatroomId(response.getChatroomId());
        chatroomEntity.setCreatedDate(now);
        chatroomEntity.setLastModifiedDate(now);
        chatroomEntity.setCreatedUserId(userId);
        chatroomEntity.setReceiveUserId(storeId);
        chatroomEntity.setTriggerBy("sku: " + skuId + " in order: " + orderId);

        chatroomRepository.save(chatroomEntity);

        responseInfo.getStatus().setCode("success");
        responseInfo.putData("chatroom", response);

        return responseInfo;

    }

    @Override
    public ResponseInfo createDialogue(DialogueRequest request) throws Exception {

        LocalDateTime now = LocalDateTime.now();
        if (Objects.equals(request.getSendUserId(), "0")) {
            throw new Exception("can't find send user");
        }

        //TODO: Mapper
        DialogueEntity dialogueEntity = new DialogueEntity();
        dialogueEntity.setDialogueId("");
        dialogueEntity.setCreatedDate(now);
        dialogueEntity.setLastModifiedDate(now);

        dialogueEntity.setContent(request.getContent());
        dialogueEntity.setReceiveUserId(request.getReceiveUserId());
        dialogueEntity.setSendUserId(request.getSendUserId());
        dialogueEntity.setType(request.getType());
        dialogueEntity.setChatroomId(request.getChatroomId());

        dialogueRepo.save(dialogueEntity);
        var savedDialogue =
                dialogueRepo.findByDialogueId(dialogueEntity.getDialogueId()).orElseThrow(() -> {
                    try {
                        throw new Exception("Can't find dialogue");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(1);
        mqttMessage.setRetained(true);
        mqttMessage.setPayload(request.getContent().getBytes());

        MqttConfig.getInstance().publish(request.getChatroomId(), mqttMessage);
        chatroomRepository.updateLatestDialogueId(dialogueEntity.getDialogueId(), request.getChatroomId(), now);
        // responseInfo
        var responseInfo = new ResponseInfo();
        executor.execute(() -> {
            // send MQ info
            sendMQInfo(savedDialogue);
            // send HSS
            //sendHSS(savedDialogue.getDialogueId());
        });

        LinkedList<DialogueEntity> dialogueRes = new LinkedList<>();
        dialogueRes.add(savedDialogue);
        responseInfo.getStatus().setCode("success");
        responseInfo.putData("dialogue", dialogueRes);

        return responseInfo;
    }

    private void sendMQInfo(DialogueEntity dialogueEntity) {
        var receiveUserId = dialogueEntity.getReceiveUserId();
        var sendUserIdId = dialogueEntity.getSendUserId();

        var content = dialogueEntity.getContent();

        // 取得最新訊息Info (外面的)
        sender.sendDialogue(sendUserIdId, receiveUserId, content);
    }

    @Override
    public ResponseInfo getDialogueList(String userId, Integer startIndex, Integer size) {
        var sortMethod = Sort.by(Sort.Direction.DESC, "lastModifiedDate");
        var pageRequest = (startIndex == 0 && size == 0) ? Pageable.unpaged()
                : new OffsetBasedPageRequest(startIndex, size, sortMethod);

        var ChatroomOpt = chatroomRepository.findChatroomByIdUserId(userId, pageRequest);

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.getStatus().setCode("success");
        if (ChatroomOpt.isEmpty()) {
            responseInfo.putData("chatroom", new ArrayList<ChatroomListResponse>());
            return responseInfo;
        }

        var returnLatestChatroom = new LinkedList<ChatroomListResponse>();
        var totalLatestChatroom = ChatroomOpt.get();

//        var unreadCounts = new HashMap<String, Integer>();
//        dialogueRepo.getUnreadCounts(userId).forEach(info -> {
//            String pledgeId = info[0].toString();
//            int count = Integer.parseInt(info[1].toString());
//            unreadCounts.put(pledgeId, count);
//        });

        int count = 0;
        responseInfo.putData("totalElements", totalLatestChatroom.getTotalElements());
        responseInfo.putData("totalPages", totalLatestChatroom.getTotalPages());
        for (var latestRes : totalLatestChatroom.getContent()) {

//            if (userId.equals(latestRes.getHostPk())) {
//                latestRes.setTarget(latestRes.getGuestPk());
//            } else if (userId.equals(latestRes.getGuestPk())) {
//                latestRes.setTarget(latestRes.getHostPk());
//            } else {
//                latestRes.setTarget("");
//            }

            // no readed count
//            int noReadedCount = unreadCounts.containsKey(latestRes.getPledgeId())
//                    ? unreadCounts.get(latestRes.getPledgeId())
//                    : 0;
//            latestRes.setNotReadCount(noReadedCount);

//            count++;
//
//            if (!"".equals(latestRes.getTarget())) {
//                userRepo.findById(latestRes.getTarget()).ifPresent(userProfile -> {
//                    int commentCount =
//                            commentRepo.getCommentIdByCommentToCount(latestRes.getTarget());
//                    latestRes.setTargetUser(userProfile, commentCount);
//                });
//            }
//
            //TODO: Mapper
            ChatroomListResponse response = new ChatroomListResponse();
            response.setChatroomId(latestRes.getChatroomId());
            if (latestRes.getCreatedUserId() == userId) {
                response.setUserId(userId);
                response.setReceiverUserId(latestRes.getReceiveUserId());
            } else {
                response.setUserId(latestRes.getReceiveUserId());
                response.setReceiverUserId(userId);
            }
            response.setLastModifiedDate(latestRes.getLastModifiedDate());
            response.setLatestDialogueId(latestRes.getLatestDialogueId());


            returnLatestChatroom.add(response);
        }
//
        responseInfo.putData("chatroom", returnLatestChatroom);
        return responseInfo;
    }


    @Override
    public ResponseInfo getDialogueRecords(String chatroomId, Integer startIndex, Integer size) {

//        String userId = httpServletRequest.getAttribute("hybrisPk").toString();
//        String lang = LocaleContextHolder.getLocale().getLanguage();

        var sortMethod = Sort.by(Sort.Direction.DESC, "lastModifiedDate");
        var pageRequest = (startIndex == 0 && size == 0) ? Pageable.unpaged()
                : new OffsetBasedPageRequest(startIndex, size, sortMethod);

        var DialogueOpt = dialogueRepo.findAllDialogue(chatroomId, pageRequest);

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.getStatus().setCode("success");
        if (DialogueOpt.isEmpty() || DialogueOpt.get().getSize() == 0) {
            responseInfo.putData("dialogue", new ArrayList<DialogueResponse>());
            return responseInfo;
        }

        var returnLatestDialogue = new LinkedList<DialogueResponse>();
        var totalLatestDialogue = DialogueOpt.get();

//        var unreadCounts = new HashMap<String, Integer>();
//        dialogueRepo.getUnreadCounts(userId).forEach(info -> {
//            String pledgeId = info[0].toString();
//            int count = Integer.parseInt(info[1].toString());
//            unreadCounts.put(pledgeId, count);
//        });

//            int count = 0;
        responseInfo.putData("totalPages", totalLatestDialogue.getTotalPages());
        responseInfo.putData("totalElements", totalLatestDialogue.getTotalElements());
        for (var latestRes : totalLatestDialogue.getContent()) {

//            if (userId.equals(latestRes.getHostPk())) {
//                latestRes.setTarget(latestRes.getGuestPk());
//            } else if (userId.equals(latestRes.getGuestPk())) {
//                latestRes.setTarget(latestRes.getHostPk());
//            } else {
//                latestRes.setTarget("");
//            }

            // no readed count
//            int noReadedCount = unreadCounts.containsKey(latestRes.getPledgeId())
//                    ? unreadCounts.get(latestRes.getPledgeId())
//                    : 0;
//            latestRes.setNotReadCount(noReadedCount);

//            count++;
//
//            if (!"".equals(latestRes.getTarget())) {
//                userRepo.findById(latestRes.getTarget()).ifPresent(userProfile -> {
//                    int commentCount =
//                            commentRepo.getCommentIdByCommentToCount(latestRes.getTarget());
//                    latestRes.setTargetUser(userProfile, commentCount);
//                });
//            }

            //TODO: Mapper
            DialogueResponse response = new DialogueResponse();
            response.setDialogueId(latestRes.getDialogueId());
            response.setContent(latestRes.getContent());
            response.setType(latestRes.getType());
            response.setSendUserId(latestRes.getSendUserId());
            response.setLastModifiedDate(latestRes.getLastModifiedDate().toInstant(ZoneOffset.of("+08:00")).toEpochMilli());
            response.setShow(latestRes.isShow());
            response.setReceiveUserId(latestRes.getReceiveUserId());

            returnLatestDialogue.add(response);
        }

        responseInfo.putData("dialogue", returnLatestDialogue);
        return responseInfo;
    }

}
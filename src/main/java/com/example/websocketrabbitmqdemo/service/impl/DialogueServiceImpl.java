package com.example.websocketrabbitmqdemo.service.impl;

import com.example.websocketrabbitmqdemo.dao.entity.DialogueEntity;
import com.example.websocketrabbitmqdemo.dao.repositroy.DialogueRepository;
import com.example.websocketrabbitmqdemo.dto.request.DialogueRequest;
import com.example.websocketrabbitmqdemo.dto.response.DialogueResponse;
import com.example.websocketrabbitmqdemo.service.DialogueService;
import com.example.websocketrabbitmqdemo.utils.pagination.OffsetBasedPageRequest;
import com.example.websocketrabbitmqdemo.utils.rabbit.RabbitMQSender;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class DialogueServiceImpl implements DialogueService {

    private Logger logger = LoggerFactory.getLogger(DialogueServiceImpl.class);
    @Autowired
    private DialogueRepository dialogueRepo;

    @Autowired
    private RabbitMQSender sender;

    @Autowired
    HttpServletRequest httpServletRequest;

    Executor executor = Executors.newFixedThreadPool(3);

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

//         insert entity
        dialogueRepo.save(dialogueEntity);
        var savedDialogue =
                dialogueRepo.findByDialogueId(dialogueEntity.getDialogueId()).orElseThrow(() -> {
                    try {
                        throw new Exception("Can't find dialogue");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

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
        sender.sendDialogue(content, sendUserIdId, receiveUserId);
    }

    @Override
    public ResponseInfo deleteDialogueById(String dialogueId) {
        return null;
    }

    @Override
    public ResponseInfo getDialogues(Integer startIndex, Integer size) {
//        String userId = httpServletRequest.getAttribute("hybrisPk").toString();
//        String lang = LocaleContextHolder.getLocale().getLanguage();

        var sortMethod = Sort.by(Sort.Direction.DESC, "lastModifiedDate");
        var pageRequest = (startIndex == 0 && size == 0) ? Pageable.unpaged()
                : new OffsetBasedPageRequest(startIndex, size, sortMethod);

        var DialogueOpt = dialogueRepo.findAllDialogue(pageRequest);

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

        int count = 0;
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
            response.setCreatedDate(latestRes.getCreatedDate().toInstant(ZoneOffset.of("+08:00")).toEpochMilli());
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

    @Override
    public ResponseInfo getDialogueRecords(Integer startIndex, Integer size) {
        return null;
    }

    @Override
    public ResponseInfo getUnreadCount(String userId) {
        return null;
    }

    @Override
    public void updateUnreadCount(String dialogueId, Long readDatetime) {

    }
}

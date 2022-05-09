package com.example.websocketrabbitmqdemo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chatroom")
public class ChatroomEntity {
    @Id
    @Column(name = "chatroom_id", nullable = false)
    private String chatroomId;

    @Column(name = "created_user_id", nullable = false)
    private String createdUserId;

    @Column(name = "receive_user_id", nullable = false)
    private String receiveUserId;

    @Column(name = "BU_type", nullable = false)
    private String BuType;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name="close", nullable = false)
    private boolean close;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @Column(name = "latest_dialogue_id", nullable = false)
    private String latestDialogueId;

    @Column(name = "trigger_by", nullable = false)
    private String triggerBy;

}

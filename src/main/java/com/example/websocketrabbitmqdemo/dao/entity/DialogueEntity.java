package com.example.websocketrabbitmqdemo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dialogues")
public class DialogueEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dialogue_serial")
    private int dialogueSerial;

    @Column(name = "dialogue_id", nullable = false)
    private String dialogueId;

    @Column(name = "send_user_id", nullable = false)
    private String sendUserId;

    @Column(name = "receive_user_id", nullable = false)
    private String receiveUserId;

    @Column(name = "sender_readed", nullable = false)
    private boolean senderReaded = true;

    @Column(name = "receiver_readed", nullable = false)
    private boolean receiverReaded = false;

    @Column(name = "sender_deleted", nullable = false)
    private boolean senderDeleted = false;

    @Column(name = "receiver_deleted", nullable = false)
    private boolean receiverDeleted = false;

    @Column(name = "`type`", nullable = false)
    private String type;

    @Column(name = "content")
    private String content;

    @Column(name = "`show`", nullable = false)
    private boolean show = true;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @Column(name = "chatroom_id", nullable = false)
    private String chatroomId;

    @PostPersist
    public void createDialogueId() {
        this.dialogueId = "DLR" + String.format("%012d", dialogueSerial);
    }

}

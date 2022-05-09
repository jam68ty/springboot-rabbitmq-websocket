package com.example.websocketrabbitmqdemo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "default_message")
public class DefaultMessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "default_message_serial")
    private int defaultMessageSerial;

    @Column(name = "default_message_id", nullable = false)
    private String defaultMessageId;

    @Column(name = "BU", nullable = false)
    private String BU;

    @Column(name = "default_message_type", nullable = false)
    private String defaultMessageType;

    @Column(name = "merchant_id", nullable = false)
    private String merchantId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @PostPersist
    public void createDefaultMessageId() {
        this.defaultMessageId = "DMSG" + String.format("%012d", defaultMessageSerial);
    }

}

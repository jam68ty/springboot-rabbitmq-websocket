package com.example.websocketrabbitmqdemo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`trigger`")
public class TriggerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "trigger_serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int triggerSerial;

    @Column(name = "`trigger_id`")
    private String triggerId;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "sku_id")
    private String skuId;

    @Column(name = "order_id")
    private String orderId;

    @PostPersist
    public void createTriggerId() {
        this.triggerId = "TRI" + String.format("%012d", triggerSerial);
    }
}

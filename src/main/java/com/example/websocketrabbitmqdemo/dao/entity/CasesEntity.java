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
@Table(name = "case")
public class CasesEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_serial")
    private int caseSerial;

    @Column(name = "case_id", nullable = false)
    private String caseId;

    @Column(name = "BU", nullable = false)
    private String BU;

    @Column(name = "case_type", nullable = false)
    private String caseType;

    @Column(name = "reference_no", nullable = false)
    private String referenceNo;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @PostPersist
    public void createCaseId() {
        this.caseId = "CASE" + String.format("%012d", caseSerial);
    }

}

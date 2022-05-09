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
@Table(name = "cases")
public class CasesEntity {
    @Id
    @Column(name = "case_id", nullable = false)
    private String caseId;

    @Column(name = "salesforce_case_id")
    private int salesforceCaseId;

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

}

package com.caesar_84.recepcion_docs_reg.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "entrant_documents", uniqueConstraints = {@UniqueConstraint(columnNames = {"serial"},
        name = "doc_serial_unique_constraint")})
public class EntrantDocument {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial", nullable = false)
    private String serial;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "attention_of", nullable = false)
    private String attentionOf;

    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name = "time_handed", nullable = false)
    private LocalTime timeHanded;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "name_handed", nullable = false)
    private String nameHanded;

    @Column(name = "handed_date", nullable = false)
    private LocalDate handedDate;

    @Column(name = "correspondence_quantity", nullable = false)
    private Integer correspondenceQuantity;

    @Column(name = "comments", nullable = false)
    private String comments;

    public EntrantDocument(){}

    public EntrantDocument(ViewableEntrantDocument viewableEntrantDocument) {
        this(viewableEntrantDocument.getId(),
                viewableEntrantDocument.getSerial(),
                viewableEntrantDocument.getCompanyName(),
                viewableEntrantDocument.getAttentionOf(),
                viewableEntrantDocument.getDepartment(),
                viewableEntrantDocument.getTimeHanded(),
                viewableEntrantDocument.getContents(),
                viewableEntrantDocument.getNameHanded(),
                viewableEntrantDocument.getHandedDate(),
                viewableEntrantDocument.getCorrespondenceQuantity(),
                viewableEntrantDocument.getComments());
    }

    public EntrantDocument(Integer id,
                           String serial,
                           String companyName,
                           String attentionOf,
                           Department department,
                           LocalTime timeHanded,
                           String contents,
                           String nameHanded,
                           LocalDate handedDate,
                           Integer correspondenceQuantity,
                           String comments) {
        this.id = id;
        this.serial = serial;
        this.companyName = companyName;
        this.attentionOf = attentionOf;
        this.department = department;
        this.timeHanded = timeHanded;
        this.contents = contents;
        this.nameHanded = nameHanded;
        this.handedDate = handedDate;
        this.correspondenceQuantity = correspondenceQuantity;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAttentionOf() {
        return attentionOf;
    }

    public void setAttentionOf(String attentionOf) {
        this.attentionOf = attentionOf;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalTime getTimeHanded() {
        return timeHanded;
    }

    public void setTimeHanded(LocalTime timeHanded) {
        this.timeHanded = timeHanded;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getNameHanded() {
        return nameHanded;
    }

    public void setNameHanded(String nameHanded) {
        this.nameHanded = nameHanded;
    }

    public LocalDate getHandedDate() {
        return handedDate;
    }

    public void setHandedDate(LocalDate handedDate) {
        this.handedDate = handedDate;
    }

    public Integer getCorrespondenceQuantity() {
        return correspondenceQuantity;
    }

    public void setCorrespondenceQuantity(Integer correspondenceQuantity) {
        this.correspondenceQuantity = correspondenceQuantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

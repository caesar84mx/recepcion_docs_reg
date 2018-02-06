package com.caesar_84.recepcion_docs_reg.domain.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ViewableEntrantDocument {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty serial = new SimpleStringProperty();
    private StringProperty companyName = new SimpleStringProperty();
    private StringProperty attentionOf = new SimpleStringProperty();
    private ObjectProperty<Department> department = new SimpleObjectProperty<>();
    private ObjectProperty<LocalTime> timeHanded = new SimpleObjectProperty<>();
    private StringProperty contents = new SimpleStringProperty();
    private StringProperty nameHanded = new SimpleStringProperty();
    private ObjectProperty<LocalDate> handedDate = new SimpleObjectProperty<>();
    private IntegerProperty correspondenceQuantity = new SimpleIntegerProperty();
    private StringProperty comments = new SimpleStringProperty();

    public ViewableEntrantDocument() {}

    public ViewableEntrantDocument(EntrantDocument entrantDocument) {
        this(new SimpleIntegerProperty(entrantDocument.getId()),
                new SimpleStringProperty(entrantDocument.getSerial()),
                new SimpleStringProperty(entrantDocument.getCompanyName()),
                new SimpleStringProperty(entrantDocument.getAttentionOf()),
                new SimpleObjectProperty<>(entrantDocument.getDepartment()),
                new SimpleObjectProperty<>(entrantDocument.getTimeHanded()),
                new SimpleStringProperty(entrantDocument.getContents()),
                new SimpleStringProperty(entrantDocument.getNameHanded()),
                new SimpleObjectProperty<>(entrantDocument.getHandedDate()),
                new SimpleIntegerProperty(entrantDocument.getCorrespondenceQuantity()),
                new SimpleStringProperty(entrantDocument.getComments()));
    }

    public ViewableEntrantDocument(IntegerProperty id,
                                   StringProperty serial,
                                   StringProperty companyName,
                                   StringProperty attentionOf,
                                   ObjectProperty<Department> department,
                                   ObjectProperty<LocalTime> timeHanded,
                                   StringProperty contents,
                                   StringProperty nameHanded,
                                   ObjectProperty<LocalDate> handedDate,
                                   IntegerProperty correspondenceQuantity,
                                   StringProperty comments) {
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

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getSerial() {
        return serial.get();
    }

    public StringProperty serialProperty() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial.set(serial);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public StringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    public String getAttentionOf() {
        return attentionOf.get();
    }

    public StringProperty attentionOfProperty() {
        return attentionOf;
    }

    public void setAttentionOf(String attentionOf) {
        this.attentionOf.set(attentionOf);
    }

    public Department getDepartment() {
        return department.get();
    }

    public ObjectProperty<Department> departmentProperty() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department.set(department);
    }

    public LocalTime getTimeHanded() {
        return timeHanded.get();
    }

    public ObjectProperty<LocalTime> timeHandedProperty() {
        return timeHanded;
    }

    public void setTimeHanded(LocalTime timeHanded) {
        this.timeHanded.set(timeHanded);
    }

    public String getContents() {
        return contents.get();
    }

    public StringProperty contentsProperty() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents.set(contents);
    }

    public String getNameHanded() {
        return nameHanded.get();
    }

    public StringProperty nameHandedProperty() {
        return nameHanded;
    }

    public void setNameHanded(String nameHanded) {
        this.nameHanded.set(nameHanded);
    }

    public LocalDate getHandedDate() {
        return handedDate.get();
    }

    public ObjectProperty<LocalDate> handedDateProperty() {
        return handedDate;
    }

    public void setHandedDate(LocalDate handedDate) {
        this.handedDate.set(handedDate);
    }

    public int getCorrespondenceQuantity() {
        return correspondenceQuantity.get();
    }

    public IntegerProperty correspondenceQuantityProperty() {
        return correspondenceQuantity;
    }

    public void setCorrespondenceQuantity(int correspondenceQuantity) {
        this.correspondenceQuantity.set(correspondenceQuantity);
    }

    public String getComments() {
        return comments.get();
    }

    public StringProperty commentsProperty() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments.set(comments);
    }
}

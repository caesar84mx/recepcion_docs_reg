package com.caesar_84.recepcion_docs_reg.view.controllers;

import com.caesar_84.recepcion_docs_reg.Main;
import com.caesar_84.recepcion_docs_reg.domain.model.Department;
import com.caesar_84.recepcion_docs_reg.domain.model.ViewableEntrantDocument;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewHandedDocumentDialogController {
    @FXML
    private TextField serialTextField;

    @FXML
    private TextField companyNameTextField;

    @FXML
    private TextField handedNameTextField;

    @FXML
    private TextField attentionOfTextField;

    @FXML
    private ChoiceBox<Department> departmentChoiceBox;

    @FXML
    private Spinner<Integer> quantitySpinner;

    @FXML
    private TextArea contentsTextArea;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private void handleOk() {
        if (!(serialTextField.getText().isEmpty() ||
                companyNameTextField.getText().isEmpty() ||
                handedNameTextField.getText().isEmpty() ||
                attentionOfTextField.getText().isEmpty() ||
                departmentChoiceBox.getValue() == null ||
                contentsTextArea.getText().isEmpty() ||
                commentsTextArea.getText().isEmpty())) {
            viewableEntrantDocument = new ViewableEntrantDocument();

            viewableEntrantDocument.setSerial(serialTextField.getText());
            viewableEntrantDocument.setCompanyName(companyNameTextField.getText());
            viewableEntrantDocument.setAttentionOf(attentionOfTextField.getText());
            viewableEntrantDocument.setDepartment(departmentChoiceBox.getValue());
            viewableEntrantDocument.setTimeHanded(LocalTime.now());
            viewableEntrantDocument.setContents(contentsTextArea.getText());
            viewableEntrantDocument.setNameHanded(handedNameTextField.getText());
            viewableEntrantDocument.setHandedDate(LocalDate.now());
            viewableEntrantDocument.setCorrespondenceQuantity(quantitySpinner.getValue());
            viewableEntrantDocument.setComments(commentsTextArea.getText());

            okClicked = true;
            dialogStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle(Main.APP_NAME);
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Usted tiene uno de los campos vacíos, debe llenarlos todos");

            alert.showAndWait();
        }

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private Stage dialogStage;
    private boolean okClicked;
    private ViewableEntrantDocument viewableEntrantDocument;

    @FXML
    private void initialize() {
        serialTextField.setText("");
        companyNameTextField.setText("");
        handedNameTextField.setText("");
        attentionOfTextField.setText("");
        departmentChoiceBox.setItems(FXCollections.observableArrayList(Department.values()));
        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999));
        contentsTextArea.setText("");
        commentsTextArea.setText("");
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setViewableEntrantDocument(ViewableEntrantDocument viewableEntrantDocument) {
        this.viewableEntrantDocument = viewableEntrantDocument;
    }

    public ViewableEntrantDocument getViewableEntrantDocument() {
        return viewableEntrantDocument;
    }
}

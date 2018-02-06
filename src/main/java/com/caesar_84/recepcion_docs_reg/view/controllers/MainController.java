package com.caesar_84.recepcion_docs_reg.view.controllers;

import com.caesar_84.recepcion_docs_reg.Main;
import com.caesar_84.recepcion_docs_reg.domain.model.ViewableEntrantDocument;
import com.caesar_84.recepcion_docs_reg.service.EntrantDocumentService;
import com.caesar_84.recepcion_docs_reg.util.DateUtil;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

    //  Documents table related
    @FXML
    private TableView<ViewableEntrantDocument> handedDocumentTable;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> serialColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> companyNameColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> nameHandedColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> attentionOfColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> departmentColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, Integer> quantityColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> dateHandedColumn;

    @FXML
    private TableColumn<ViewableEntrantDocument, String> timeHandedColumn;

//  Details labels
    @FXML
    private Label serialLabel;

    @FXML
    private Label companyLabel;

    @FXML
    private Label handedNameLabel;

    @FXML
    private Label attentionOfLabel;

    @FXML
    private Label departmentLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label dateHandedLabel;

    @FXML
    private Label timeHandedLabel;

    @FXML
    private Label contentsLabel;

    @FXML
    private Label commentsLabel;

    @FXML
    private void handleClose() {
        System.exit(0);
    }

    @FXML
    private void handleAddDocument() {
        boolean okClicked = main.showNewDocumentDialog(new ViewableEntrantDocument());

        if (okClicked) {
            ViewableEntrantDocument handedDocument = main.getNewHandedDocumentDialogController().getViewableEntrantDocument();
            service.save(handedDocument);
            handedDocumentTable.setItems(service.getAll());
        }
    }

    @FXML
    private void handleAbout() {
        showAlertWindow(Alert.AlertType.INFORMATION, "Sobre la aplicación", "Esta aplicación está diseñada para llevar el registro de la documentación entrante." +
                " En caso de cualquier duda, comuníquese conmigo al correo dymnov.dm@gmail.com." +
                "\n\n\nDiseñado por Maxim Dymnov");
    }

    //----------------------------------------------------------------------------------------------------------------------
    @FXML
    private void initialize() {
        serialColumn.setStyle("-fx-alignment: CENTER");
        serialColumn.setCellValueFactory(cellData -> cellData.getValue().serialProperty());

        companyNameColumn.setStyle("-fx-alignment: CENTER");
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());

        nameHandedColumn.setStyle("-fx-alignment: CENTER");
        nameHandedColumn.setCellValueFactory(cellData -> cellData.getValue().nameHandedProperty());

        attentionOfColumn.setStyle("-fx-alignment: CENTER");
        attentionOfColumn.setCellValueFactory(cellData -> cellData.getValue().attentionOfProperty());

        departmentColumn.setStyle("-fx-alignment: CENTER");
        departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty().asString());

        quantityColumn.setStyle("-fx-alignment: CENTER");
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().correspondenceQuantityProperty().asObject());

        dateHandedColumn.setStyle("-fx-alignment: CENTER");
        dateHandedColumn.setCellValueFactory(cellData -> new SimpleStringProperty(DateUtil.formatDate(cellData.getValue().getHandedDate())));

        timeHandedColumn.setStyle("-fx-alignment: CENTER");
        timeHandedColumn.setCellValueFactory(cellData -> new SimpleStringProperty(DateUtil.formatTime(cellData.getValue().getTimeHanded())));

        showHandedDocumentDetails(null);
        handedDocumentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showHandedDocumentDetails(newValue));
    }
//----------------------------------------------------------------------------------------------------------------------

    public MainController() {
    }

    private Main main;

    private EntrantDocumentService service = EntrantDocumentService.getInstance();

    public void setMain(Main main) {
        this.main = main;

        Platform.runLater(()-> handedDocumentTable.setItems(service.getAll()));
    }

    private void showAlertWindow(Alert.AlertType type, String header, String text) {
        Alert window = new Alert(type);

        window.initOwner(main.getPrimaryStage());
        window.setResizable(true);
        window.getDialogPane().setPrefHeight(250);
        window.setTitle(Main.APP_NAME);
        window.setHeaderText(header);
        window.setContentText(text);

        window.showAndWait();
    }

    private void showHandedDocumentDetails(ViewableEntrantDocument handedDocument) {
        if (handedDocument != null) {
            serialLabel.setText(handedDocument.getSerial());
            companyLabel.setText(handedDocument.getCompanyName());
            handedNameLabel.setText(handedDocument.getNameHanded());
            attentionOfLabel.setText(handedDocument.getAttentionOf());
            departmentLabel.setText(handedDocument.getDepartment().toString());
            quantityLabel.setText(String.valueOf(handedDocument.getCorrespondenceQuantity()));
            dateHandedLabel.setText(DateUtil.formatDate(handedDocument.getHandedDate()));
            timeHandedLabel.setText(DateUtil.formatTime(handedDocument.getTimeHanded()));
            contentsLabel.setText(handedDocument.getContents());
            commentsLabel.setText(handedDocument.getComments());
        } else {
            serialLabel.setText("---");
            companyLabel.setText("---");
            handedNameLabel.setText("---");
            attentionOfLabel.setText("---");
            departmentLabel.setText("---");
            quantityLabel.setText("---");
            dateHandedLabel.setText("---");
            timeHandedLabel.setText("---");
            contentsLabel.setText("");
            commentsLabel.setText("");
        }
    }
}

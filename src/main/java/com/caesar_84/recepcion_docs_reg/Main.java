package com.caesar_84.recepcion_docs_reg;

import com.caesar_84.recepcion_docs_reg.domain.model.ViewableEntrantDocument;
import com.caesar_84.recepcion_docs_reg.view.controllers.MainController;
import com.caesar_84.recepcion_docs_reg.view.controllers.NewHandedDocumentDialogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static final String APP_NAME = "RECEPCIÓN: REGISTRO DE DOCUMENTOS";

    private Stage primaryStage;
    private AnchorPane mainLayout;
    private NewHandedDocumentDialogController newHandedDocumentDialogController;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle(APP_NAME);

        initApp();
    }

    private void initApp(){
        try {
            FXMLLoader loader = new FXMLLoader();
            mainLayout = loader.load(getClass().getClassLoader().getResourceAsStream("fxml/MainStage.fxml"));

            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);

            primaryStage.setOnCloseRequest(event -> System.exit(0));
            primaryStage.setResizable(false);

            MainController mainController = loader.getController();
            mainController.setMain(this);

            primaryStage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean showNewDocumentDialog(ViewableEntrantDocument viewableEntrantDocument) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/NewDocumentDialog.fxml"));
            AnchorPane pane = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Agregar documento");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);

            newHandedDocumentDialogController = loader.getController();
            newHandedDocumentDialogController.setDialogStage(dialogStage);
            newHandedDocumentDialogController.setViewableEntrantDocument(viewableEntrantDocument);

            dialogStage.showAndWait();

            return newHandedDocumentDialogController.isOkClicked();
        } catch (IOException ex) {
            ex.printStackTrace();

            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public AnchorPane getMainLayout() {
        return mainLayout;
    }

    public NewHandedDocumentDialogController getNewHandedDocumentDialogController() {
        return newHandedDocumentDialogController;
    }
}

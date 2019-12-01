package Wojaro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXGraph extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root= FXMLLoader.load(getClass().getResource("/fxml/graph.fxml"));

        Scene scene= new Scene(root,800,600);
        scene.getStylesheets().add(getClass().getResource("/fxml/graph.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Orbital Trajectory");
        primaryStage.show();

    }
}

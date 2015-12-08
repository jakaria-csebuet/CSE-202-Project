package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage ;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage ;
        //showBattleFiend();
        showSetShip();
    }

    private void showBattleFiend() throws Exception{
        FXMLLoader loader = new FXMLLoader() ;
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        root.setId("pane");
        Scene scene = new Scene(root, 1024, 568) ;
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Battleships");
        stage.setScene(scene);
        stage.show();
    }

    private void showSetShip() throws Exception{
        FXMLLoader loader = new FXMLLoader() ;
        loader.setLocation(getClass().getResource("setship.fxml"));
        Parent root = loader.load();

        root.setId("pane");
        Scene scene = new Scene(root, 1024, 568) ;
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Battleships");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
     }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage ;
    Parent root ;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage ;
        //showBattleFiend();
        //showSetShip();
        showStartPage();
    }

    private void showBattleFiend() throws Exception{
        FXMLLoader loader = new FXMLLoader() ;
        loader.setLocation(getClass().getResource("sample.fxml"));
        root = loader.load();

        root.setId("pane");
        Scene scene = new Scene(root, 1024, 568) ;
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Battleships");
        stage.setScene(scene);
        stage.show();
    }

    public void showSetShip() throws Exception{
        FXMLLoader loader = new FXMLLoader() ;
        loader.setLocation(getClass().getResource("setship.fxml"));
        root = loader.load();

        root.setId("pane");
        Scene scene = new Scene(root, 1024, 568) ;
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Battleships");
        stage.setScene(scene);
        stage.show();
    }

    private void showStartPage()throws Exception{
        FXMLLoader loader = new FXMLLoader() ;
        loader.setLocation(getClass().getResource("startPage.fxml"));
        root = loader.load();

        StartPageController controller = loader.getController() ;
        controller.setMain(this);

        root.setId("pane");
        Scene scene = new Scene(root, 600, 400) ;
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Battleships");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
     }
}

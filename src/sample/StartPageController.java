package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by MD on 10/12/2015.
 */
public class StartPageController {
    Main main ;

    private String playerName ;

    @FXML
    TextField textField ;

    @FXML
    Button enter ;

    @FXML

    public void enterOnAction(ActionEvent event){
        playerName = textField.getText() ;
        System.out.println(playerName);
        try {
            main.showSetShip();
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public void setMain(Main main) {
        this.main = main;
    }

}

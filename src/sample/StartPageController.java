package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by MD on 10/12/2015.
 */
public class StartPageController {
    BattleShip main ;

    String playerName ;

    @FXML
    TextField textField ;

    @FXML
    Button enter ;

    @FXML

    public void enterOnAction(ActionEvent event){
        playerName = textField.getText() ;
        if (playerName.length() == 0){
            playerName = "Anonymous" ;
        }
        System.out.println(playerName);
        main.player = playerName ;
        try {
            main.showSetShip();
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public void setMain(BattleShip main) {
        this.main = main;
    }

}

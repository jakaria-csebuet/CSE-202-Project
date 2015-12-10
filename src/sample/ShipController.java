package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 * Created by MD on 08/12/2015.
 */
public class ShipController {

    Main main ;

    private Double layoutX ;
    private Double layoutY ;

    private Double orgSceneX ;
    private Double orgSceneY ;

    private Double orgTranslateX ;
    private Double orgTranslateY ;

    private Rectangle rectangle ;

    private boolean vertical = false ;

    private ImageView target ;

    @FXML
    Button startBattle ;

    @FXML
    ImageView airCarrier ;
    @FXML
    ImageView boat ;
    @FXML
    ImageView cruiser ;
    @FXML
    ImageView destroyer ;
    @FXML
    ImageView submarine ;

    @FXML
    public void battleOnAction(ActionEvent event){
        try {
            main.showBattleFiend();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void selectShip(MouseEvent e) {
        target = (ImageView)e.getSource() ;
        //System.out.println(e.getSource());
        //target.setOpacity(0.5);
       // target.setRotate(90);
       // target.relocate(522,174);
        System.out.println(target);
        //target = null ;
    }

    @FXML
    public void recSelect(MouseEvent event) throws Exception {
        if (target == null) return;
        rectangle = (Rectangle)event.getSource() ;
        layoutX = rectangle.getLayoutX() ;
        layoutY = rectangle.getLayoutY() ;
        moveImage() ;
        /*System.out.println(rectangle + " " + layoutX +  " " + layoutY);
        //target.relocate(layoutX,layoutX);
        target.setLayoutX(layoutX);
        target.setLayoutY(layoutY);
        target.setOpacity(1);*/

    }



    public void moveImage() throws InterruptedException {
        target.relocate(layoutX,layoutY);
        //target = null ;
       if (vertical && target==airCarrier) {
            target.setRotate(90);
            target.setTranslateX(-70);
            target.setTranslateY(80);
        }

        else if (vertical && target== destroyer){
            target.setRotate(90);
            target.setTranslateX(-60);
            target.setTranslateY(60);
        }
        else if (vertical && target== cruiser){
            target.setRotate(90);
            target.setTranslateX(-35);
            target.setTranslateY(45);
        }

        else if (vertical && target== submarine){
            target.setRotate(90);
            target.setTranslateX(-40);
            target.setTranslateY(40);
        }

        else if (vertical && target== boat){
            target.setRotate(90);
            target.setTranslateX(-15);
            target.setTranslateY(20);
        }
    }

    @FXML
    public void setVertical(MouseEvent event){
        vertical = true ;
        System.out.println(vertical);
    }

    @FXML
    public void setHorizontal(MouseEvent event){
        vertical = false ;
        System.out.println(vertical);
    }

    @FXML
    public void keyOnAction(KeyEvent event){
        String key = event.getCharacter() ;
        System.out.println(key);
    }

    @FXML
    public void mouseRelegeAction(MouseEvent event) throws InterruptedException {
        Thread.sleep(100);
        target = null ;
        System.out.println("relege");
    }

    public void setLayout( MouseEvent event){
        layoutX = event.getSceneX() ;
        layoutY = event.getSceneY() ;
    }

    @FXML
    public void airOnAction(MouseEvent event){
        target = (ImageView) event.getSource() ;
        target.setCursor(Cursor.HAND);
        System.out.println("Dragging");
       // airCarrier.setEffect();
    }

    @FXML
    public void airDropAction(MouseEvent event){
        double x =  event.getSceneX() ;
        double y =  event.getSceneY() ;
        airCarrier.setLayoutX(x);
        airCarrier.setLayoutY(y);
        System.out.println("Dropping");
    }

    @FXML
    public void getLayoyt(MouseEvent event){
        layoutX = airCarrier.getLayoutX() ;
        layoutY = airCarrier.getLayoutY() ;
        System.out.println(layoutX + " " + layoutY);
    }
    public void setMain(Main main) {
        this.main = main;
    }

    EventHandler<MouseEvent> imageOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    orgSceneX = event.getSceneX() ;
                    orgSceneY = event.getSceneY() ;

                    orgTranslateX = ((ImageView)event.getSource()).getTranslateX() ;
                    orgTranslateY = ((ImageView)event.getSource()).getTranslateY() ;

                }
            };

    EventHandler<MouseEvent> imageOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    double offsetX = event.getSceneX() - orgSceneX + orgTranslateX ;
                    double offsetY = event.getSceneY() - orgSceneY + orgTranslateY ;

                    ((ImageView)event.getSource()).setTranslateX(offsetX);
                    ((ImageView)event.getSource()).setTranslateY(offsetY);

                }
            } ;


}

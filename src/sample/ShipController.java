package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by MD on 08/12/2015.
 */
public class ShipController {

    Main main ;

    ShipPosition position = new ShipPosition() ;
    OpponentGrid grid = new OpponentGrid() ;

    @FXML
    AnchorPane anchorPane ;

    @FXML
    Pane player ;

    @FXML
    Pane opponent ;

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
    Label turn ;
    @FXML
    Button startBattle ;

    @FXML
    Button setVertical ;

    @FXML
    Button setHorizontal ;

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
    Rectangle rec0021 ;


    @FXML
    public void battleOnAction(ActionEvent event){
        player.setTranslateX(-270);
        opponent.setDisable(false);
        opponent.setVisible(true);
        startBattle.setDisable(true);
        startBattle.setVisible(false);
        setHorizontal.setDisable(true);
        setVertical.setDisable(true);
        setVertical.setVisible(false);
        setHorizontal.setVisible(false);
        turn.setDisable(false);
        turn.setVisible(true);

        /**try {
            main.showBattleFiend();
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    @FXML
    synchronized public void selectShip(MouseEvent e) {
        System.out.println(e);
        target = (ImageView) e.getSource() ;
        System.out.println(target);
        /**target.setOpacity(.5);
        System.out.println(target);
        //target = (ImageView)e.getSource() ;
        //System.out.println(e.getSource());
       // target.setOpacity(0.5);
       // target.setRotate(90);
       // target.relocate(522,174);
      //  System.out.println(target);
       // target = null ;
        //target = null ;*/
    }

    @FXML
    synchronized public void recSelect(MouseEvent event) throws Exception {
        if (target == null) return;
        rectangle = (Rectangle)event.getSource() ;
        System.out.println(rectangle);
        layoutX = rectangle.getLayoutX() ;
        layoutY = rectangle.getLayoutY() ;
        moveImage() ;
        /*System.out.println(rectangle + " " + layoutX +  " " + layoutY);
        //target.relocate(layoutX,layoutX);
        target.setLayoutX(layoutX);
        target.setLayoutY(layoutY);*/


    }

    @FXML
    public void recAction(MouseEvent event) throws Exception {
        rectangle = (Rectangle)event.getSource() ;
        int pos = (int)rectangle.getId().charAt(3)*10 + (int)rectangle.getId().charAt(4) - 528 ;
        System.out.println(pos);
        System.out.println(grid.getPos(pos));
        Rectangle rectangle1 = rec0021 ;
        if (grid.getPos(pos)){
            rectangle.setFill(Color.RED);
            rec0021.setFill(Color.RED);
           // AudioClip sound = new AudioClip("sounds/strike.mp3");
           // sound.play();
        }
        else {
            rectangle.setFill(Color.BLANCHEDALMOND);
        }
        anchorPane.setTranslateX(1);
        anchorPane.setTranslateX(-1);
        //layoutX = rectangle.getLayoutX() ;
        //layoutY = rectangle.getLayoutY() ;
       // moveImage() ;
        /*System.out.println(rectangle + " " + layoutX +  " " + layoutY);
        //target.relocate(layoutX,layoutX);
        target.setLayoutX(layoutX);
        target.setLayoutY(layoutY);*/


    }



   synchronized public void moveImage() throws InterruptedException {
        target.setOpacity(1);
        target.relocate(layoutX,layoutY);
        int pos = (int)rectangle.getId().charAt(5)*10 + (int)rectangle.getId().charAt(6) - 528 ;
        System.out.println(pos);
        //target = null ;
       if (vertical && target==airCarrier) {
            target.setRotate(90);
            target.setTranslateX(-70);
            target.setTranslateY(80);
        }

        else if (vertical && target== destroyer){
            target.setRotate(90); // no comment to mention This is too much bool shit
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
        target.setDisable(true);

        if (target==airCarrier) position.setPos(5,vertical,pos);
        else if (target==destroyer) position.setPos(4,vertical,pos);
        else if (target==cruiser || target == submarine) position.setPos(3,vertical,pos);
        else if (target==boat) position.setPos(2,vertical,pos);

        position.printPos();

       main.setFullScreen();
       main.resetFullScreen();
    }

    @FXML
    public void setVertical(ActionEvent event){
        vertical = true ;
        System.out.println(vertical);
    }

    @FXML
    public void setHorizontal(ActionEvent event){
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

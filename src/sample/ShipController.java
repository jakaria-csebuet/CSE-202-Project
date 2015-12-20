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

import java.util.Collections;
import java.util.Vector;

/**
 * Created by MD on 08/12/2015.
 */
public class ShipController {

    BattleShip main ;
    GameClient client ;

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
    Rectangle rec0000 ;
    @FXML
    Rectangle rec0001 ;
    @FXML
    Rectangle rec0002 ;
    @FXML
    Rectangle rec0003 ;
    @FXML
    Rectangle rec0004 ;
    @FXML
    Rectangle rec0005 ;
    @FXML
    Rectangle rec0006 ;
    @FXML
    Rectangle rec0007 ;
    @FXML
    Rectangle rec0008 ;
    @FXML
    Rectangle rec0009 ;
    @FXML
    Rectangle rec0010 ;
    @FXML
    Rectangle rec0011 ;
    @FXML
    Rectangle rec0012 ;
    @FXML
    Rectangle rec0013 ;
    @FXML
    Rectangle rec0014 ;
    @FXML
    Rectangle rec0015 ;
    @FXML
    Rectangle rec0016 ;
    @FXML
    Rectangle rec0017 ;
    @FXML
    Rectangle rec0018 ;
    @FXML
    Rectangle rec0019 ;
    @FXML
    Rectangle rec0020 ;
    @FXML
    Rectangle rec0021 ;
    @FXML
    Rectangle rec0022 ;
    @FXML
    Rectangle rec0023 ;
    @FXML
    Rectangle rec0024 ;
    @FXML
    Rectangle rec0025 ;
    @FXML
    Rectangle rec0026 ;
    @FXML
    Rectangle rec0027 ;
    @FXML
    Rectangle rec0028 ;
    @FXML
    Rectangle rec0029 ;
    @FXML
    Rectangle rec0030 ;
    @FXML
    Rectangle rec0031 ;
    @FXML
    Rectangle rec0032 ;
    @FXML
    Rectangle rec0033 ;
    @FXML
    Rectangle rec0034 ;
    @FXML
    Rectangle rec0035 ;
    @FXML
    Rectangle rec0036 ;
    @FXML
    Rectangle rec0037 ;
    @FXML
    Rectangle rec0038 ;
    @FXML
    Rectangle rec0039 ;
    @FXML
    Rectangle rec0041 ;
    @FXML
    Rectangle rec0042 ;
    @FXML
    Rectangle rec0043 ;
    @FXML
    Rectangle rec0044 ;
    @FXML
    Rectangle rec0045 ;
    @FXML
    Rectangle rec0046 ;
    @FXML
    Rectangle rec0047 ;
    @FXML
    Rectangle rec0048 ;
    @FXML
    Rectangle rec0049 ;
    @FXML
    Rectangle rec0040 ;
    @FXML
    Rectangle rec0050 ;
    @FXML
    Rectangle rec0051 ;
    @FXML
    Rectangle rec0052 ;
    @FXML
    Rectangle rec0053 ;
    @FXML
    Rectangle rec0054 ;
    @FXML
    Rectangle rec0055 ;
    @FXML
    Rectangle rec0056 ;
    @FXML
    Rectangle rec0057 ;
    @FXML
    Rectangle rec0058 ;
    @FXML
    Rectangle rec0059 ;
    @FXML
    Rectangle rec0060 ;
    @FXML
    Rectangle rec0061 ;
    @FXML
    Rectangle rec0062 ;
    @FXML
    Rectangle rec0063 ;
    @FXML
    Rectangle rec0064 ;
    @FXML
    Rectangle rec0065 ;
    @FXML
    Rectangle rec0066 ;
    @FXML
    Rectangle rec0067 ;
    @FXML
    Rectangle rec0068 ;
    @FXML
    Rectangle rec0069 ;
    @FXML
    Rectangle rec0070 ;
    @FXML
    Rectangle rec0071 ;
    @FXML
    Rectangle rec0072 ;
    @FXML
    Rectangle rec0073 ;
    @FXML
    Rectangle rec0074 ;
    @FXML
    Rectangle rec0075 ;
    @FXML
    Rectangle rec0076 ;
    @FXML
    Rectangle rec0077 ;
    @FXML
    Rectangle rec0078 ;
    @FXML
    Rectangle rec0079 ;
    @FXML
    Rectangle rec0080 ;
    @FXML
    Rectangle rec0081 ;
    @FXML
    Rectangle rec0082 ;
    @FXML
    Rectangle rec0083 ;
    @FXML
    Rectangle rec0084 ;
    @FXML
    Rectangle rec0085 ;
    @FXML
    Rectangle rec0086 ;
    @FXML
    Rectangle rec0087 ;
    @FXML
    Rectangle rec0088 ;
    @FXML
    Rectangle rec0089 ;
    @FXML
    Rectangle rec0090 ;
    @FXML
    Rectangle rec0091 ;
    @FXML
    Rectangle rec0092 ;
    @FXML
    Rectangle rec0093 ;
    @FXML
    Rectangle rec0094 ;
    @FXML
    Rectangle rec0095 ;
    @FXML
    Rectangle rec0096 ;
    @FXML
    Rectangle rec0097 ;
    @FXML
    Rectangle rec0098 ;
    @FXML
    Rectangle rec0099 ;

    Vector<Rectangle> rec = new Vector<>() ;



    @FXML
    public void battleOnAction(ActionEvent event) throws Exception {
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
        Rectangle []rectangles = {rec0000,rec0001,rec0002,rec0003,rec0004,rec0005,rec0006,rec0007,rec0008,rec0009,
                rec0010,rec0011,rec0012,rec0013,rec0014,rec0015,rec0016,rec0017,rec0018,rec0019,
                rec0020,rec0021,rec0022,rec0023,rec0024,rec0025,rec0026,rec0027,rec0028,rec0029,
                rec0030,rec0031,rec0032,rec0033,rec0034,rec0035,rec0036,rec0037,rec0038,rec0039,
                rec0040,rec0041,rec0042,rec0043,rec0044,rec0045,rec0046,rec0047,rec0048,rec0049,
                rec0050,rec0051,rec0052,rec0053,rec0054,rec0055,rec0056,rec0057,rec0058,rec0059,
                rec0060,rec0061,rec0062,rec0063,rec0064,rec0065,rec0066,rec0067,rec0068,rec0069,
                rec0070,rec0071,rec0072,rec0073,rec0074,rec0075,rec0076,rec0077,rec0078,rec0079,
                rec0080,rec0081,rec0082,rec0083,rec0084,rec0085,rec0086,rec0087,rec0088,rec0089,
                rec0090,rec0091,rec0092,rec0093,rec0094,rec0095,rec0096,rec0097,rec0098,rec0099
        } ;
        Collections.addAll(rec,rectangles) ;
        client = new GameClient(main.player,main.player) ;

    }

    @FXML
    synchronized public void selectShip(MouseEvent e) {
        System.out.println(e);
        target = (ImageView) e.getSource() ;
        System.out.println(target);
        /**System.out.println(target);
        target = (ImageView)e.getSource() ;
        System.out.println(e.getSource());
        target.setOpacity(0.5);
        target.setRotate(90);
        target.relocate(522,174);
        System.out.println(target);
        target = null ;
        arget = null ;*/
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
        main.setFullScreen();
        main.resetFullScreen();
        Rectangle rectangle = (Rectangle)event.getSource() ;
        int pos = (int)rectangle.getId().charAt(3)*10 + (int)rectangle.getId().charAt(4) - 528 ;
        System.out.println(pos);
        System.out.println(grid.getPos(pos));

        if (position.getPos(pos)){
            rec.get(pos).setFill(Color.RED);
        }
        else {
            rec.get(pos).setFill(Color.GRAY);
        }

        if (grid.getPos(pos)){
            rectangle.setFill(Color.RED);
        }
        else {
            rectangle.setFill(Color.GRAY);
        }
        main.setFullScreen();
        main.resetFullScreen();



    }



   synchronized public void moveImage() throws InterruptedException {
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
    public void setMain(BattleShip main) {
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

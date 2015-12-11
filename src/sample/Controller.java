package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Controller {
    ShipController controller ;

    @FXML
    ImageView air = controller.airCarrier ;

    public void reloc(int id){
        Rectangle rectangle = null;
        rectangle.setId("rec"  + id + 0);
        System.out.println(rectangle.getLayoutX()) ;
        //rectangle.getId() ;
    }

    @FXML
    Label massage ;
    //String color[] = {"RED" , "BLACK" , "BLUE" , "GREEN"} ;

    Boolean[] target = {false,false,false,true,true,true,false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,
            true,true,false,false,false,false,false,false,false,false,false,true,true,true,true,false,
            false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,} ;

    void setTarget(Boolean[] target){
        this.target = target ;
    }

    int[] arr = new int[64];
    int i = 0 ;
    int num = 0 ;


    @FXML
    public void mouseClicked(MouseEvent e) {
        Rectangle rec = (Rectangle) e.getSource() ;
        int j = (int)rec.getId().charAt(3) * 10 + (int) rec.getId().charAt(4)-(480+48) ;
        int k = (int) rec.getId().charAt(5) - 48 ;
        //System.out.println((int)rec.getId().charAt(3) * 10 + (int) rec.getId().charAt(4)-(480+48)) ;
        if (k==0){
            massage.setText("Target opponent!!");
        }
        else if(arr[j] >= 1){
            System.out.println("Target another block!!");
            massage.setText("Target another block!!");
        }
        else if(target[j]) {
            rec.setFill(Color.rgb(77,0,0));
            arr[j] += 1 ;
            num++ ;
            System.out.println((int)rec.getId().charAt(3) * 10 + (int) rec.getId().charAt(4)-(480+48) + " " + num + "Opponent Damaged") ;
            massage.setText("");
            if(num == 64) return;
        }

        else {
            rec.setFill(Color.rgb(20,40,82));
            arr[j] += 1 ;
            num++ ;
            System.out.println((int)rec.getId().charAt(3) * 10 + (int) rec.getId().charAt(4)-(480+48) + " " + num ) ;
            massage.setText("");
            if(num == 64) return;
        }

    }
}

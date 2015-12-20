package sample;

import javafx.scene.image.ImageView;

/**
 * Created by MD on 15/12/2015.
 */
public class ShipPosition {
    boolean []pos = new boolean[100] ;

    public void setPos(int shipNumber , boolean isVertical, int pos) {

        if (isVertical){
            for (int i = 0 ; i < shipNumber ; ++i){
                this.pos[pos + i*10] = true ;
            }
        }
        else {
            for (int i = 0 ; i < shipNumber ; ++i){
                this.pos[pos + i] = true ;
            }
        }
    }

    void printPos(){
        for (int i = 0 ; i < 100 ; ++i){
            if (i%10==0) System.out.println();
            System.out.print(pos[i] + "  ");
        }
    }

    boolean getPos(int index){
        return pos[index] ;
    }
}

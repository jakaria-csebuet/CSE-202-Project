package sample;

/**
 * Created by MD on 15/12/2015.
 */
public class OpponentGrid {
    boolean[] pos = {false,  false , false , false , false , false , false , false , false , false,
            false , false , false  ,false , true ,true , true , true , true , false,
            false  ,false , false , false ,false , false , false , false , false , false,
            false , false , false , false , false , false , false ,false  ,false , false,
            false, false , false, false , false  ,false , false , false  ,false, false,
            false , false , true  ,true  ,true,  false , false  ,false  ,false , false,
            true , false , false , false,  false , false , false , false , false , true,
            true , false , false , false , false,  false , false  ,false , false  ,true,
            true , false , false , false , false , false , false  ,false , false  ,false,
            true , false , false  ,false , true  ,true , true , false , false ,false} ;

    boolean getPos(int pos){
        return this.pos[pos] ;
    }
}

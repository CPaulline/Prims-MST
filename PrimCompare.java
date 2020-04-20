import java.util.Comparator;

/**
 * comparator method to compare the costs of the edges passed in through prims method
 */
public class PrimCompare implements Comparator<PrimsData> {

    /**
     * takes two edges and compares the weights
     * @param d 1st cost to be compared
     * @param v 2nd cost to be compared
     */
    public int compare(PrimsData d, PrimsData v){

        //if the first is greater it returns 1
        if(d.getCost() > v.getCost()){
            return 1;

        //if first is less than it returns -1
        }else if(d.getCost() < v.getCost()){
            return -1;

        //if they are equal it returns 0
        }else{
            return 0;
        }
    }
}
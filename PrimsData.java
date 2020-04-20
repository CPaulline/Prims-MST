/**
 * class to hold data for later use in prims
 */
public class PrimsData {
    //integer being stored or examined
    public int i;

    //cost of the integer being stored or examined
    private Double cost;

    /**
     * ctor that initializes the variables being stored
     * @param i index stored
     * @param cost weight stored
     */
    public PrimsData(int i, Double cost){
        this.i = i;
        this.cost = cost;
    }

    /**
     * returns weight of index being stored
     * @return weight of index being stored
     */
    public Double getCost(){
        return cost;
    }
}
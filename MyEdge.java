/**
 * Edge object class that holds the vertexes and weights for each edge 
 */
public class MyEdge implements Edge210{
    public int vert1;
    public int vert2;
    public double weight;

    /**
     * ctor for edge initializing values when passed in
     * @param v1 from vertex
     * @param v2 destination vertex
     * @param weight weight or cost of an edge
     */
    public MyEdge(int v1,int v2,double weight){
        this.vert1 = v1;
        this.vert2 = v2;
        this.weight = weight;
    }

    /**
     * returns vert1 of the edge
     */
    public int getVert1() {
        return this.vert1;
    }

    /**
     * returns vert2 of the edge
     */
    public int getVert2() {
        return this.vert2;
    }

    /**
     * returns the weight of the edge
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * returns the other vert adjacent to the one specified
     * @param v vertex specified
     * @return other vert across the one spexified on an edge
     */
    public int otherVert(int v) {
        if(v == vert1){
            return vert2;
        }else if(v == vert2){
            return vert1;
        }else{
            return vert1;
        }
    }

    /**
     * boolean to check if an edge has a specific vert
     * @param v vert specified
     * @return true if vert is on edge
     */
    public boolean hasVert(int v) {
        if(v == vert1){
            return true;
        }else if(v == vert2){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Normalize the edge by ordering the verts
     */
    public void normalize() {
        if(vert1 > vert2){
            int tempVert = vert1;
            vert1 = vert2;
            vert2 = tempVert;
        }else{
            return;
        }
    }

    /**
     * test to string method to see what was happening when bulding the structure
     */
    public String toString(){
        String s = "["+vert1+", "+vert2+", "+weight+"]";
        return s;
    }

}
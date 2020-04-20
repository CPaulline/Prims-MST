import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class that creates the graph to be put into prims mst
 */
public class MyGraph implements Graph210{

    //number of verts
    private int verts;

    //number of edges
    private int edges;

    //hashmap used to store edges
    private HashMap<Integer, ArrayList<Edge210>> map = new HashMap<>();

    /**
     * ctor to initialize num verts and num edges
     */
    public MyGraph(int v, int e){
        verts = v;
        edges = e;
    }

    /**
     * returns number of verts
     */
    public int numVerts() {
        return verts;
    }

    /**
     * returns number of edges
     */
    public int numEdges() {
        return edges;
    }

    /**
     * adds an edge to the graph 
     * @param v1 first vertex
     * @param v2 second vertex
     * @param weight the weight of the edge
     */
    public Edge210 addEdge(int v1, int v2, double weight) {
        //creates an edge opject to be added
        Edge210 m = new MyEdge(v1, v2, weight);

        //creates an array list if there is no existing one for the vertex specified
        ArrayList<Edge210> l = new ArrayList<>();

        //checks if there is a vertex v1 already and makes one if not then just adds to list
        if(!map.containsKey(v1)){
            l.add(m);
            map.put(v1, l);
            if(map.containsKey(v2)){
                map.get(v2).add(m);
            }
        //checks if there is a vertex v2 already and makes one if not then just adds to list
        }else if(!map.containsKey(v2)){
            l.add(m);
            map.put(v2, l);
            if(map.containsKey(v1)){
                map.get(v1).add(m);
            }
        //if there are aleady existing lists then adds both v1 and v2 variants to list
        }else{
            map.get(v1).add(m);
            map.get(v2).add(m);
        }
        return m;
    }

    /**
     * gets all edges for a specified vertex
     * @param v vertex specified
     * @return list of edges
     */
    public List<Edge210> edges(int v) {
        List<Edge210> list = new ArrayList<>();
        list = map.get(v);
        return list;
    }

    /**
     * gets all edges of the graph
     * @return list of all edges in the graph
     */
    public List<Edge210> allEdges() {
        ArrayList<Edge210> arr = new ArrayList<>();
        for(int e = 0; e < numVerts(); e++){
            ArrayList<Edge210> temp = map.get(e);
            for(Edge210 edge : temp){
                if(!arr.contains(edge)) {
                    arr.add(edge);
                }
            } 
        }
        return arr;
    }

    /**
     * normalises the edges of the graph
     */
    public void normalizeEdges() {
        for(Edge210 e : allEdges()){
            e.normalize();
        }
    }

    /**
     * toString method to help see what was happening when building program
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, ArrayList<Edge210>> v : map.entrySet()){
            sb.append(v.getKey() + ": " + v.getValue());
            sb.append("\n");
        }
        return (sb.toString());
    }
}
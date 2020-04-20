import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.PriorityQueue;

/**
 * These are Helper methods for Program 04. This is optional. It's just one way
 * to set this up. It's also a place where I can share more P4 Helper code.
 * 
 * @author Prof Bill, Cole P, Dev T, Luis G, Jason E
 * @version 0.2
 */
public class GraphHelper {
    /**
     * Read a directed graph from a file.
     * 
     * The format of the file is from Sedgewick, algs4.cs.princeton.edu/43mst:
     *   num-vertices
     *   num-edges
     *   v1 v2 weight   // one line per edge
     * 
     * @param fileName name of graph file
     * @return Returns a new Graph210, or null on error
     */
    public Graph210 readGraphFile( String fileName) {
        BufferedReader reader;
        MyGraph g;

        try{
            //creates a buffered reader in order to read and insert line by line
            reader = new BufferedReader(new FileReader(fileName));
            int numVerts = Integer.parseInt(reader.readLine());
            int numEdges = Integer.parseInt(reader.readLine());

            //inserts the first two lines of info, verts and edges counts
            g = new MyGraph(numVerts, numEdges);

            //read each individual line of the file
            String line = reader.readLine();
            while(line != null){
                String[] splitLine = line.split(" ");

                //changes all values from string to designated object
                int vert1 = Integer.parseInt(splitLine[0]);
                int vert2 = Integer.parseInt(splitLine[1]);
                double weight = Double.parseDouble(splitLine[2]);

                //adds the edge with the info gathered from the file then goes to next line
                g.addEdge(vert1, vert2, weight);
                line = reader.readLine();
            }
            reader.close();
            return g;

        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    } 

    /**
     * Writes a file for the results of the mst that was calculated
     * @param g graph of the mst being written
     */
    public void writeFile(Graph210 g){

        //creates a seperate list for all edges of the graph
        List<Edge210> e = g.allEdges();
        try{
            //prints the first two lines verts and edges then prints the edges with smallest weights
            PrintWriter out = new PrintWriter("results.txt");
            out.println(g.numVerts());
            out.println(g.numVerts() - 1);
            for(Edge210 edge : e){
                if(edge.getWeight() != 0){
                out.println(edge.getVert1() + " " + edge.getVert2() + " " + edge.getWeight());
                }
            }
            out.close();
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
    }

    /**
     * performs prims algorithm on the graph passed in and returns the finished product
     * @param g graph to be used for the algorithm
     * @param startVert starting vert of prims 
     * @return the graph of the finished prims product
     */
    public Graph210 prims(Graph210 g, int startVert){

        //check for all vertexes to be done
        Boolean[] check = new Boolean[g.numVerts()];

        //the cost for all vertexes being checked
        Double[] cost = new Double[g.numVerts()];

        //the parent vertexes
        int[] parent = new int[g.numVerts()];

        //makes a priority queue to hold what is currently being checked
        PriorityQueue<PrimsData> pq = new PriorityQueue<PrimsData>(g.numVerts(), new PrimCompare());

        //initialize all lists to default values
        for(int i = 0; i < g.numVerts(); i++){
            check[i] = false; //to be checked true when done
            cost[i] = Double.MAX_VALUE; //to be set to normal weight when done
            parent[i] = -1; //to be set to vertex destination
        }

        cost[startVert] = 0.0;
        pq.add(new PrimsData(startVert, cost[startVert]));

        while(!pq.isEmpty()){
            PrimsData temp = pq.poll();
            int o = temp.i;
            check[o] = true;
            List<Edge210> edges = g.edges(o);

            //compares each cost to find the shortest path for each vertex
            for(Edge210 e : edges){
                int v2 = e.otherVert(o);
                if(!check[v2] && e.getWeight() < cost[v2]){
                    cost[v2] = e.getWeight();
                    parent[v2] = o;
                    PrimsData temp2 = new PrimsData(v2, cost[v2]);
                    if(!pq.contains(temp2)){
                        pq.add(temp2);
                    }
                }
            }
        }

        //creates a new graph and puts the shortest path to each in and reaturns it
        Graph210 graph = new MyGraph(g.numVerts(), g.numVerts()-1);
        for(int i = 0; i < graph.numVerts(); i++){
            graph.addEdge(i, parent[i], cost[i]);
        }

        return graph;
    }

    /**
     * Returns true if two graphs are equal.
     * Graph edges are normalized (aka, changed) by this method.
     * Once normalized, equal graphs will have exactly equal edges.
     * 
     * @param g1 Graph one
     * @param g2 Graph two
     * @return Returns true if they are equal
     */
    public static boolean compareGraphs( Graph210 g1, Graph210 g2) {
        g1.normalizeEdges();
        g2.normalizeEdges();
        if(g1 == g2){
            return true;
        }else{
            return false;
        }
    }
}
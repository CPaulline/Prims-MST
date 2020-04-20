import java.util.List;

/**
 * This interface models a undirected graph for CSC 210, Spring 2020.
 * Source: Sedgewick's "EdgeWeightedGraph", algs4.cs.princeton.edu/43mst
 * 
 * Your implementation will include a ctor to create a graph, and toString()
 * to write the graph to a file.
 * 
 * @author Prof Bill, Cole P, Dev T, Luis G, Jason E
 * @version 0.2
 */
public interface Graph210 {
    /**
     * Returns the number of vertices in the graph; verts are numbered 0 to V-1.
     * @return Returns the number of vertices
     */
    public int numVerts();

    /**
     * Returns the number of edges in the graph; edges are numbered 0 to E-1.
     * @return Returns the number of edges
     */
    public int numEdges();

    /**
     * Adds an edge to the graph.
     * @param v1 is vert1, from vert
     * @param v2 is vert2, to vert
     * @param weight Edge weight
     * @return Returns the edge just added; on error, null is returned
     */
    public Edge210 addEdge(int v1, int v2, double weight);

    /**
     * Returns a list of edges connected to the vertex.
     * @param v The vertex
     * @return Returns a list of edges connected to the vertex; null is never returned
     * an empty list is returned if 1) no edges, or 2) a bad vert is specified; 
     */
    List<Edge210> edges(int v);

    /**
     * Returns a list of all edges in the graph.
     * @return Returns a list of all edges; never null
     */
    List<Edge210> allEdges();

    /**
     * Two steps: 1) Normalize each edge in the graph, and 2) Properly sort all edges.
     * We do this so that we can (easily) compare two normalized graphs.
     */
    void normalizeEdges();

}
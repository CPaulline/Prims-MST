/**
 * This interface models an edge in a Graph210 for CSC 210, Spring 2020.
 * 
 * @author Prof Bill, Cole P, Dev T, Luis G, Jason E
 * @version 0.2
 */
public interface Edge210 {
    int vert1 = 0;

	/**
     * Returns the first "from" vert on the edge.
     * @return Returns the first vert
     */
    public int getVert1();

    /**
     * Returns the second "to" vert on the edge.
     * @return Returns the second vert
     */
    public int getVert2();

    /**
     * Returns the edge weight, a positive number (greater than 0)
     * @return Returns the edge weight
     */
    public double getWeight();

    /**
     * Returns the "other" vertex in the edge
     * @param v This vert
     * @return Returns the other vert; if v is not on the edge, then vert1 is returned
     */
    public int otherVert( int v);

    /**
     * Returns true if vert is part of the edge.
     * @param v The vert to check
     * @return Returns true if part of edge
     */
    public boolean hasVert( int v);

    /**
     * Normalize the edge by ordering its verts, smallest first.
     * Warning: Only use for UNDIRECTED graphs!
     */
    public void normalize();

}
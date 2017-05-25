/**
 * Created by Andy on 5/24/17.
 */
public class CityNode<T> implements VertexInterface<T> {

    public int label;
    public int elevation;
    public long population;
    public String cityCode, cityName;

    public CityNode(){
        label = 0;
        population = 0;
        elevation = 0;
        cityCode = null;
        cityName = null;
    }

    public CityNode(int number, String cityCode, String cityName, long population, int elevation){
        label = number;
        population = this.population;
        elevation = this.elevation;
        cityCode = this.cityCode;
        cityName = this.cityName;
    }

    /** Gets the vertex's label.
     @return the object that labels the vertex */
    public T getLabel(){

    }
    /** Marks the vertex as visited. */
    public void visit(){

    }
    /** Removes the vertex's visited mark. */
    public void unVisit(){

    }
    /** Sees whether the vertex is marked as visited.
     @return true if the vertex is visited */
    public boolean isVisited(){

    }
    /** Connects this vertex and a given vertex with a weighted edge.
     The two vertices cannot be the same, and must not already
     have this edge between them. In a directed graph, the edge
     points toward the given vertex.
     @param endVertex a vertex in the graph that ends the edge
     @param edgeWeight a real-valued edge weight, if any
     @return true if the edge is added, or false if not */
    public boolean connect(VertexInterface<T> endVertex,
                           int edgeWeight){

    }
    /** Connects this vertex and a given vertex with an unweighted
     edge. The two vertices cannot be the same, and must not
     already have this edge between them. In a directed graph,
     the edge points toward the given vertex.
     @param endVertex a vertex in the graph that ends the edge
     @return true if the edge is added, or false if not */
    public boolean connect(VertexInterface<T> endVertex){

    }

    /** Records the cost of a path to this vertex.
     @param newCost the cost of the path */
    public void setCost(int newCost){

    }
    /** Gets the recorded cost of the path to this vertex.
     @return the cost of the path */
    public double getCost(){

    }

    protected class Edge{

        public VertexInterface<T> vertex;
        private int weight;

        protected Edge(VertexInterface<T> endVertex, int edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex

        protected double getWeight()
        {
            return weight;
        } // end getWeight

    }



}

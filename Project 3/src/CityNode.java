/**
 * Created by Andy on 5/24/17.
 */
public class CityNode implements VertexInterface {

    public int label;
    public int elevationNum;
    public long peopleSize;
    public String code, name;


    public CityNode(int number, String cityCode, String cityName, long population, int elevation){
       label = number;
        peopleSize = population;
        elevationNum = elevation;
        code = cityCode;
        name = cityName;
    }



    /** Gets the vertex's label.
     @return the object that labels the vertex */
    public int getLabel(){
        return label;
    }

    public String getName(){
        return name;
    }
    public String getCityCode(){
        return code;
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
        return true;
    }
    /** Connects this vertex and a given vertex with a weighted edge.
     The two vertices cannot be the same, and must not already
     have this edge between them. In a directed graph, the edge
     points toward the given vertex.
     @param endVertex a vertex in the graph that ends the edge
     @param edgeWeight a real-valued edge weight, if any
     @return true if the edge is added, or false if not */
    public boolean connect(VertexInterface endVertex,
                           int edgeWeight){
        return true;
    }
    /** Connects this vertex and a given vertex with an unweighted
     edge. The two vertices cannot be the same, and must not
     already have this edge between them. In a directed graph,
     the edge points toward the given vertex.
     @param endVertex a vertex in the graph that ends the edge
     @return true if the edge is added, or false if not */
    public boolean connect(VertexInterface endVertex){
        return true;
    }

    /** Records the cost of a path to this vertex.
     @param newCost the cost of the path */
    public void setCost(int newCost){

    }
    /** Gets the recorded cost of the path to this vertex.
     @return the cost of the path */
    public double getCost(){
        return 0.0;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(label + " ");
        sb.append(code + " ");
        sb.append(name + " ");
        sb.append(peopleSize + " ");
        sb.append(elevationNum + " ");

        return sb.toString();
    }

    protected class Edge{

        public VertexInterface vertex;
        private int weight;

        protected Edge(VertexInterface endVertex, int edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor

        protected VertexInterface getEndVertex()
        {
            return vertex;
        } // end getEndVertex

        protected double getWeight()
        {
            return weight;
        } // end getWeight

    }



}

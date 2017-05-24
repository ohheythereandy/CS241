/**
 * Created by Andy on 5/24/17.
 */
import java.util.ArrayList;
public class MapGraph<T> implements GraphInterface<T> {

    int[][] edgeMatrix;
    ArrayList<T> cityList;
    int cityCounter;
    int edgeCounter;

    /**
     * Default constructor instantiates edge matrix and arrayList to hold cities.
     */

    public MapGraph(){

        edgeMatrix = new int[25][25];
        cityList = new ArrayList<>();
        cityCounter =0;
        edgeCounter = 0;
    }

    /** Adds a given vertex to the graph.
     @param vertexLabel an object that labels the new vertex and is
     distinct from the labels of current vertices
     @return true if the vertex is added, or false if not */
    public boolean addVertex(T vertexLabel){
        boolean success = false;

        if(!cityList.contains(vertexLabel)) {
            cityList.add(cityCounter, vertexLabel);
            cityCounter++;
            success = true;
        }

        return success;
    }

    /** Adds a weighted edge between two given distinct vertices that
     are currently in the graph. The desired edge must not already
     be in the graph. In a directed graph, the edge points toward
     the second vertex given.
     @param begin an object that labels the origin vertex of the edge
     @param end an object, distinct from begin, that labels the end
     vertex of the edge
     @param edgeWeight the real value of the edge's weight
     @return true if the edge is added, or false if not */

    public boolean addEdge(T begin, T end, int edgeWeight){


        return true;
    }

    /** Sees whether an edge exists between two given vertices.
     @param begin an object that labels the origin vertex of the edge
     @param end an object that labels the end vertex of the edge
     @return true if an edge exists */
    public boolean hasEdge(T begin, T end){


        return true;
    }

    /** Sees whether the graph is empty.
     @return true if the graph is empty */
    public boolean isEmpty(){

        return true;
    }

    /** Gets the number of vertices in the graph.
     @return the number of vertices in the graph */
    public int getNumberOfVertices(){

        return cityCounter;
    }

    /** Gets the number of edges in the graph.
     @return the number of edges in the graph */
    public int getNumberOfEdges(){

        return edgeCounter;
    }

    /** Removes all vertices and edges from the graph. */
    public void clear(){

    }

}

/**
 * Created by Andy on 5/24/17.
 */
import java.util.ArrayList;
public class MapGraph implements GraphInterface {

    int[][] edgeMatrix;
    ArrayList<CityNode> cityList;
    int cityCounter;
    int edgeCounter;

    /**
     * Default constructor instantiates edge matrix and arrayList to hold cities.
     */

    public MapGraph(){

        edgeMatrix = new int[20][20];
        cityList = new ArrayList<>(20);
        cityCounter =0;
        edgeCounter = 0;
    }


    /** Adds a given vertex to the graph.
     @param vertex an object that labels the new vertex and is
     distinct from the labels of current vertices
     @return true if the vertex is added, or false if not */
    public boolean addVertex(CityNode vertex){
        boolean success = false;

        if(!cityList.contains(vertex)) {
            cityList.add(vertex);
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

    public boolean addEdge(int begin, int end, int edgeWeight){

        boolean added = false;

        if(edgeMatrix[begin -1][ end -1] == 0) {
            edgeMatrix[begin - 1][end - 1] = edgeWeight;
            added = true;
            edgeCounter++;
        }
        return added;
    }

    /** Sees whether an edge exists between two given vertices.
     @param begin an object that labels the origin vertex of the edge
     @param end an object that labels the end vertex of the edge
     @return true if an edge exists */
    public boolean hasEdge(int begin, int end){


        return (edgeMatrix[begin-1][end-1] != 0);
    }

    /** Sees whether the graph is empty.
     @return true if the graph is empty */
    public boolean isEmpty(){

        return cityList.isEmpty();
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

    public void getCityInfo(String cityCode){

        CityNode current;
        String cityInfo = "";
        boolean found = false;

        for(int index = 0; index < 20; index++){
            current = cityList.get(index);

            if(cityCode.equals(current.getCityCode())){
                cityInfo = current.toString();
                found = true;
            }
        }

        if(found)
            System.out.println(cityInfo);
        else{
            System.out.println("Sorry, a city with that city code doesn't exist.");
        }

    }

}

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

    /**
     * Find labels associated with city codes inputted by user. Check to see if they exist,
     * and if a road exists at all.
     * @param source city code associated from source of road
     * @param destination city code associated with destination of road
     */
    public void deleteEdge(String source, String destination){

        CityNode current;
        int sourceLabel = 0;
        int destinationLabel = 0;
        boolean sourceFlag = false;
        boolean destinationFlag = false;

        for(int index = 0; index < 20; index++){
            current = cityList.get(index);

            if(source.equals(current.getCityCode())){
                sourceLabel = current.getLabel();
                sourceFlag = true;
                source = current.getName();
            }
            if(destination.equals(current.getCityCode())){
                destinationLabel = current.getLabel();
                destinationFlag =true;
                destination = current.getName();
            }
        }

        if((!sourceFlag) || (!destinationFlag)) {
            printCodeError();
            return;
        }

        boolean result = hasEdge(sourceLabel, destinationLabel);

        if(result){
            edgeMatrix[sourceLabel -1][ destinationLabel-1] = 0;
            System.out.println("Road deleted!");
        }
        else{
            System.out.println("The road from " + source + " to "
                            + destination  + " doesn't exist!");
        }

    }

    /**
     * Used to get city information associated with the nodes in the arraylist
     * @param cityCode is the city code used as a flag for the search
     */
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

    /**
     * This method adds edge using strings as parameters for the source and destination cities
     * Mostly just finds the corresponding indexes for the strings, and then calls addEdge(int, int , int)
     * @param source
     * @param destination
     * @param distance
     * @return
     */
    public void addEdge(String source, String destination, int distance){

        CityNode current;
        int sourceIndex =0;
        int destinationIndex =0;
        boolean sourceFound = false;
        boolean destinationFound = false;

        for(int index = 0; index < 20; index++){
            current = cityList.get(index);

            if(source.equals(current.getCityCode())){
                sourceIndex = current.getLabel();
                source = current.getName();
                sourceFound = true;
            }
            if(destination.equals(current.getCityCode())){
                destinationIndex = current.getLabel();
                destination = current.getName();
                destinationFound = true;
            }

        }
        if((!sourceFound) || (!destinationFound)) {
            printCodeError();
            return;
        }

        boolean result = addEdge(sourceIndex,destinationIndex, distance);

        if(result){
            System.out.println("You have inserted a road from " + source + " to "
                    + destination + " with a distance of " + distance + ".");
        }
        else{
            System.out.println("A road already exists!");
        }
    }

    /**
     * Method is responsible for printing error message.
     */
    private void printCodeError(){
        System.out.println("One or more of the codes entered might not exist!");
    }

}

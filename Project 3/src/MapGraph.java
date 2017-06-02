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
     * Method takes city codes as parameters, and finds the shortest distance from the first city to the next
     * First finds cityNode associated with the city codes and obtains label of each
     * Calls method to print shortest path
     * @param source city code
     * @param destination city code
     */
    public void getMinDistance(String source, String destination){

        //find cityNode labels
        CityNode current;
        CityNode destinationCity = new CityNode();
        CityNode sourceCity = new CityNode();

        boolean sourceFound = false;
        boolean destinationFound = false;

        for(int index = 0; index < 20; index++){
            current = cityList.get(index);

            if(source.equals(current.getCityCode())){
               sourceCity  = current;
                sourceFound = true;
            }
            if(destination.equals(current.getCityCode())){
                destinationCity = current;
                destinationFound = true;
            }

        }
        if((!sourceFound) || (!destinationFound)) {
            printCodeError();
            return;
        }

        ShortestPath p = new ShortestPath();
        p.dijkstra(edgeMatrix, sourceCity, destinationCity);

    }

    /**
     * Method is responsible for printing error message.
     */
    private void printCodeError() {
        System.out.println("One or more of the codes entered might not exist!");
    }

    class ShortestPath {

        // A utility function to find the vertex with minimum distance value,
        // from the set of vertices not yet included in shortest path tree
        static final int V = 20;

        int minDistance(int dist[], Boolean sptSet[]) {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }



        void dijkstra(int graph[][], CityNode sourceCity , CityNode destinationCity) {
            int dist[] = new int[V]; // The output array. dist[i] will hold
            // the shortest distance from src to i

            // sptSet[i]= true if vertex i is included in shortest path tree
            Boolean sptSet[] = new Boolean[V];
            int[] parentArray = new int[V ];

            // Initialize all distances as INFINITE and stpSet[] as false
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;

            }

            // Distance of source vertex from itself
            dist[sourceCity.getLabel() -1] = 0;
            parentArray[sourceCity.getLabel() -1] = -1;

            // Find shortest path for all vertices
            for (int count = 0; count < V - 1; count++) {
                // minimum distance vertex from set
                int u = minDistance(dist, sptSet);

                //u = processed
                sptSet[u] = true;

                // Update dist value of the adjacent vertices of the
                // picked vertex.
                for (int v = 0; v < V; v++)

                    //Relax:
                    if (!sptSet[v] && graph[u][v] != 0 &&
                            dist[u] != Integer.MAX_VALUE &&
                            dist[u] + graph[u][v] < dist[v]) {
                        parentArray[v] = u;
                        dist[v] = dist[u] + graph[u][v];
                    }
                }



             System.out.println("The minimum distance between " + sourceCity.getName() + " and " + destinationCity.getName() +
             " is " + dist[destinationCity.getLabel() -1 ] + " through the route: " );
             System.out.print(sourceCity.getCityCode() + " ");
            printPath(parentArray, destinationCity.getLabel()-1);
        }

        void printPath(int[] parentArray, int j){


            if(parentArray[j] == -1)
                return;

            printPath(parentArray, parentArray[j] );

            String find = "";
            for(int index = 0; index <20; index++){
                if(j+1 == cityList.get(index).getLabel())
                    find = cityList.get(index).getCityCode();
            }

            System.out.print(find + " ");

        }
    }

}

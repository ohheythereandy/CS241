/**
 * Created by Andy on 5/24/17.
 */
import java.util.Scanner;
public class UserInterface {

    MapGraph map;
    Scanner keyboard;
    URLReader read;

    public UserInterface(MapGraph graph) throws Exception{
        map = graph;
        keyboard = new Scanner(System.in);
        read = new URLReader(map);
    }

    public void startMenu(){
//        System.out.println("Hello! The number of current cities : " + matrix.getNumberOfVertices());
//        System.out.println("Current number of roads: " + matrix.getNumberOfEdges());
        System.out.println("Welcome to Project 3: Graph Implementation Program!");
        System.out.print("********************************************************");

    }

    public void mainMenu(){
        String input = " ";
        while(!input.equals("E")){
            displayPrompt();
            input = keyboard.next().toUpperCase();
            switch (input){
                case "Q":
                    System.out.println("City Code: ");
                    queryCityInformation(keyboard.next());
                    break;
                case "D":
                    break;
                case "I":
                    System.out.println("From City, To City, and Distance?: ");
                    insertRoad(keyboard.next(), keyboard.next(), keyboard.nextInt());
                    break;
                case "R":
                    System.out.println("From City, To City?: ");
                    deleteRoad(keyboard.next(), keyboard.next());
                    break;
                case "H":
                    displayPrompt();
                    break;
                case "E":
                    System.out.println("Thanks for using my program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input not recognized, please try again!");
                    break;
            }
        }
    }

    /**
     * Method is in charge of printing commands user can input to interact with program
     */
    private void displayPrompt(){
        System.out.println("\nQ    Query city information by entering city code.");
        System.out.println("D       Find a minimum distance between two cities.");
        System.out.println("I       Insert a road by entering two city codes and a distance.");
        System.out.println("R       Remove an existing road by entering two city codes.");
        System.out.println("H       Print this message.");
        System.out.println("E       Exit this program.");
        System.out.println("Command?");
    }

    private void deleteRoad(String source, String destination){
        map.deleteEdge(source, destination);
    }

    public void insertRoad(String source, String destination, int distance){

        map.addEdge(source, destination, distance);

    }

    /**
     * This method is responsible for interacting with the MapGraph class to query a city's information
     * @param cityCode is the city code inputted by the user to search for
     */
    public void queryCityInformation(String cityCode){

        map.getCityInfo(cityCode);

    }
}

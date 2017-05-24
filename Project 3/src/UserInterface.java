/**
 * Created by Andy on 5/24/17.
 */
import java.util.Scanner;
public class UserInterface {

    GraphInterface<CityNode> matrix;
    Scanner keyboard;
    URLReader read;

    public UserInterface(GraphInterface<CityNode> graph) throws Exception{
        matrix = graph;
        keyboard = new Scanner(System.in);
        read = new URLReader(matrix);
    }

    public void startMenu(){
        System.out.println("Hello!");
    }

}

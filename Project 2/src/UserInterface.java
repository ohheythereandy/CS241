/**
 * Created by HiThereAndy on 5/12/2017.
 * This class is responsible for handling all interactions with the user .
 */
import java.util.Scanner;

public class UserInterface {

    Scanner keyboard;
    HeapBuilder build;

    public UserInterface(){
        keyboard = new Scanner(System.in);
        build = new HeapBuilder();
    }

    public void WelcomeMessage(){
        System.out.println("Welcome to Heap Construction Project!");
    }

    public void promptInput(){
        int input = 0;
        while(input != 3){
            displayPrompt();
            input = keyboard.nextInt();
            switch(input){
                case 1:
                    build.buildRandomSets(20);
                    break;
                case 2:
                    build.sequentialBuild();
                    build.printSequential();
                    build.optimalBuild();
                    build.printOptimal(build.integerHeap);
                    break;
                case 3:
                    exitMessage();
                    break;
                default:
                    System.out.println("Input not recognized, please try again.");
                    break;
            }
        }

    }

    public void exitMessage(){
        System.out.println("Thank you for using my program!");
        System.exit(0);
    }

    /**
     * Private method used in conjunction with promptInput() to display options for mainMenu
     */
    private void displayPrompt(){
        System.out.println("\nPlease select how to test the program: ");
        System.out.println("1: 20 sets of randomly generated integers.");
        System.out.println("2: Fixed integer values 1-100.");
        System.out.println("3: I don't want to test your program.");
    }

}

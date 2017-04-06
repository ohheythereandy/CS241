/**
 * Created by Andy on 4/4/17.
 */
import java.util.Scanner;
public class UI {

    Scanner keyboard;
    LogicEngine engine;



    public UI(LogicEngine logicEngine){

        keyboard = new Scanner(System.in);
        engine = logicEngine;


    }

    public void menuScreen(){

        System.out.println("Welcome to the Menu:");
        int menuChoice = displayOptions();
        optionLoop(menuChoice);

    }

    private int displayOptions(){

        System.out.println("1) Specify Numbers");
        System.out.println("2) Print Numbers 1-1000 with Recursion");
        System.out.println("3) Print Numbers 1-1000 w/o Recursion");
        System.out.println("4) Print User Numbers Sorted");
        System.out.println("5) Print User Numbers Randomized");
        System.out.println("6) Exit Program");
        System.out.println("Please Select an Option: ");

        int menuChoice = keyboard.nextInt();
        return menuChoice;

    }

    private void optionLoop(int menuChoice){


        if (menuChoice == 1) {
            engine.inputNumbers();
        }
        else if (menuChoice == 2) {
            engine.recursionCount(1000);
            menuScreen();
        }
        else if (menuChoice == 3) {
            engine.regularCount(1000);
            menuScreen();

        }
        else if(menuChoice==4){

        }
        else if(menuChoice==5){

        }
        else if(menuChoice==6){
            System.out.print("See you later!");
            System.exit(0);
        }

    }


}

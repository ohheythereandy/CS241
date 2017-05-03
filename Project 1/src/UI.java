/**
 * Created by Andy on 4/26/17.
 * This class is responsible for taking in input from the user.
 */
import java.util.Scanner;
public class UI {

    Scanner keyboard;
    BinarySearchTree<Integer> bst;

    /**
     * Class constructor
     * @param bst is the BST reference being passed
     */
    public UI(BinarySearchTree bst) {
        keyboard = new Scanner(System.in);
        this.bst = bst;
    }

    /**
     * Prints welcome message and creates initial tree. Only called during start of program
     */
    public void welcomeMessage() {
        System.out.println("Welcome to the Binary Search" +
                "Tree project!");
        System.out.println("A binary search tree will be built" +
                "using the given sequence of values");
        initialTree();

    }

    /**
     * Method that creates initial tree
     */
    private void initialTree() {
        System.out.println("Please enter the initial sequence of values: ");
        //take input as string
        String values = keyboard.nextLine();
        //creates string array from values string, split by space
        String[] valueArr = values.split("\\s+");

        //loop adds entries from individual array entries parsed as Integers
        for (int i = 0; i < valueArr.length; i++) {
            bst.add(Integer.parseInt(valueArr[i]));
        }
        System.out.print("PreOrder:");
        bst.printPreOrder(bst.getRootNode());
        System.out.println();
        System.out.print("InOrder:");
        bst.printInOrder(bst.getRootNode());
        System.out.println();
        System.out.print("PostOrder:");
        bst.printPostOrder(bst.getRootNode());
        System.out.println();
    }

    /**
     * Main interaction with BST done through this method. Loops until user decides to
     * quit.
     */
    public void promptInput() {
        String input = "";
        while (!input.equals("E")) {
            displayPrompt();
            input = keyboard.next().toUpperCase();
            switch (input) {
                case "I":
                    bst.add(keyboard.nextInt());
                    bst.printInOrder(bst.getRootNode());
                    break;
                case "D":
                    bst.remove(keyboard.nextInt());
                    bst.printInOrder(bst.getRootNode());
                    break;
                case "P":
                    bst.findPredecessor(bst.getRootNode(), keyboard.nextInt());
                    break;
                case "S":
                    bst.findSuccessor(bst.getRootNode(), keyboard.nextInt());
                    break;
                case "E":
                    System.out.println("Thanks for using my program!");
                    System.exit(0);
                    break;
                case "H":
                    promptInput();
                    break;
                default:
                    System.out.println("Input not recognized, please try again.");
                    break;
            }
        }
    }

    public void displayPrompt() {
        System.out.println("I   Insert a value");
        System.out.println("D   Delete a value");
        System.out.println("P   Find Predecessor");
        System.out.println("S   Find Successor");
        System.out.println("E   Exit Program");
        System.out.println("H   Display this message");
        System.out.println("Command?");
    }
}

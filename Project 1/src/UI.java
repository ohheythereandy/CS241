/**
 * Created by Andy on 4/26/17.
 */
import java.util.Scanner;
public class UI {

    Scanner keyboard;
    BinarySearchTree<Integer> bst;

    public UI(BinarySearchTree bst) {
        keyboard = new Scanner(System.in);
        this.bst = bst;
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the Binary Search" +
                "Tree project!");
        System.out.println("A binary search tree will be built" +
                "using the given sequence of values");
        initialTree();

    }

    private void initialTree() {
        System.out.println("Please enter the initial sequence of values: ");
        String values = keyboard.nextLine();
        String[] valueArr = values.split("\\s+");

        for (int i = 0; i < valueArr.length; i++) {
            bst.add(Integer.parseInt(valueArr[i]));
        }

        bst.printPreOrder(bst.getRootNode());
        System.out.println();
        bst.printInOrder(bst.getRootNode());
        System.out.println();
        bst.printPostOrder(bst.getRootNode());
        System.out.println();
    }

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

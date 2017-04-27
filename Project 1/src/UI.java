/**
 * Created by Andy on 4/26/17.
 */
import java.util.Scanner;
public class UI {

    Scanner keyboard;
    BinarySearchTree<Integer> bst;

    public UI(BinarySearchTree bst){
        keyboard = new Scanner(System.in);
        this.bst = bst;
    }

    public void welcomeMessage(){
        System.out.println("Welcome to the Binary Search" +
                "Tree project!");
        System.out.println("A binary search tree will be built" +
                "using the given sequence of values");
    }

}

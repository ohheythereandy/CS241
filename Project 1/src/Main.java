/**
 * Created by Andy on 4/26/17.
 * Main class is responsible for instantiating a UI object and passing a new BST as
 * parameter.
 */
public class Main {
    public static void main(String[] args){
        UI ui = new UI(new BinarySearchTree<Integer>());

        ui.welcomeMessage();
        ui.promptInput();
    }

}

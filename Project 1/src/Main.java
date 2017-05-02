/**
 * Created by Andy on 4/26/17.
 */
public class Main {
    public static void main(String[] args){
        UI ui = new UI(new BinarySearchTree<Integer>());

        ui.welcomeMessage();
        ui.promptInput();
    }

}

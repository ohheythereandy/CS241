/**
 * Created by HiThereAndy on 5/12/2017.
 */
public class Main {

    public static void main(String[] args){
        UserInterface UI = new UserInterface(new MaxHeap());
        UI.WelcomeMessage();
        UI.promptInput();
        UI.exitMessage();

    }
}

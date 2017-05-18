/**
 * Created by HiThereAndy on 5/12/2017.
 * Main class is responsible for starting the program
 */
public class Main {

    public static void main(String[] args){
        UserInterface UI = new UserInterface();
        UI.WelcomeMessage();
        UI.promptInput();
        UI.exitMessage();

    }
}

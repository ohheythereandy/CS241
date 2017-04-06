/**
 * Created by Andy on 4/4/17.
 */
public class Main {

    public static void main(String[] args){

        LogicEngine engine = new LogicEngine();
        UI userInterface = new UI(engine);
        userInterface.menuScreen();
    }
}

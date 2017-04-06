/**
 * Created by Andy on 4/4/17.
 */
public class LogicEngine {

    int[] userEntry;

    public LogicEngine(){
        userEntry = new int[10];
    }

    public void inputNumbers(){

    }

    public void recursionCount(int integer){

        int index = integer;
        if(index == 1){
            System.out.println(1);
        }
        else{
            recursionCount(integer-1);
            System.out.println(integer);
        }
    }

    public void regularCount(int integer){

        for(int index = 1; index <= integer; index++){
            System.out.println(index);
        }
    }
}

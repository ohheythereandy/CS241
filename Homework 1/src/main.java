/**
 * Created by Andy on 4/12/17.
 */
public class main {

    public static void main(String[] args){

        RecursiveSolution method = new RecursiveSolution();

        for(int index = 1; index < 100000; index++){
            System.out.print("Recursive Soln. for "+ index + ": ");
            System.out.println(method.factorial(index));
        }
    }
}

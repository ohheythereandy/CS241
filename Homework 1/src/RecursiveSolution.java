/**
 * Created by Andy on 4/12/17.
 */
public class RecursiveSolution {

    public int factorial(int index){
        if(index == 1)
            return 1;
        else{
            return index*(factorial(index-1));
        }

    }

    public int factorialTail(int index){
        if(index ==0)
            return 1;
        return factorialTailHelper(index, 1);
    }

    public int factorialTailHelper(int number, int sum){
        if(number==1)
            return sum;
        else{
            return factorialTailHelper(number -1, sum *number);
        }
    }

}

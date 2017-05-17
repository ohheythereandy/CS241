/**
 * Created by Andy on 5/16/17.
 */
public class HeapBuilder {

    MaxHeap integerHeap;
    int[] entryArray;

    public HeapBuilder(){

        entryArray = new int[100];

    }

    public void sequentialBuild(){
        integerHeap = new MaxHeap(100);
        for(int index = 1; index <= 100; index++){
            integerHeap.add(index);
        }

        printSequential();

    }

    private void printSequential(){

        System.out.print("\nHeap built using sequential method: ");
        integerHeap.printHeap(10);
        System.out.print("\nNumber of swaps: "+ integerHeap.getSwaps());
        for(int index = 1; index <= 10; index++){
            integerHeap.removeMax();
        }
        System.out.print("\nHeap after 10 removals: ");
        integerHeap.printHeap(10);
        System.out.println();

    }

    public void optimalBuild(){

        //fill entryArray with values 1-100
        for(int index = 0; index < entryArray.length; index++){
            entryArray[index]= index+1 ;
        }
        //build heap using appropriate constructor
        integerHeap = new MaxHeap(entryArray);

        //print
        printOptimal(integerHeap);
    }

    private void printOptimal(MaxHeap heap){

        System.out.print("\nHeap built using optimal method: ");
        heap.printHeap(10);
        System.out.print("\nNumber of swaps: "+ heap.getSwaps());
        for(int index = 1 ; index <= 10; index++){
            heap.removeMax();
        }
        System.out.print("\nHeap after 10 removals: ");
        heap.printHeap(10);
        System.out.println();
    }
}

/**
 * Created by Andy on 5/16/17.
 * This class is responsible for interacting with the MaxHeap data structure
 */
import java.util.Random;
public class HeapBuilder {

    MaxHeap integerHeap;
    Random rand;
    int[] entryArray;

    public HeapBuilder() {

        entryArray = new int[100];

    }

    /**
     * This method builds a heap with fixed values 1-100 using the sequential add method
     */
    public void sequentialBuild() {
        integerHeap = new MaxHeap(100);
        for (int index = 1; index <= 100; index++) {
            integerHeap.add(index);
        }
    }

    /**
     * Method prints sequential heap build
     */
    public void printSequential() {

        System.out.print("\nHeap built using sequential method: ");
        integerHeap.printHeap(10);
        System.out.print("\nNumber of swaps: " + integerHeap.getSwaps());
        for (int index = 1; index <= 10; index++) {
            integerHeap.removeMax();
        }
        System.out.print("\nHeap after 10 removals: ");
        integerHeap.printHeap(10);
        System.out.println();

    }

    /**
     * This method builds a heap using the optimized method
     */
    public void optimalBuild() {

        //fill entryArray with values 1-100
        for (int index = 0; index < entryArray.length; index++) {
            entryArray[index] = index + 1;
        }
        //build heap using appropriate constructor
        integerHeap = new MaxHeap(entryArray);
    }

    /**
     * Method prints optimized heap build along with stats
     * @param heap is the reference of the heap that is built using optimized build
     */
    public void printOptimal(MaxHeap heap) {

        System.out.print("\nHeap built using optimal method: ");
        heap.printHeap(10);
        System.out.print("\nNumber of swaps: " + heap.getSwaps());
        for (int index = 1; index <= 10; index++) {
            heap.removeMax();
        }
        System.out.print("\nHeap after 10 removals: ");
        heap.printHeap(10);
        System.out.println();
    }

    /**
     * Method is used to calculate average number of swaps using both build methods a {@code setNumber} amount of times
     * @param setNumber amount of sets that will be built using randomly generated integers 1-100
     */
    public void buildRandomSets(int setNumber) {
        rand = new Random();

        //two counters for swaps
        int sequentialCounter = 0;
        int optimalCounter = 0;

        for (int index = 0; index < setNumber; index++) {
            sequentialCounter = sequentialCounter + sequentialBuildSets();
            optimalCounter = optimalCounter + optimalBuildSets();
        }


        //do stuff
        System.out.println("Average swaps for series of insertion: " + (sequentialCounter / setNumber));
        System.out.println("Average swaps for optimal method: " + (optimalCounter / setNumber));
    }

    /**
     * Method builds optimal heap using randomly generated integers 1-100 with no duplicates
     * @return swaps used to construct heap
     */
    private int optimalBuildSets(){

        boolean[] numberChecker = new boolean[100];
        entryArray = new int[100];
        int randomNumber;

        for(int index = 0; index < entryArray.length; index++){
            //get random number to be added
            randomNumber = rand.nextInt(100) +1;

            //check for duplicates
            while(numberChecker[randomNumber -1] == true){
                randomNumber = rand.nextInt(100) +1;
            }

            numberChecker[randomNumber - 1] = true;
            entryArray[index] = randomNumber;
        }

        integerHeap = new MaxHeap(entryArray);

        return integerHeap.getSwaps();
    }

    /**
     * Method builds heap using randomly generated integers 1-100 (no duplicates) sequentially inserted
     * @return swaps used to construct heap
     */
    private int sequentialBuildSets(){

        boolean[] numberChecker = new boolean[100];
        integerHeap = new MaxHeap(100);
        int randomNumber;

        for(int index = 0; index < 100; index++){

            randomNumber = rand.nextInt(100) +1;

            while(numberChecker[randomNumber -1] == true){
                randomNumber = rand.nextInt(100)+1;
            }

            numberChecker[randomNumber - 1] = true;
            integerHeap.add(randomNumber);

        }

        return integerHeap.getSwaps();
    }

}

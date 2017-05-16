/**
 * Created by Andy on 5/15/17.
 */
public class MaxHeap implements MaxHeapInterface {

    private int[] heap;
    private int lastIndex;
    private static final int DEFAULT_CAPACITY = 100;

    public MaxHeap(){
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity){
        heap = new int[capacity+1];
        lastIndex = 0;
    } //end MaxHeap

    /**
     * Method adds a given entry to a MaxHeap in available location
     * Calculates parentIndex based on lastIndex, and then compares newEntry
     * to data in given parentIndex location.
     * @param newEntry is data to be added to heap
     */
    public void add(int newEntry){
        lastIndex++;
        int newIndex = lastIndex;
        int parentIndex = newIndex / 2;
        //start index searching for appropriate location for newEntry
        while((parentIndex>0) && (newEntry > parentIndex)){
            heap[newIndex] = heap[parentIndex];
            newIndex= parentIndex;
            parentIndex = newIndex/2;
        }//end while
        //assign destination to newEntry
        heap[newIndex] = newEntry;
    }

    public int removeMax(){

    }
    public int getMax(){

    }
    public boolean isEmpty(){

    }
    public int getSize(){

    }
    public void clear(){
        for(;lastIndex > -1; lastIndex--){
            heap[lastIndex] = 0;
        }
    }
}

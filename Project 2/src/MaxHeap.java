/**
 * Created by Andy on 5/15/17.
 */
import java.util.Arrays;
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
        ensureCapacity();
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

    private void ensureCapacity(){
        if(lastIndex >= heap.length)
            heap = Arrays.copyOf(heap, 2* heap.length);
    }

    public int removeMax(){
        int root = 0;

        if(!isEmpty()){
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reHeap(1);
        }
        return root;
    }

    private void reHeap(int rootIndex){
        boolean finished = false;
        int openSlot = heap[rootIndex];
        int leftChildIndex = 2* rootIndex;

        while(!finished && (leftChildIndex <= lastIndex)){
            int largerIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex+1;
            if((rightChildIndex <= lastIndex) &&
                    (heap[rightChildIndex]>heap[largerIndex])){
                largerIndex = rightChildIndex;
            }
            if(openSlot < largerIndex){
                heap[rootIndex] = heap[largerIndex];
                rootIndex = largerIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                finished = true;
        }//end while
        heap[rootIndex] = openSlot;
    }

    public int getMax(){
        return heap[1];
    }
    public boolean isEmpty(){
        return lastIndex==0;
    }
    public int getSize(){
        return lastIndex;
    }
    public void clear(){
        for(;lastIndex > -1; lastIndex--){
            heap[lastIndex] = 0;
        }
    }


}

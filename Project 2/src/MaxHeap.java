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


    /**
     * Default constructor creates heap with {@code capacity} +1 capacity
     * @param capacity is the size desired of heap
     */
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

    /**
     * Private method used by add in order to ensure space for new entry
     * If not enough space, copies original array into new array with 2* current size
     */
    private void ensureCapacity(){
        if(lastIndex >= heap.length)
            heap = Arrays.copyOf(heap, 2* heap.length);
    }

    /**
     * Method used to remove root of heap. Calls private method reHeap to maintain heap
     * integrity.
     * @return data in root that was removed
     */
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

    /**
     * Private method is used along side removeMax() in order to maintain heap integrity
     * after root is removed
     * @param rootIndex is the index of the root that was removed
     */
    private void reHeap(int rootIndex){
        //flag to determine if done
        boolean finished = false;
        int openSlot = heap[rootIndex];

        //find leftChildIndex using formula
        int leftChildIndex = 2* rootIndex;

        //while not finished and the calculated leftChildIndex is valid(exists)
        while(!finished && (leftChildIndex <= lastIndex)){
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex+1;

            //rightChild exists AND is greater than largerChildIndex
            if((rightChildIndex <= lastIndex) &&
                    (heap[rightChildIndex]>heap[largerChildIndex])){
                //assign largerChildIndex to the largestChild
                largerChildIndex = rightChildIndex;
            }
            //openSlot is less than largerChildIndex
            if(openSlot < heap[largerChildIndex]){
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            //calculated indexes surpass lastIndex(are not valid)
            else
                finished = true;
        }//end while
        heap[rootIndex] = openSlot;
    }

    /**
     * Method returns root of MaxHeap, which is the largest value
     * @return largest value in MaxHeap
     */
    public int getMax(){
        return heap[1];
    }

    /**
     * Method is responsible for seeing if a maxHeap is empty
     * @return boolean representing if Heap if empty or not
     */
    public boolean isEmpty(){
        return lastIndex==0;
    }

    /**
     * Method is responsible for getting the size of the heap .
     * @return an integer that represents Heap Size
     */
    public int getSize(){
        return lastIndex;
    }

    /**
     * Method clears heap by setting all contents to 0
     */
    public void clear(){
        for(;lastIndex > -1; lastIndex--){
            heap[lastIndex] = 0;
        }
    }


}

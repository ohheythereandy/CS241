import java.util.Iterator;

/**
 * Created by Andy on 4/26/17.
 */
public class BinarySearchTree<T extends Comparable
        <? super T>> implements SearchTreeInterface<T>
{
    private BinaryNodeInterface<T> root;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(T rootEntry){
        setRootNode(new BinaryNode<T>(rootEntry));
    }//end constructor

    protected void setRootNode(BinaryNodeInterface<T> rootNode){
        root = rootNode;
    }

    protected BinaryNodeInterface<T> getRootNode(){
        return root;
    }

    /** Searches for a specific entry in this tree.
     @param entry an object to be found
     @return true if the object was found in the tree */
    public boolean contains(T entry){
        return getEntry(entry) != null;
    }

    /** Retrieves a specific entry in this tree.
     @param entry an object to be found
     @return either the object that was found in the tree or
     null if no such object exists */
    public T getEntry(T entry){
        return findEntry(getRootNode(), entry);
    }

    private T findEntry(BinaryNodeInterface<T> rootNode, T anEntry){
        T result = null;

        if(rootNode != null)
        {
            T rootEntry = rootNode.getData();
            if(anEntry.equals(rootEntry))
                result = rootEntry;
            else if(anEntry.compareTo(rootEntry)<0)
                result = findEntry(rootNode.getLeftChild(), anEntry);
            else
                result = findEntry(rootNode.getRightChild(), anEntry);
        }
        return result;
    }

    /** Adds a new entry to this tree.
     If the entry matches an object that exists in the tree
     already, replaces the object with the new entry.
     @param newEntry an object to be added to the tree
     @return either null if newEntry was not in the tree already, or
     an existing entry that matched the parameter newEntry
     and has been replaced in the tree */
    public T add(T newEntry){

    }

    /** Removes a specific entry from this tree.
     @param entry an object to be removed
     @return either the object that was removed from the tree or
     null if no such object exists */
    public T remove(T entry){

    }

    /** Creates an iterator that traverses all entries in this tree.
     @return an iterator that provides sequential and ordered access
     to the entries in the tree */
    public Iterator<T> getInorderIterator(){

    }
}

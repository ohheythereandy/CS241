/**
 * Created by Andy on 4/26/17.
 */
import java.util.Iterator;
public interface SearchTreeInterface<T extends Comparable<? super T>> {

    /** Searches for a specific entry in this tree.
     @param entry an object to be found
     @return true if the object was found in the tree */
    public boolean contains(T entry);

    /** Retrieves a specific entry in this tree.
     @param entry an object to be found
     @return either the object that was found in the tree or
     null if no such object exists */
    public T getEntry(T entry);

    /** Adds a new entry to this tree.
     If the entry matches an object that exists in the tree
     already, replaces the object with the new entry.
     @param newEntry an object to be added to the tree
     @return either null if newEntry was not in the tree already, or
     an existing entry that matched the parameter newEntry
     and has been replaced in the tree */
    public T add(T newEntry);

    /** Removes a specific entry from this tree.
     @param entry an object to be removed
     @return either the object that was removed from the tree or
     null if no such object exists */
    public T remove(T entry);

}

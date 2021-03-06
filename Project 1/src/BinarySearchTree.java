/**
 * Created by Andy on 4/26/17.
 */
public class BinarySearchTree<T extends Comparable
        <? super T>> implements SearchTreeInterface<T>
{
    private BinaryNodeInterface<T> root;

    public BinarySearchTree(){
        root=null;
    }

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
        return findEntry(getRootNode(), entry).getData();
    }


    private BinaryNodeInterface<T> findEntry(BinaryNodeInterface<T> rootNode, T anEntry){
        BinaryNodeInterface<T> result = new BinaryNode<>(null);

        //if rootNode exists(Valid Tree)
        if(rootNode != null)
        {
            T rootEntry = rootNode.getData();
            //if given Entry equals root, returns
            if(anEntry.equals(rootEntry))
                result = rootNode;
            //if given Entry is less than root, go left
            else if(anEntry.compareTo(rootEntry)<0)
                result = findEntry(rootNode.getLeftChild(), anEntry);
            //else go right
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
        T result = null;

        if(isEmpty())
            setRootNode(new BinaryNode<>(newEntry));
        else
            result = addEntry(getRootNode(), newEntry);
        return result;
    }

    /**
     * Private method used by public method add. If entry matches entry that exists already, replaces it
     * @param rootNode is root node of given tree
     * @param newEntry is entry to be added
     * @return null if newEntry was not in tree, or existing entry that was replaced
     */
    private T addEntry(BinaryNodeInterface<T> rootNode,T newEntry){
        assert rootNode != null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());

        //if newEntry is rootNode, return rootNode
        if(comparison == 0){
            result = rootNode.getData();
            rootNode.setData(newEntry);
        }
        //if newEntry is less than rootNode, recursive call using leftChild as root
        else if(comparison < 0){
            if(rootNode.hasLeftChild())
                result = addEntry(rootNode.getLeftChild(), newEntry);
            //if no leftChild, add
            else
                rootNode.setLeftChild(new BinaryNode<T>(newEntry));
        }
        else{
            assert comparison > 0;

            if(rootNode.hasRightChild())
                result = addEntry(rootNode.getRightChild(), newEntry);
            else
                rootNode.setRightChild(new BinaryNode<T>(newEntry));
        }

        return result;
    }

    /** Removes a specific entry from this tree.
     @param entry an object to be removed
     @return either the object that was removed from the tree or
     null if no such object exists */
    public T remove(T entry){
        ReturnObject oldEntry = new ReturnObject(null);
        BinaryNodeInterface<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);

        setRootNode(newRoot);

        return oldEntry.get();
    }

    private BinaryNodeInterface<T> removeEntry(BinaryNodeInterface<T> rootNode, T entry,
                                               ReturnObject oldEntry){
        if(rootNode != null){
            T rootData = rootNode.getData();
            int comparison = entry.compareTo(rootData);

            if(comparison ==0){
                oldEntry.set(rootData);
                rootNode = removeFromRoot(rootNode);
            }
            else if(comparison < 0 ){
                BinaryNodeInterface<T> leftChild = rootNode.getLeftChild();
                BinaryNodeInterface<T> subTreeRoot = removeEntry(leftChild, entry, oldEntry);
                rootNode.setLeftChild(subTreeRoot);
            }
            else{
                BinaryNodeInterface<T> rightChild = rootNode.getRightChild();
                rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
            }
        }
        return rootNode;
    }

    private BinaryNodeInterface<T> removeFromRoot(BinaryNodeInterface<T> rootNode)
    {
        //case 1: rootNode has two children
        if(rootNode.hasLeftChild() && rootNode.hasRightChild()){
            //find node with largest entry in left
            BinaryNodeInterface<T> leftSubtree = rootNode.getLeftChild();
            BinaryNodeInterface<T> largestNode = findLargest(leftSubtree);

            rootNode.setData(largestNode.getData());

            rootNode.setLeftChild(removeLargest(leftSubtree));
        }
        else if(rootNode.hasRightChild())
            rootNode = rootNode.getRightChild();
        else{
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;

    }

    private BinaryNodeInterface<T> findLargest(BinaryNodeInterface<T> rootNode){
        if(rootNode.hasRightChild())
            rootNode = findLargest(rootNode.getRightChild());

        return rootNode;
    }

    private BinaryNodeInterface<T> removeLargest(BinaryNodeInterface<T> rootNode){
        if(rootNode.hasRightChild()){
            BinaryNodeInterface<T> rightChild = rootNode.getRightChild();
            BinaryNodeInterface<T> root = removeLargest(rightChild);
            rootNode.setRightChild(root);
        }
        else{
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }


    private boolean isEmpty(){
        return root == null;
    }

    public void printInOrder(BinaryNodeInterface<T> root){
        if(root!= null){
            printInOrder(root.getLeftChild());
            System.out.print(root.getData() + " ");
            printInOrder(root.getRightChild());

        }
    }

    public void printPreOrder(BinaryNodeInterface<T> root){
        if(root!=null) {
            System.out.print(root.getData() + " ");
            printPreOrder(root.getLeftChild());
            printPreOrder(root.getRightChild());
        }
    }

    public void printPostOrder(BinaryNodeInterface<T> root){
        if(root!=null){
            printPostOrder(root.getLeftChild());
            printPostOrder(root.getRightChild());
            System.out.print(root.getData() + " ");
        }
    }

    public void findSuccessor(BinaryNodeInterface<T> root ,T anEntry) {
        BinaryNodeInterface<T> anEntryNode = findEntry(root, anEntry);
        BinaryNodeInterface<T> succ = new BinaryNode<>(null);
        //check if node exists
        if (anEntryNode.getData() != null) {
            //if node has right child, get minimum value
            if (anEntryNode.hasRightChild()) {
                minValue(anEntryNode.getRightChild());
                return;
            }
            //work way down tree
            while (root.getData() != null) {
                //if entry is less than root, go left
                if (anEntryNode.getData().compareTo(root.getData()) < 0) {
                    succ = root;
                    root = root.getLeftChild();

                } else if (anEntryNode.getData().compareTo(root.getData()) > 0) {
                    root = root.getRightChild();
                } else
                    break;
            }
            System.out.println(succ.getData());
        }
        else{
                System.out.println("Sorry, that node doesn't exist!");
            }

    }

    public void findPredecessor(BinaryNodeInterface<T> root, T anEntry){
        BinaryNodeInterface<T> anEntryNode = findEntry(root, anEntry);
        BinaryNodeInterface<T> pred = new BinaryNode<>(null);
        if(anEntryNode.getData()!= null){
            if(anEntryNode.hasLeftChild()){
                maxValue(anEntryNode.getLeftChild());
                return;
            }
            while(root.getData() != null){
                if(anEntryNode.getData().compareTo(root.getData()) > 0){
                    pred = root;
                    root = root.getRightChild();
                }
                else if( anEntryNode.getData().compareTo(root.getData()) < 0){
                    root = root.getLeftChild();
                }
            }
            System.out.println(pred.getData());
        }
        else{
            System.out.println("Sorry, that node doesn't exist");
        }
    }

    /**
     * Find minimum value from given Node, used to find predecessor
     * @param node is given node to search from
     */
    private void maxValue(BinaryNodeInterface<T> node){
        BinaryNodeInterface<T> current = node;

        while(current.hasRightChild()){
            current = current.getRightChild();
        }
        System.out.println(current.getData());
    }

    /**
     * Find minimum value from given Node, used to find Successor
     * @param node is given node to search from
     */
    private void minValue(BinaryNodeInterface<T> node){
        BinaryNodeInterface<T> current = node;

        while(current.hasLeftChild()){
            current = current.getLeftChild();
        }
        System.out.println(current.getData());
    }

    public class ReturnObject {
        private T data;

        public ReturnObject(T dataEntry){
            data = dataEntry;
        }

        private T get(){
            return data;
        }

        private void set(T anEntry){
            data = anEntry;
        }

    }

}

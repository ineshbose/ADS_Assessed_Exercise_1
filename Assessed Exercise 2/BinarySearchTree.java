public class BinarySearchTree<Item extends Comparable<Item>> {

    private Node<Item> root;

    private static class Node<Item>{
       
        private Item key;
        private Node<Item> left;
        private Node<Item> right;
        private Node<Item> p;
        private int size;

        public Node(Item key){
            this.key = key;
            this.left = null;
            this.right = null;
            this.p = null;
            this.size = 1;
        }

        @Override
        public String toString(){
            return " [ " + this.key + " ] ";
        }

    }

    public BinarySearchTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }
    
    private boolean search(Node<Item> x, Item k){
        if(x == null){
            return false;
        }
        if(x.key.equals(k)){
            return true;
        }
        if(k.compareTo(x.key) > 0){
            return search(x.left, k);
        }
        else{
            return search(x.right, k);
        }
    }

    public boolean isElement(Item x){
        return search(this.root, x);
    }

    private Node<Item> min(Node<Item> x){
        if(x.left == null){
            return x;
        }
        else{
            return min(x.left);
        }
    }

    private Node<Item> insert(Node<Item> z, Item x){
        if(z==null){
            z = new Node<Item>(x);
            return z;
        }
        if(x.compareTo(z.key) > 0){
            z.left = insert(z.left, x);
        }
        else if(x.compareTo(z.key) < 0){
            z.right = insert(z.right, x);
        }
        return z;
    }

    public void add(Item x){
        if(isElement(x)){
            return;
        }
        this.root = insert(this.root, x);
    }

    private Node<Item> delete(Node<Item> z, Item x){
        if(z==null){
            return z;
        }
        if(x.compareTo(z.key) > 0){
            z.left = delete(z.left, x);
        }
        else if(x.compareTo(z.key) < 0){
            z.right = delete(z.right, x);
        }
        else{
            if(z.left == null){
                return z.right;
            }
            else if(z.right == null){
                return z.left;
            }
            z.key = min(z.right).key;
            z.right = delete(z.right, z.key);
        }
        return z;
    }

    public void remove(Item x){
        if(isElement(x)){
            this.root = delete(this.root, x);
        }
    }

    private int size(Node<Item> z){
        if(z==null){
            return 0;
        }
        return z.size + size(z.left) + size(z.right);
    }

    public int size(){
        return size(this.root);
    }

    private void union(Node<Item> z, BinarySearchTree<Item> bst){
        if(z!=null){
            union(z.left, bst);
            if(!isElement(z.key)){
                bst.add(z.key);
            }
            union(z.right, bst);
        }
    }

    public BinarySearchTree<Item> union(BinarySearchTree<Item> bst){
        BinarySearchTree<Item> toReturn = this;
        union(bst.root, toReturn);
        return toReturn;
    }

    private void intersection(Node<Item> z, BinarySearchTree<Item> bst){
        if(z!=null){
            intersection(z.left, bst);
            if(!isElement(z.key)){
                bst.add(z.key);
            }
            intersection(z.right, bst);
        }
    }

    public BinarySearchTree<Item> intersection(BinarySearchTree<Item> bst){
        BinarySearchTree<Item> toReturn = new BinarySearchTree<Item>();
        intersection(bst.root, toReturn);
        return toReturn;
    }

    private void difference(Node<Item> z, BinarySearchTree<Item> bst){
        if(z!=null){
            difference(z.left, bst);
            if(isElement(z.key)){
                bst.add(z.key);
            }
            difference(z.right, bst);
        }
    }

    public BinarySearchTree<Item> difference(BinarySearchTree<Item> bst){
        BinarySearchTree<Item> toReturn = new BinarySearchTree<Item>();
        difference(bst.root, toReturn);
        return toReturn;
    }

    public boolean subset(Node<Item> z){
        if(z!=null){
            if(isElement(z.key)){
                return subset(z.left) && true && subset(z.right);
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean subset(BinarySearchTree<Item> bst){
        return subset(bst.root);
    }

    private int max(int x, int y){
        if(x>y){
            return x;
        }
        else{
            return y;
        }
    }

    public int height() {
	    if(this.root == null) { 
	    	return 0;
	    }
	    BinarySearchTree<Item> bst1 = new BinarySearchTree<Item>();
	    BinarySearchTree<Item> bst2 = new BinarySearchTree<Item>();
	    bst1.root = this.root.left;
	    bst2.root = this.root.right;
	    if(bst1.root == null && bst2.root == null) {
	    	return 0;
	    }
	    else if(bst1.root == null && bst2.root != null) {
	    	return bst2.height() + 1;
	    }
	    else if(bst2.root == null && bst1.root != null) {
	    	return bst1.height() + 1;
	    }
	  	    return max(bst1.height(),bst2.height()) + 1;
    }

    private String toString(Node<Item> z){
        if(z==null){
            return "";
        }
        // Here, everything at " [ " is the left sub-tree, and everything at " ] " is the right sub-tree
        return z.key.toString() + " [ " + toString(z.left) + ", " + toString(z.right) + " ] ";
    }

    @Override
    public String toString(){
        return toString(this.root);
    }

}
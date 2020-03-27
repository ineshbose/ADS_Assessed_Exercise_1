import java.util.NoSuchElementException;

public class BST {
    
    private Node root;      // root of BST

    private class Node{
        private int key;    // sorted by key
        private Node left, right, p;
        private int size;   // number of nodes

        public Node(int key, int size){
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
        }
    }

    public BST(){
        root = null;
    }

    private int size(){
        if(this.root == null){
            return 0;
        }
        else{
            return root.size;
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private Node search(Node x, int k){
        if(x==null || x.key == k){
            return x;
        }
        if(k < x.key){
            return search(x.left, k);
        }
        else{
            return search(x.right, k);
        }
    }

    public Node search(int k){
        return search(root, k);
    }

    private Node min(Node x){
        if(x.left == null){
            return x;
        }
        else{
            return min(x.left);
        }
    }

    public Node min(){
        if(isEmpty()){
            throw new NoSuchElementException("BST is empty!");
        }
        else{
            return min(root);
        }
    }

    private Node max(Node x){
        if(x.right == null){
            return x;
        }
        else{
            return max(x.right);
        }
    }

    public Node max(){
        if(isEmpty()){
            throw new NoSuchElementException("BST is empty!");
        }
        else{
            return max(root);
        }
    }

    public void insert(Node z){
        Node y = null;
        Node x = root;
        while(x!=null){
            y = x;
            y.size+=1;
            if(z.key < x.key){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        z.p = y;
        z.size = 1;
        if(y == null){
            root = z;
        }
        else{
            if(z.key < y.key){
                y.left = z;
            }
            else{
                y.right = z;
            }
        }
    }

    public void transplant(Node u, Node v){
        if(u.p == null){
            root = v;
        }
        else if(u == u.p.left){
            u.p.left = v;
        }
        else{
            u.p.right = v;
        }
        if(v!=null){
            v.p = u.p;
        }
    }

    public void delete(Node z){
        if(z.left == null){
            transplant(z, z.right);
        }
        else if(z.right == null){
            transplant(z, z.left);
        }
        else{
            Node y = min(z.right);
            if(y.p!=z){
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z,y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    private void inOrder(Node x){
        if(x!=null){
            inOrder(x.left);
            System.out.println(x.key);
            inOrder(x.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void preOrder(Node x){
        if(x!=null){
            System.out.println(x.key);
            preOrder(x.left);
            preOrder(x.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void postOrder(Node x){
        if(x!=null){
            postOrder(x.left);
            postOrder(x.right);
            System.out.println(x.key);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private boolean checkBST(Node x, int min, int max){
        if(x==null){
            return true;
        }
        if(x.key < min){
            return false;
        }
        if(x.key > max){
            return false;
        }
        return checkBST(x.left, min, x.key) && checkBST(x.right, x.key, max);
    }

    public boolean checkBST(){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
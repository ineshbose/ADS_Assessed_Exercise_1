public class LinkedDequeue<Item>{
    
    private Node<Item> nil;
    private int n;

    private static class Node<Item>{
        private Item key;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public LinkedDequeue(){
        nil = new Node<Item>();
        nil.prev = nil;
        nil.next = nil;
        n = 0;
    }

    public void delete(Node<Item> x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    public void insert(Node<Item> x){
        x.next = this.nil.next;
        this.nil.next.prev = x;
        this.nil.next = x;
        x.prev = this.nil;
    }

    public Node<Item> search(Item k){
        Node<Item> x = this.nil.next;
        while(x!=this.nil && x.key!=k){
            x = x.next;
        }
        return x;
    }

}
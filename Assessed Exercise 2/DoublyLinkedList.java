public class DoublyLinkedList<Item>{

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    private static class Node<Item>{
        
        private Item key;
        private Node<Item> next;
        private Node<Item> prev;

        public Node(Item key, Node<Item> next, Node<Item> prev){
            this.key = key;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString(){
            return " [ " + this.key + " ] ";
        }

    }

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isElement(Item x){
        Node<Item> temp = this.head;
        while(temp!=null){
            if(temp.key.equals(x)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private Node<Item> search(Item x){
        Node<Item> temp = this.head;
        while(temp!=null){
            if(temp.key.equals(x)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void add(Item x){
        if(isElement(x)){
            return;
        }
        Node<Item> toAdd = new Node<Item>(x, this.head, null);
        if(this.head != null){
            this.head.prev = toAdd;
        }
        this.head = toAdd;
        if(this.tail == null){
            this.tail = toAdd;
        }
        size+=1;
    }
    
    public void remove(Item x){
        Node<Item> toRemove = search(x);
        if(this.head == null || toRemove == null){
            return;
        }
        if(this.head == toRemove){
            this.head = toRemove.next;
        }
        if(toRemove.next!=null){
            toRemove.next.prev = toRemove.prev;
        }
        if(toRemove.prev!=null){
            toRemove.prev.next = toRemove.next;
        }
        size-=1;
    }

    public int size(){
        return this.size;
    }

    public DoublyLinkedList<Item> union(DoublyLinkedList<Item> dll){
        Node<Item> temp = dll.head;
        DoublyLinkedList<Item> toReturn = this;
        while(temp!=null){
            if(!isElement(temp.key)){
                toReturn.add(temp.key);
            }
            temp = temp.next;
        }
        return toReturn;
    }

    public DoublyLinkedList<Item> intersection(DoublyLinkedList<Item> dll){
        Node<Item> temp = this.head;
        DoublyLinkedList<Item> toReturn = new DoublyLinkedList<Item>();
        while(temp!=null){
            if(!dll.isElement(temp.key)){
                toReturn.add(temp.key);
            }
            temp = temp.next;
        }
        return toReturn;
    }

    public DoublyLinkedList<Item> difference(DoublyLinkedList<Item> dll){
        Node<Item> temp = this.head;
        DoublyLinkedList<Item> toReturn = new DoublyLinkedList<Item>();
        while(temp!=null){
            if(dll.isElement(temp.key)){
                toReturn.add(temp.key);
            }
            temp = temp.next;
        }
        return toReturn;
    }

    public boolean subset(DoublyLinkedList<Item> dll){
        Node<Item> temp = this.head;
        while(temp!=null){
            if(!dll.isElement(temp.key)){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    private String toString(Node<Item> z){
        if(z==null){
            return "";
        }
        else{
            return z.toString() + " | " + toString(z.next);
        }
    }

    @Override
    public String toString(){
        return toString(this.head);
    }

}
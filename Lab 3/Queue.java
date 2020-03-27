public class Queue<Item>{

    private Item[] q;
    private int head, tail;
    private int n;

    public Queue(){
        q = (Item[]) new Object[2];
        head = 0;
        tail = -1;
        n = 2;
    }

    public int capacity(){
        return (n - this.head + this.tail)%n;
    }

    public void resize(int n){
        Item[] Q = (Item[]) new Object[n];
        for(int i=0; i<n-1; i++){
            Q[i] = q[(this.head + i) % n];
        }
        q = Q;
        this.head = 0;
        this.tail = n-1;
    }

    public void enqueue(Item x){
        if(capacity() == n-1){
            resize(2*n);
        }
        q[this.tail] = x;
        this.tail = (this.tail + 1)%n;
    }

    public Item dequeue(){
        if(this.head == this.tail){
            System.out.println("Underflow!");
            return null;
        }
        Item x = q[this.head];
        this.head = (this.head + 1)%n;
        if(capacity() == n/4){
            resize(n/2);
        }
        return x;
    }

}
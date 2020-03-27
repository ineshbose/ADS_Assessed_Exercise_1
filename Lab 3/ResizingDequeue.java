public class ResizingDequeue<Item>{
    
    private Item[] q;
    private int n;          // number of elements in the dequeue
    private int tail;
    private int head;

    public ResizingDequeue (){
        q = (Item[]) new Object[2];
        n = 0;
        head = 0;
        tail = 0;
    }

    public void resize(int n){
        Item[] Q = (Item[]) new Object[n];
        for(int i=0; i<n; i++){
            Q[i] = q[(head + i)%(this.n)];
        }
        q = Q;
        head = 0;
        tail = n-1;
    }

    public void enqueue(Item x) {
        if (n == q.length){
            resize(2*q.length);
        }
        q[tail] = x;
        tail = (tail + 1)%n;
    }

    public Item dequeue() {
        if (n==0){
            System.out.println("Underflow!");
            return null;
        }
        Item x = q[head];
        head = (head + 1)%n;
        if(n == (n/4)){
            resize(n/2);
        }
        return x;
    }

    public void pushBack(Item x){
        q[tail] = x;
        tail+=1;
    }

    public void pushFront(Item x){
        q[head] = x;
        head+=1;
    }

    public Item popBack(){
        Item element = q[tail];
        q[tail] = null;
        return element;
    }

    public Item popFront(){
        Item element = q[head];
        q[head] = null;
        return element;
    }

}
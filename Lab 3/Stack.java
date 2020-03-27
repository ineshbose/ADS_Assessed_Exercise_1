public class Stack<Item>{

    private Item[] s;
    private int top;
    private int n;

    public Stack(){
        s = (Item[]) new Object[2];
        top = -1;
        n = 2;
    }

    public void resize(int n){
        Item[] S = (Item[]) new Object[n];
        for(int i=0; i<=this.top;i++){
            S[i] = s[i];
        }
        this.s = S;
    }

    public Item pop(){
        if(top == -1){
            System.out.println("Underflow!");
            return null;
        }
        else{
            Item x = s[top];
            this.top-=1;
            if(top > 0 && top == n/4){
                resize(n/2);
            }
            return x;
        }
    }

    public void push(Item x){
        if(top == (n-1)){
            resize(2*n);
        }
        this.top+=1;
        s[top] = x;
    }

    /*public void quickSort(int a[], int p, int r){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(p);
        stack.push(r);
        while(!stack.isEmpty()){
            r = stack.pop();
            p = stack.pop();
            int q = partition(a, p, r);
            if(q-1 > p){
                stack.push(p);
                stack.push(q-1);
            }
            if(q+1 < r){
                stack.push(q+1);
                stack.push(r);
            }
        }
    }*/

}
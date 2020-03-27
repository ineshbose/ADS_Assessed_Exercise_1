public class LinkedList<Item extends Comparable<Item>>{

    private Node<Item> head;

    private static class Node<Item>{
        private Item key;
        private Node<Item> next;
    }
    
    public LinkedList(){
        head = null;
    }

    private Node<Item> merge(Node<Item> a, Node<Item> b){
        if(a==null){
            return b;
        }
        else if(b==null){
            return a;
        }
        Node<Item> x = null;
        if((a.key).compareTo(b.key) < 0){
            x = a;
            x.next = merge(a.next, b);
        }
        else{
            x = b;
            x.next = merge(a, b.next);
        }
        return x;
    }

    private Node<Item> split(Node<Item> a){
        if(a==null || a.next==null){
            return a;
        }
        Node<Item> slow = a;
        Node<Item> fast = a.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node<Item> mid = slow.next;
        slow.next = null;
        return mid;
    }

    public Node<Item> mergeSort(Node<Item> a){
        if(a==null || a.next==null){
            return a;
        }
        Node<Item> middle = split(a);
        Node<Item> x = mergeSort(middle);
        Node<Item> y = mergeSort(middle.next);
        return merge(x,y);
    }

}
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class ADTRunner{

    public static void main(String[] args) throws Exception{
        
        // String path = "M:/ADS/Files/";  /** Change Path Here */
		/** If this gives "(Access denied)" or some error, comment the line below and use hardcoded path above. */
        String path = System.getProperty("user.dir")+"/Files/";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        Random rand = new Random();

        /* Doubly Linked List Tests */
        System.out.println("\n\n////////////////////// DOUBLY LINKED LISTS ////// \n");

        for (File file : listOfFiles) {
        	
            Scanner s = new Scanner(new File(file.toString()));
            long time1 = 0, time2 = 0;

            System.out.println("\n|||| " + file.getName().toUpperCase() + " ||||||||||||||||||||||||| \n");

            DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

            /* Populating ADT */
            time1 = System.nanoTime();
            while(s.hasNext()){
                dll.add(Integer.parseInt(s.next()));
            }
            time2 = System.nanoTime();
            System.out.println("ADD(x) : " + (time2-time1) + " nanoseconds");
            System.out.println("SIZE(DLL) : " + dll.size());

            time1 = System.nanoTime();
            System.out.println("IS-EMPTY(DLL) : " + dll.isEmpty());
            time2 = System.nanoTime();
            System.out.println("IS-EMPTY() : " + (time2-time1) + " nanoseconds");

            /* Deleting all values from ADT */
            s = new Scanner(new File(file.toString()));
            time1 = System.nanoTime();
            while(s.hasNext()){
                dll.remove(Integer.parseInt(s.next()));
            }
            time2 = System.nanoTime();
            System.out.println("\nREMOVE(x) : " + (time2-time1) + " nanoseconds");
            System.out.println("SIZE(DLL) : " + dll.size());

            time1 = System.nanoTime();
            System.out.println("IS-EMPTY(DLL) : " + dll.isEmpty());
            time2 = System.nanoTime();
            System.out.println("IS-EMPTY() : " + (time2-time1) + " nanoseconds");

            /* Repopulating ADT */
            s = new Scanner(new File(file.toString()));
            while(s.hasNext()){
                dll.add(Integer.parseInt(s.next()));
            }

            /* Checking for 100 Random Elements in ADT */
            time1 = System.nanoTime();
            for(int i=0;i<100;i++){
                dll.isElement(rand.nextInt(50000));      // Interval [0, 49999]
            }
            time2 = System.nanoTime();
            System.out.println("\nIS-ELEMENT(x) for 100 values : " + ((time2-time1)/100) + " nanoseconds (AVERAGE)");

            /* Checking ADT Size */
            time1 = System.nanoTime();
            System.out.println("\nSIZE(DLL) : " + dll.size());
            time2 = System.nanoTime();
            System.out.println("SET-SIZE() : " + (time2-time1) + " nanoseconds");

            /* Creating another ADT to test set-functions */
            DoublyLinkedList<Integer> dll2 = new DoublyLinkedList<Integer>();
            for(int i=0; i<100; i++){
                dll2.add(rand.nextInt(10000));
            }
            //System.out.println(dll);
            //System.out.println(dll2);

            time1 = System.nanoTime();
            dll.union(dll2);
            //System.out.println(dll.union(dll2));
            time2 = System.nanoTime();
            System.out.println("\nUNION(DLL) : " + (time2-time1) + " nanoseconds");

            time1 = System.nanoTime();
            dll.intersection(dll2);
            //System.out.println(dll.intersection(dll2));
            time2 = System.nanoTime();
            System.out.println("INTERSECTION(DLL) : " + (time2-time1) + " nanoseconds");

            time1 = System.nanoTime();
            dll.difference(dll2);
            //System.out.println(dll.difference(dll2));
            time2 = System.nanoTime();
            System.out.println("DIFFERENCE(DLL) : " + (time2-time1) + " nanoseconds");

            time1 = System.nanoTime();
            System.out.println("IS DLL1 A SUBSET OF DLL2 : " + dll.subset(dll2));
            time2 = System.nanoTime();
            System.out.println("SUBSET(DLL) : " + (time2-time1) + " nanoseconds");

        }

        /* Binary Search Tree Tests */
        System.out.println("\n\n////////////////////// BINARY SEARCH TREES ////// \n");

        for (File file : listOfFiles) {
        	
            Scanner s = new Scanner(new File(file.toString()));
            long time1 = 0, time2 = 0;

            System.out.println("\n|||| " + file.getName().toUpperCase() + " ||||||||||||||||||||||||| \n");

            BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

            /* Populating ADT */
            time1 = System.nanoTime();
            while(s.hasNext()){
                bst.add(Integer.parseInt(s.next()));
            }
            time2 = System.nanoTime();
            System.out.println("ADD(x) : " + (time2-time1) + " nanoseconds");
            System.out.println("SIZE(BST) : " + bst.size());

            time1 = System.nanoTime();
            System.out.println("IS-EMPTY(BST) : " + bst.isEmpty());
            time2 = System.nanoTime();
            System.out.println("IS-EMPTY() : " + (time2-time1) + " nanoseconds");

            /* Deleting all values from ADT */
            s = new Scanner(new File(file.toString()));
            time1 = System.nanoTime();
            while(s.hasNext()){
                bst.remove(Integer.parseInt(s.next()));
            }
            time2 = System.nanoTime();
            System.out.println("\nREMOVE(x) : " + (time2-time1) + " nanoseconds");
            System.out.println("SIZE(BST) : " + bst.size());

            time1 = System.nanoTime();
            System.out.println("IS-EMPTY(BST) : " + bst.isEmpty());
            time2 = System.nanoTime();
            System.out.println("IS-EMPTY() : " + (time2-time1) + " nanoseconds");

            /* Repopulating ADT */
            s = new Scanner(new File(file.toString()));
            while(s.hasNext()){
                bst.add(Integer.parseInt(s.next()));
            }

            /* Checking for 100 Random Elements in ADT */
            time1 = System.nanoTime();
            for(int i=0;i<100;i++){
                bst.isElement(rand.nextInt(50000));      // Interval [0, 49999]
            }
            time2 = System.nanoTime();
            System.out.println("\nIS-ELEMENT(x) for 100 values : " + ((time2-time1)/100) + " nanoseconds (AVERAGE)");

            /* Checking ADT Size */
            time1 = System.nanoTime();
            System.out.println("\nSIZE(BST) : " + bst.size());
            time2 = System.nanoTime();
            System.out.println("SET-SIZE() : " + (time2-time1) + " nanoseconds");

            /* Creating another ADT to test set-functions */
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
            for(int i=0; i<100; i++){
                bst2.add(rand.nextInt(10000));
            }
            //System.out.println(bst);
            //System.out.println(bst2);

            time1 = System.nanoTime();
            bst.union(bst2);
            //System.out.println(bst.union(bst2));
            time2 = System.nanoTime();
            System.out.println("\nUNION(BST) : " + (time2-time1) + " nanoseconds");

            time1 = System.nanoTime();
            bst.intersection(bst2);
            //System.out.println(bst.intersection(bst2));
            time2 = System.nanoTime();
            System.out.println("INTERSECTION(BST) : " + (time2-time1) + " nanoseconds");

            time1 = System.nanoTime();
            bst.difference(bst2);
            //System.out.println(bst.difference(bst2));
            time2 = System.nanoTime();
            System.out.println("DIFFERENCE(BST) : " + (time2-time1) + " nanoseconds");

            time1 = System.nanoTime();
            System.out.println("IS BST1 A SUBSET OF BST2 : " + bst.subset(bst2));
            time2 = System.nanoTime();
            System.out.println("SUBSET(BST) : " + (time2-time1) + " nanoseconds");

        }

    }

}
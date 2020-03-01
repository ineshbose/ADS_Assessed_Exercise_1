import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class TimeSortingAlgorithms {

    public static boolean TestSortingAlgorithms(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {

        // String path = "M:/ADS/Files/"; /** Change Path Here */
        /** If this gives "(Access denied)", comment the line below and use hardcoded path above. */
        String path = System.getProperty("user.dir") + "/Files/";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            Scanner s = new Scanner(new File(file.toString()));
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (s.hasNext()) {
                list.add(Integer.parseInt(s.next()));
            }
            int[] arr1 = new int[list.size()];
            int[] arr2 = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr1[i] = list.get(i);
                arr2[i]=list.get(i);
            }

            System.out.println("------------------------------------------------------------------");
            System.out.println("Time taken to sort " + file.getName() + ":\n");
            long time1 = System.currentTimeMillis();
            Task1.InsertionSort(arr1);
            long time2 = System.currentTimeMillis();
            long time3 = time2 - time1;
            if (TestSortingAlgorithms(arr1)) {
                System.out.println("InsertionSort: " + time3 + " milliseconds\n");
            } else {
                System.out.println("InsertionSort failed");
            }
            time1 = System.currentTimeMillis();
            Task2.SelectionSort(arr2);
            time2 = System.currentTimeMillis();
            time3 = time2 - time1;
            if (TestSortingAlgorithms(arr2)) {
                System.out.println("SelectionSort: " + time3 + " milliseconds\n\n");
            } else {
                System.out.println("SelectionSort failed");
            }
        }

    }

}
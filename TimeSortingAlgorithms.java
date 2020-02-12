import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TimeSortingAlgorithms{
	
	/** Mapping to names of sorting techniques */
	private static HashMap<Integer, String> mapping = new HashMap<Integer, String>();
	
	
	/**
	 * To calculate time taken by a sorting technique. Avoids having to use another variable.
	 * 
	 * @param t1 Time before sort
	 * @param t2 Time after sort
	 * @return time difference
	 */
	private static long TimeDifference(long t1, long t2) {
		return t2-t1;
	}
	
	
    /**
     * Verifies that sorting technique worked
     * 
     * @param A Array to verify
     * @return boolean value if array is sorted
     */
    private static boolean TestSortingAlgorithms(int[] A){
        for(int i=1; i<A.length; i++){
            if(A[i]<A[i-1]){
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * Tests Quick Sort with Cutoffs in Multiples of 5
     * 
     * @param A	Array to sort
     * @param p Lower limit of Array
     * @param q	Upper limit of Array
     * @param cutoffs Number of Cutoffs / Multiples of 5
     */
    private static void SortWithCutOff(int[] A, int p, int q, int cutoffs) {
    	
    	/** Creating more UNSORTED arrays as per cutoffs */
    	int[][] arr = new int[cutoffs][A.length];
    	
    	/** Copying contents into Arrays */
    	for(int i=0;i<cutoffs;i++) {
    		for(int j=0;j<A.length;j++) {
    			arr[i][j] = A[j];
    		}
    	}
    	
    	long time1=0, time2=0;
    	
    	/** Calling, Testing and Evaluating Sorting Technique */
    	for(int i=1;i<=cutoffs;i++) {
			QuickSortB.cutoff = 5*i;
			time1 = System.currentTimeMillis();
			QuickSortB.Sort(arr[i-1], p, q);
			time2 = System.currentTimeMillis();
			
			if(TestSortingAlgorithms(arr[i-1])) {
        		System.out.println(mapping.get(1) + QuickSortB.cutoff + ": " + TimeDifference(time1, time2) + " milliseconds");
        	}
        	else {
        		System.out.println(mapping.get(1) + QuickSortB.cutoff + " failed.");
        	}
		
    	}
    	
    }

    
    /** Main Method */
    public static void main(String args[]) throws Exception {
    	
    	/** Mapping, for better code */
    	mapping.put(0, "Quick Sort");
    	mapping.put(1, "Quick Sort with Cutoff ");
    	mapping.put(2, "Quick Sort using Median-of-Three");
    	mapping.put(3, "3-Way Quick Sort");
    	mapping.put(4, "Insertion Sort");
    	mapping.put(5, "Merge Sort");
    	mapping.put(6, "Selection Sort");
    	
        // String path = "M:/ADS/Files/";  /** Change Path Here */
		/** If this gives "(Access denied)", comment the line below and use hardcoded path above. */
		String path = System.getProperty("user.dir")+"/Files/";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        /** Loading into ArrayList */
        for (File file : listOfFiles) {
        	
            @SuppressWarnings("resource")
			Scanner s = new Scanner(new File(file.toString()));
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(s.hasNext()){
                list.add(Integer.parseInt(s.next()));
            }

            /** Conversion of ArrayList to Array */
            int[][] arr = new int[mapping.size()][list.size()];
           
            for(int i=0; i<arr.length; i++) {
            	for(int j=0; j<arr[i].length; j++){
            		arr[i][j]=list.get(j);
            	}
            }

            System.out.println("\n=============== " + file.getName().toUpperCase() + " ===============\n");
       
            /** Calling Sorting Techniques */
            for(int i=0;i<arr.length;i++) {
            	long time2 = 0, time1 = System.currentTimeMillis();
            	switch(i) {
            	case 0: QuickSortA.Sort(arr[i], 0, arr[i].length-1);
            			time2 = System.currentTimeMillis();
            			break;
            	case 1: SortWithCutOff(arr[i], 0, arr[i].length-1, 4);
            			break;
            	case 2: QuickSortC.Sort(arr[i], 0, arr[i].length-1);
            			time2 = System.currentTimeMillis();
            			break;
            	case 3: QuickSortD.Sort(arr[i], 0, arr[i].length-1);
            			time2 = System.currentTimeMillis();
            			break;
            	case 4: OtherSorts.InsertionSort(arr[i]);
            			time2 = System.currentTimeMillis();
            			break;
            	case 5: OtherSorts.MergeSort(arr[i], 0, arr[i].length-1);
            			time2 = System.currentTimeMillis();
            			break;
            	case 6: OtherSorts.SelectionSort(arr[i]);
            			time2 = System.currentTimeMillis();
            	}
            	if(TestSortingAlgorithms(arr[i]) && i!=1) {
            		System.out.println(mapping.get(i) + ": " + TimeDifference(time1, time2) + " milliseconds");
            	}
            	else if(i==1) {
            		continue;
            	}
            	else {
            		System.out.println(mapping.get(i) + " failed.");
            	}
            }
            
        }
        
    }

}

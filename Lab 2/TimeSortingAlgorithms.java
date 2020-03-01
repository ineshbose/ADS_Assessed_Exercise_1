import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TimeSortingAlgorithms{
	
	/** Mapping to names of sorting techniques */
	private static HashMap<Integer, String> mapping = new HashMap<Integer, String>();
	
	
    /**
     * Verifies that sorting technique worked
     * 
     * @param A Array to verify
     * @return boolean value if array is sorted
     */
    public static boolean TestSortingAlgorithms(int[] A){
        for(int i=1; i<A.length; i++){
            if(A[i]<A[i-1]){
                return false;
            }
        }
        return true;
    }

    
    /** Main Method */
    public static void main(String args[]) throws Exception {
    	
    	/** Mapping, for better code */
    	mapping.put(0, "Merge Sort");
    	mapping.put(1, "Merge Sort with Cutoff");
    	mapping.put(2, "Bottom-Up Merge Sort");
    	
        // String path = "M:/ADS/Files/";  /** Change Path Here */
		/** If this gives "(Access denied)", comment the line below and use hardcoded path above. */
		String path = System.getProperty("user.dir")+"/Files/";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        /** Loading into ArrayList */
        for (File file : listOfFiles) {
        	
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

			System.out.println("------------------------------------------------------------------");
			System.out.println("Time taken to sort " + file.getName() + ":\n");

            /** Calling Sorting Techniques */
            for(int i=0;i<arr.length;i++) {
            	long time2 = 0, time1 = System.currentTimeMillis();
            	switch(i) {
            	case 0: MergeSort.sort(arr[i], 0, arr[i].length-1);
            			time2 = System.currentTimeMillis();
            			break;
				case 1: MergeSort.sortCutOff(arr[i], 0, (arr[i].length/2), arr[i].length-1);
						time2 = System.currentTimeMillis();
            			break;
            	case 2: MergeSort.bottomUpMS(arr[i], 0, arr[i].length-1);
            			time2 = System.currentTimeMillis();
            	}
            	if(TestSortingAlgorithms(arr[i])) {
            		System.out.println(mapping.get(i) + ": " + (time2-time1) + " milliseconds\n");
            	}
            	else {
            		System.out.println(mapping.get(i) + " failed.\n");
            	}
			}
			
			System.out.println("\n");
            
        }
        
    }

}

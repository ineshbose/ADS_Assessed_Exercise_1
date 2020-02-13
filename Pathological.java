import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pathological{

	/** Change array size here */
	private static int arraySize = 500000;
	/** Required for creating random elements */
    private static Random rand = new Random();

    
	/**
	 * Creates worst case array.
	 * 
	 * @param n Size of array
	 * @return Array
	 */
	private static int[] generatePathological(int n){
        List<Integer> pathologic = new ArrayList<>();
		for(int i=0; i<n; i++){
			int val = rand.nextInt(Integer.MAX_VALUE);
			// Array must not have duplicates.
            if(pathologic.contains(val)){
                i-=1;
				continue;
			}
			else{
                pathologic.add(val);
            }
        }
        if(rand.nextBoolean()){
        	// Array is sorted.
            Collections.sort(pathologic);
        }
        else{
        	// Array is sorted in reverse order.
            Collections.sort(pathologic, Collections.reverseOrder());
        }
        return pathologic.stream().mapToInt(i -> i).toArray();
    }

     /** Main Method */
    public static void main(String[] args){
    	
        System.out.println("Generating array..");
        int[] arr = generatePathological(arraySize);
        System.out.println("Array of size "+arr.length+" generated!");
        
        long time1 = System.currentTimeMillis();
        QuickSortC.Sort(arr, 0, arr.length-1);
        long time2 = System.currentTimeMillis();
        
        if(TimeSortingAlgorithms.TestSortingAlgorithms(arr)) {
            System.out.println("Time taken for Quick Sort: " + (time2-time1) + " milliseconds");
        }
        else {
            System.out.println("Sort failed.");
        }

    }

}
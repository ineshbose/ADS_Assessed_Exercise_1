import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pathological{

	/** Change array size here */
    private static int arraySize = 20000;
	/** Change number of runs here */
    private static int runCases = 20;
	/** Required for creating random elements */
    private static Random rand = new Random();

    
	/**
	 * Creates worst case array.
	 * 
	 * @param n Size of array
	 * @return Array
	 */
	private static int[] generatePathological(int n){
        System.out.println("Generating array..");
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
        Collections.sort(pathologic);
        int secondLargest = (int) pathologic.get(0);
        int largest = pathologic.get(0);
        for (int i = 1; i < pathologic.size(); i++) {
          if(pathologic.get(i) > largest) {
            secondLargest = largest;
            largest = pathologic.get(i);
          }
          if(pathologic.get(i) > secondLargest && pathologic.get(i) != largest) {
            secondLargest = pathologic.get(i);
          }
        }
        Collections.swap(pathologic, 0, pathologic.indexOf(largest));
        Collections.swap(pathologic, n-1, pathologic.indexOf(secondLargest));
        System.out.println("Array of size "+pathologic.size()+" generated!");
        return pathologic.stream().mapToInt(i -> i).toArray();
    }

     /** Main Method */
    public static void main(String[] args){

        long avgTime = 0;
        for(int i=1;i<=runCases;i++){

            System.out.println("\n======== RUN "+i+" ========");
            int[] arr = generatePathological(arraySize);
            
            long time1 = System.currentTimeMillis();
            QuickSortC.Sort(arr, 0, arr.length-1);
            long time2 = System.currentTimeMillis();
            
            if(TimeSortingAlgorithms.TestSortingAlgorithms(arr)) {
                System.out.println("Time taken for Quick Sort: " + (time2-time1) + " milliseconds");
            }
            else {
                System.out.println("Sort failed.");
            }

            avgTime+=(time2-time1);
        }

        avgTime/=runCases;
        System.out.println("\nAverage time taken for Quick Sort: " + avgTime + " milliseconds");

    }

}
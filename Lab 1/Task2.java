public class Task2{

    public static boolean SelectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[pos]) {
                    pos = j;
                }
            }
            int temp = A[pos];
            A[pos] = A[i];
            A[i] = temp;
        }
        return Task1.TestSortingAlgorithms(A);
    }

}
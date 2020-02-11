public class QuickSortB {

	public static int cutoff = 5;

	private static void Swap(int[] A, int i, int j) {
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
	
	private static void InsertionSort(int[] A, int p, int r) {
		for(int i=p;i<=r;i++) {
			for(int j=i;j>p;j--) {
				if(A[j]<A[j-1]) {
					Swap(A,j,j-1);
				}
			}
		}
	}

	private static int Partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p-1;
		for(int j=p; j<r;j++) {
			if(A[j] <= x) {
				i = i+1;
				Swap(A,i,j);
			}
		}
		Swap(A,i+1,r);
		return i+1;
	}
	
	public static void Sort(int[] A, int p, int r) {
		if (r <= p + cutoff) {
			InsertionSort(A, p, r);
			return;
		}
		int q = Partition(A, p, r);
		Sort(A, p, q - 1);
		Sort(A, q + 1, r);

	}
	
}

public class QuickSortC {

	private static void Swap(int[] A, int i, int j) {
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
	
	private static void Median(int[] A, int p, int r) {
		int q = p + (r - p) / 2;
		if (A[p] > A[r]) {
			Swap(A, p, r);
		}
		if (A[q] > A[r]) {
			Swap(A, q, r);
		}
		if (A[q] < A[p]) {
			Swap(A, p, q);
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
		if(p<r) {
			Median(A, p, r);
			int q = Partition(A, p, r);
			Sort(A, p, q-1);
			Sort(A, q+1, r);
		}
	}
	
}

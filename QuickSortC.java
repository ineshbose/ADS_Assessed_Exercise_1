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
		Swap(A, q, p);
	}
	
	private static int Partition(int[] A, int p, int r) {
		int pos = A[p];
		int i = p;
		int j = r + 1;
		while (true) {
			while (A[++i] < pos) {
				if (i == r) {
					break;
				}
			}
			while (A[--j] > pos) {
				if (j == p) {
					break;
				}
			}

			if (i >= j) {
				break;
			}
			Swap(A, i, j);
		}
		Swap(A, p, j);
		return j;
	}
	
	public static void Sort(int[] A, int p, int r) {
		if(p<r) {
			Median(A, p, r);
			int q = Partition(A, p, r);
			Sort(A, p, q - 1);
			Sort(A, q + 1, r);
		}
	}
	
}

public class QuickSortD {
	
	private static void Swap(int[] A, int i, int j) {
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
	
	private static int[] Partition(int[] A, int p, int r) {
		int[] index = {p, r};
		int pos = A[p];
		int i = p;
		while (true) {
			if (A[i] < pos) {
				Swap(A, i++, index[0]++);
			}
			else if (A[i] > pos) {
				Swap(A, i, index[1]--);
			}
			else {
				i++;
			}
			
			if(i > index[1]) {
				break;
			}
		}
		return index;

	}
	
	public static void Sort(int[] A, int p, int r) {
		if(r<=p) {
			return;
		}
		int[] q = Partition(A, p, r);
		Sort(A, p, q[0] - 1);
		Sort(A, q[1] + 1, r);
	}
	
}

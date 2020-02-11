
public class OtherSorts {
	
    public static void InsertionSort(int[] A){
        for(int i=1; i<A.length; i++){
            int key = A[i];
            int j = i-1;
            while(j>=0 && A[j]>key){
                A[j+1] = A[j];
                j=j-1;
            }
            A[j+1] = key;
        }
    }
    
    public static void SelectionSort(int[] A){
        for(int i=0;i<A.length-1;i++){
            int pos = i;
            for(int j=i+1;j<A.length;j++){
                if(A[j]<A[pos]){
                    pos = j;
                }
            }
            int temp = A[pos];
            A[pos] = A[i];
            A[i] = temp;
        }
    }
    
    private static void Merge(int A[], int p, int q, int r) {
    	int n1=q-p+1;
    	int n2=r-q;
    	int[] L = new int[n1+1];
    	int[] R = new int[n2+1];
    	for(int i=0;i<n1;i++) {
    		L[i] = A[p+1];
    	}
    	for(int j=0;j<n2;j++) {
    		R[j] = A[q+1+j];
    	}
    	L[n1] = Integer.MAX_VALUE;
    	R[n2] = Integer.MAX_VALUE;
    	int i=0,j=0;
    	for(int k=p;k<=r;k++) {
    		if(L[i]<=R[j]) {
    			A[k]=L[i];
    			i++;
    		}
    		else {
    			A[k]=R[j];
    			j++;
    		}
    	}
    }
    
    public static void MergeSort(int A[], int p, int r) {
    	if(p<r) {
    		int q = (p+r)/2;
    		MergeSort(A, p, q);
    		MergeSort(A, q+1, r);
    		Merge(A, p, q, r);
    	}
    }


}

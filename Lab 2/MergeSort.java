public class MergeSort {

    public static void merge(int a[], int p, int q, int r) {
        int i, j, k;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++) {
            L[i] = a[p + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = a[q + 1 + j];
        }
        i = 0;
        j = 0;
        k = 1;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int a[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void sortCutOff(int a[], int p, int r, int n) {
        if (r <= p + n - 1) {
            InsertionSort(a, p, r);
            return;
        }
        int q = p + (r - p) / 2;
        sort(a, p, q);
        sort(a, q + 1, r);
        merge(a, p, q, r);
    }

    public static void bottomUpMS(int a[], int p, int r) {
        int n = r - p;
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int i = 0; i < n - sz; i += sz + sz) {
                merge(a, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void InsertionSort(int[] a, int p, int r){
        for(int i=p+1; i<r;i++){
            for(int j=i;j>p && a[j]<a[j-1]; j--){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }

}
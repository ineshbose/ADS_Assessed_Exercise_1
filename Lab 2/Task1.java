public class Task1{

    public static int FACT(int n) {
        assert (n > 0);
        if (n == 1) {
            return 1;
        } else {
            return (n * FACT(n - 1));
        }
    }

    public static int factTail(int n, int m) {
        assert (n > 0);
        assert (m > 0);
        if (n == 1) {
            return m;
        } else {
            return factTail(n - 1, n * m);
        }
    }

    public static int factIter(int n) {
        assert (n > 0);
        int fact = 1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }

}
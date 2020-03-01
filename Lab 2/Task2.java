public class Task2{

    public static int FIB(int n) {
        assert (n >= 0);
        if (n <= 1) {
            return n;
        } else {
            return FIB(n - 1) + FIB(n - 2);
        }
    }

    public static int fibTail(int n, int x, int y) {
        assert (n >= 0);
        assert (x >= 1);
        assert (y >= 0);
        if (n == 0) {
            return x;
        }
        return fibTail(n - 1, x + y, x);
    }

}
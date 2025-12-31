public class IsSorted {

    public static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int i, int last) {

        if (i >= last) {
            return true;
        }

        if (a[i] > a[i + 1]) {
            return false;
        }

        return isSorted(a, i + 1, last);
    }
}

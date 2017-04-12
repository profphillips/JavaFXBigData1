package sort;

/**
 *
 * @author 55jphillip
 */
public class ComplexSort {

    public static void mergeSort(int[] a, String direction) {
        int nElems = a.length;
        int[] workSpace = workSpace = new int[nElems];
        recMergeSort(a, direction, workSpace, 0, nElems - 1);
    }

    public static void recMergeSort(int[] a, String direction, int[] workSpace,
            int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(a, direction, workSpace, lowerBound, mid);
            recMergeSort(a, direction, workSpace, mid + 1, upperBound);
            merge(a, direction, workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    public static void merge(int[] a, String direction, int[] workSpace,
            int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (a[lowPtr] < a[highPtr] && direction.equalsIgnoreCase("A")
                    || a[lowPtr] > a[highPtr] && direction.equalsIgnoreCase("D")) {
                workSpace[j++] = a[lowPtr++];
            } else {
                workSpace[j++] = a[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = a[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = a[highPtr++];
        }
        for (j = 0; j < n; j++) {
            a[lowerBound + j] = workSpace[j];
        }
    }
}

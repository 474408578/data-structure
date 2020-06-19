package wangzhen._12_sorts;

/**
 * 时间复杂度为O(nlogn)
 */
public class MergeSort {

    // 归并排序算法，a是数据，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r的中间位置q, 防止（p+r）
        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a,q+1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        // 初始化变量i,j,k
        int i = p;
        int j = q + 1;
        int k = 0;

        // 申请一个大小跟a[p...r]一样的临时数组
        int[] temp = new int[r-p+1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }


        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组temp
        while (start <= end) {
            temp[k++] = a[start++];
        }

        // 将temp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; i++) {
            a[i+p] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 5, 6, 2, 3, 4};
        mergeSort(a, 6);
        for (int i = 0; i < 6; i++) {
            System.out.println(a[i]);
        }
    }
}

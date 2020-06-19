package wangzhen._11_sort;

/**
 * 动态图：https://visualgo.net/en/sorting
 *
 */
public class Sorts {

    // 冒泡排序
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n -i -1; j++) {
                // 交换
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;// 表示有交换
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    // 插入排序
    public static void insertSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 已排序好的数组挨个和value比较
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j]; // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value;// 插入数据（循环内的a[j] < value，跳出循环后，j--了）
        }
    }

    // 选择排序
    public static void selectSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n-1; i++) {
            // 查找最小值的下标
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                   minIndex = j;
                }

                // 找到最小值后，将这个元素与最小值交换
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }

        }
    }


    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
//        bubbleSort(a, 6);
        selectSort(a, 6);


        for (int i : a) {
            System.out.println(i);
        }


    }
}

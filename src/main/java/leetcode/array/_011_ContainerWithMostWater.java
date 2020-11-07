package leetcode.array;

/**
 * @author xschen
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 1、枚举 O(n^2)
 *
 * 2、左右边界 i, j; 向中间收敛   O(n)
 */


public class _011_ContainerWithMostWater {

    // 枚举
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length -1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = (j - i) * Math.min(height[i], height[j]);
                if (max < tempArea) {
                    max = tempArea;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHight = height[i] < height[j] ? height[i++] : height[j--];
            int tempArea = (j - i + 1) * minHight;
            max = Math.max(max, tempArea);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int i = 0;
        System.out.println(a[i++]);
    }
}

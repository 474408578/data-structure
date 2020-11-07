package leetcode.array;

/**
 * @author xschen
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 思路：
 *      将非0元素往前挪，用指针j表示下一个会非0元素的位置。
 *      如果
 */


public class _283_MoveZero {
    public void moveZeroes(int[] nums) {
        int j = 0;
        // 将所有的非0元素挪到前面nums[0],……nums[j-1]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 后面的元素填充0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xschen
 *
 * 两数之和  https://leetcode-cn.com/problems/two-sum/
 *
 * x + y = target
 */


public class _01_TwoSum {
    // 枚举
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 值为key, 下标为value，遍历加入到hash中。时间复杂度为O(n)
     */
    public int[] method(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


}

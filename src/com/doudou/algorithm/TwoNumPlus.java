package com.doudou.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TwoNumPlus
 * @Author: doudou
 * @Datetime: 2019/9/10-14:02
 * @Description:
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 **/
public class TwoNumPlus {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for (int j=0; j<size; j++) {
            for (int k = j + 1; k < size; k++) {
                if (nums[j] + nums[k] == target) {
                    //如果两数相加等于目标数
                    if (map.containsKey(j) || map.containsKey(k)) continue;
                    map.put(j, nums[j]);
                    map.put(k, nums[k]);
                }
            }
        }
        int[] result = new int[map.size()];
        int i=0;
        for (Integer k : map.keySet()) {
            result[i++] = k;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6,7,9,21,8,3,13,-6};
        int target = 15;
        int[] result = twoSum(nums, target);
    }
}

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.simple;

import java.util.Arrays;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * <p>
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * <p>
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * <p>
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wanbingfa
 * @version $Id: DeleteRepeat.java, v 0.1 2022年07月21日 10:46 PM wanbingfa Exp $
 */
public class DeleteRepeat {

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 2, 3, 5, 5, 7, 8, 12, 13, 13, 14, 14};
        int[] a1 = new int[]{2, 2, 2, 3, 5, 5, 7, 8, 12, 13, 13, 14, 14};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        System.out.println(removeVal(a1,14));
        System.out.println(Arrays.toString(a1));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        removeUnusedVal(nums,slow);
        return slow;
    }

    public static int removeVal(int[] nums,int val){
        int fast = 0;
        int slow = 0;
        while(fast<nums.length){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        removeUnusedVal(nums,slow);
        return slow;
    }

    public static void removeUnusedVal(int[]arr,int size){
        for(int i = size;i<arr.length;i++){
            arr[i] =0;
        }
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.simple;

import java.util.Arrays;

/**
 * @author wanbingfa
 * @version $Id: RemoveDuplicates.java, v 0.1 2022年07月27日 9:28 PM wanbingfa Exp $
 */
public class RemoveDuplicates {
    public static int removeEle(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;

            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 7, 88, 8, 9, 5, 5, 5};
        System.out.println(removeEle(nums, 5));
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length);
    }
}
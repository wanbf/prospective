/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.sort;

import java.util.Arrays;

/**
 * @author wanbingfa
 * @version $Id: ShellSort.java, v 0.1 2022年07月20日 7:23 PM wanbingfa Exp $
 */
public class ShellSort {

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int step = arr.length;
        while (step > 0) {
            //步长
            step = step / 2;
            //分组排序
            for (int group = 0; group < step; group++) {

                //组内排序
                for (int i = step; i < arr.length; i++) {
                    //记录待排序的值
                    int j;
                    //待插入的值
                    int insertVal = arr[i];
                    for (j = i - step; j >= 0; j -= step) {
                        if (arr[j] > insertVal) {
                            arr[j + step] = arr[j];
                        } else break;
                    }
                    arr[j + step] = insertVal;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 7, 1, 21, 23, 90, 231, 324, 32, 12};
        shellSort(a);
        System.out.print(Arrays.toString(a));
    }

}
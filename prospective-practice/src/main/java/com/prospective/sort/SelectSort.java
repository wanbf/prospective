/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author wanbingfa
 * @version $Id: SelectSort.java, v 0.1 2022年07月19日 8:49 PM wanbingfa Exp $
 */
public class SelectSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //记录最小的值
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 7, 1, 21, 23, 90, 231, 324, 32, 12};
        bubbleSort(a);
        System.out.print(Arrays.toString(a));
    }
}
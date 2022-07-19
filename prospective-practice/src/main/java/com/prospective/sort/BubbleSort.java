/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 冒泡排序 属于比较类排序 - 交换排序
 * 最好时间O（n）
 * 平均时间O（n^2）
 * 最坏时间O（n^2）
 *
 * @author wanbingfa
 * @version $Id: BubbleSort.java, v 0.1 2022年07月19日 6:22 PM wanbingfa Exp $
 */
public class BubbleSort {

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 7, 1, 65, 23, 90, 231, 324, 32, 12};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author wanbingfa
 * @version $Id: InsertSort.java, v 0.1 2022年07月19日 7:34 PM wanbingfa Exp $
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            //定义用于比较的数下标
            int insertIndex = i;


            //给insertVal找到插入的位置
            /*
             * 说明：
             * 1.insertIndex>=0保证在给insertVal找插入位置，不越界
             * 2.insertVal<arr[insertIndex]带插入的数，还没有找到插入的位置
             * 3.就需要将arr[insertIndex]后移
             */
            while (insertIndex - 1 >= 0 && insertVal < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            arr[insertIndex] = insertVal;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 7, 1, 21, 23, 90, 231, 324, 32, 12};
        insertSort(a);
        System.out.print(Arrays.toString(a));
    }
}
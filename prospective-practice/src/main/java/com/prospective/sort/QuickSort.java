/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.sort;

import java.util.Arrays;

/**
 * @author wanbingfa
 * @version $Id: QuickSort.java, v 0.1 2022年07月20日 8:35 PM wanbingfa Exp $
 */
public class QuickSort {
    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);

        //排序左边
        sort(arr, left, mid - 1);

        //排序右边
        sort(arr, mid + 1, right);
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {

        int pivot = arr[rightBound]; //指定数组最右边的数是用来比较的值 轴
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while(left <= right && arr[left] <= pivot) left++;
            while(left <= right && arr[right] > pivot) right--;

            if (left < right) {
                //如果 左边的数比右边的数小  两个数交换
                swap(arr, left, right);
            }
        }
        //把left最后一次指向的位置与pivot（轴）的位置交换
        swap(arr, left, rightBound);

        return left; //返回轴的位置
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 7, 1, 21, 23, 90, 231, 324, 32, 12};
        quickSort(a);
        System.out.print(Arrays.toString(a));
    }


}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.search;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author wanbingfa
 * @version $Id: BinarySearch.java, v 0.1 2022年07月19日 9:14 PM wanbingfa Exp $
 */
public class BinarySearch {
    /**
     * 递归二分查找
     *
     * @param arr
     * @param start
     * @param end
     * @param findValue
     * @return
     */
    public static int search(int[] arr, int start, int end, int findValue) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if (midValue > findValue) {
            return search(arr, start, mid - 1, findValue);
        } else if (midValue < findValue) {
            return search(arr, mid + 1, end, findValue);
        } else {
            return mid;
        }

    }


    /**
     * 冒泡排序
     *
     * @param a
     */
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

    /**
     * 循环二分查找
     *
     * @param arr
     * @param findValue
     * @return
     */
    static int search01(int[] arr, int findValue) {
        int mid = 0;
        int right = arr.length;
        int left = 0;
        while (left <= right) {
            mid = left + right / 2;
            if (arr[mid] > findValue) {
                right = mid - 1;
            } else if (arr[mid] < findValue) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找 -多个
     *
     * @param arr
     * @param start
     * @param end
     * @param findValue
     * @return
     */
    public static List<Integer> search02(int[] arr, int start, int end, int findValue) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if (midValue > findValue) {
            return search02(arr, start, mid - 1, findValue);
        } else if (midValue < findValue) {
            return search02(arr, mid + 1, end, findValue);
        } else {
            List<Integer> index = Lists.newArrayList();
            int pre = mid - 1;
            while (arr[pre] == findValue) {
                index.add(pre);
                pre--;
            }
            index.add(mid);
            int next = mid + 1;
            while (arr[next] == findValue) {
                index.add(next);
                next++;
            }
            return index;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 7, 1, 65, 23, 90, 231, 324, 32, 12};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(search(a, 0, a.length, 12));
        System.out.println(search01(a, 12));

        int[] a1 = new int[]{2, 3, 5, 7, 1, 65, 23, 90, 231, 324, 32, 12, 12, 12};
        bubbleSort(a1);
        System.out.println(Arrays.toString(a1));
        System.out.println(search02(a1, 0, a.length, 12));

    }
}
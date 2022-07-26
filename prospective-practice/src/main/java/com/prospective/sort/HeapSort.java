/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.prospective.sort;

import java.util.Arrays;

/**
 * @author wanbingfa
 * @version $Id: HeapSort.java, v 0.1 2022年07月21日 8:30 PM wanbingfa Exp $
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 1, 2, 9, 8, 3, 5};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }



    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        //为什么从arr.length/2-1开始？
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            /*为什么从0开始？
                因为在第一次构建大顶堆后让堆顶元素和末尾元素进行交换
                而对于其他的非叶子结点所对应的子树都是大顶堆就无需调整，
                只需要堆顶元素(下标为0的非叶子结点)的子树调整成大顶堆
            */
            adjustHeap(arr, 0, j);

        }
    }

    /**
     * 构建大顶堆
     * 注意：
     * 这个方法并不是将整个树调整成大顶堆
     * 而是以i对应的非叶子结点的子树调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      非叶子结点在数组中的索引(下标)
     * @param length 进行调整的元素的个数，length是在逐渐减少的
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        /*取出当前非叶子结点的值保到临时变量中*/
        int temp = arr[i];

        /*j=i*2+1表示的是i结点的左子结点*/
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) { //左子结点小于右子结点
                j++; //j指向右子结点
            }
            if (arr[j] > temp) { //子节点大于父节点
                arr[i] = arr[j]; //把较大的值赋值给父节点
                //arr[j] = temp; 这里没必要换
                i = j; //让i指向与其换位的子结点 因为
            } else {
                /*子树已经是大顶堆了*/
                break;
            }
        }
        arr[i] = temp;
    }
}
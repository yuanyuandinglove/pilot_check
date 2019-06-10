package com.pilot.design.pattern.sunfa;

/**
 * BuildHeap class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public class BuildHeap {

    public static void main(String[] args) {
        int []array = {1, 4, 2, 3, 6, 8, 7, 5};

        int[] arr = {7,23,45,9,40,73,12,49};

        buildHeap(array);


        sort(array,array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"-");
        }
        System.out.println("");
        buildHeap( arr);
        sort(arr,arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }
    }


    /**
     * 构建大根堆
     * node = i
     * left = 2i+1;
     * right = 2i+2
     *
     * @param array
     * @return
     */

    public static int[] buildHeap(int []array) {
        if (array == null || array.length <= 0) {
            return array;
        }
        int length = array.length;
        if (length == 1) {
            return array;
        }

        for (int i = (length - 2) / 2; i >= 0; i--) {

            adjust(array, i, length);
        }
        return array;
    }

    public static void adjust(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            if (i < length - 1 && array[i] < array[i + 1]) {
                i++;
            }
            if (temp >= array[i]) {
                break;
            } else {
                array[k] = array[i];
                k = i;
            }

        }
        array[k] = temp;
    }

    /**
     * 堆排序
     * @param array
     * @param length
     */
    public static void sort(int []array, int length){

        for (int i = length -1 ; i > 0; i --){
             int temp = array[i];
             array[i] = array[0];
             array[0] = temp;
             adjust(array,0,i);
        }
    }
}

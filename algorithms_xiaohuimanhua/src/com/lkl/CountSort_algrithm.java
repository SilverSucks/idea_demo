package com.lkl;

public class CountSort_algrithm {
    public static int[] countSort(int[] arr){
        //获取要排序数组中的最大值
        int max = GetMax(arr);
        //创建排序数组
        int[] countArray = new int[max+1];
        //遍历原始数组，并填充排序数组
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]]++;
        }
        //打印一下排序数组
        for (int i : countArray) {
            System.out.printf("%3d",i);
        }
        int[] resultArray = new int[arr.length];  //结果数组用来存放最后的排序结果
        //遍历统计数组，得到最终结果
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int i1 = 0; i1 < countArray[i]; i1++) {
                resultArray[index++] = i;
            }
        }
        return resultArray;
    }
    public static int GetMax(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,3,7,4,8,4,3,2};
        /*int i = GetMax(arr);
        System.out.println(i);*/
        int[] countSort = countSort(arr);
        System.out.println();
        for (int i : countSort) {
            System.out.printf("%3d",i);
        }
    }
}

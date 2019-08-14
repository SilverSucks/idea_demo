package com.lkl;

import java.util.Arrays;

public class findNearestNumber {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        /*System.out.println(findFirst(ints));
        exchange(ints,findFirst(ints));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }*/
        int[] nearestNumber = findNearestNumber(ints);
        for (int i = 0; i < nearestNumber.length; i++) {
            System.out.println(nearestNumber[i]);
        }
    }
    public static int[] findNearestNumber(int[] numbers){
        //首先保留一下原始数组
        int[] copyOf = Arrays.copyOf(numbers, numbers.length);
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int location = findFirst(copyOf);
        //如果数字置换的边界为0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回自身
        if (location == 0)
            return numbers;
        //2.把逆序区域的前一位与逆序区域中刚刚大于它的数字交换
        exchange(copyOf,location);
        //3.将原来的逆序区域转为顺序
        sortRemain(copyOf,location);
        return copyOf;

    }
    //找出逆序区域的（左）边界，在数组中的下标
    public static int findFirst(int[] arr){
        for (int i = arr.length-1;i > 0;i--){
            if (arr[i] > arr[i-1])
                return i;
        }
        return 0;
    }
    //把逆序区域中的前一位，与逆序区域中刚刚大于它的数字交换,传入 数组参数和逆序区域中的前一位的下表
    public static void exchange(int[] arr,int location){
        int head = arr[location-1];  //逆序左边界的左边的数字
        //把逆序左边界的数字head 与 逆序区间中刚刚大于head的数字进行交换
        for (int i=arr.length-1;i>=location;i--){
            if (arr[i]>arr[location-1]){
                arr[location-1] = arr[i];
                arr[i] = head;
                break;
            }
        }
    }
    //从交换过的数字后面的数字进行排序
    public static void sortRemain(int[] arr,int location){
        for (int i=location,j=arr.length-1;i<j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

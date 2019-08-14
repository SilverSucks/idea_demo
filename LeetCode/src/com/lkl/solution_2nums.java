package com.lkl;

import java.util.HashMap;

/*
一个int[]数组中，找出两个数相加为0。写这个算法是为了解三个数相加为0做铺垫
 */
public class solution_2nums {
    public static void main(String[] args) {
        int[] arr= {-1,0,1,2,-1,4};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i],0-arr[i]);
        }
        for (Integer integer : hashMap.keySet()) {
//            System.out.println(integer+":"+hashMap.get(integer));
            if (integer!=0 && hashMap.containsValue(integer)){
                System.out.println(integer+"与"+hashMap.get(integer));
            }
        }
        //今天找到了两个数相加等于0，明天找三个数相加等于0
    }

}

package com.lkl;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0;i < 5;i++){
            hashMap.put(i,i);
        }
        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer+":"+hashMap.get(integer));
        }
        hashMap.clear();
        System.out.println("after clear");
        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer+":"+hashMap.get(integer));
        }
    }
}

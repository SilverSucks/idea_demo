package com.lkl;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(0,-1);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }
}

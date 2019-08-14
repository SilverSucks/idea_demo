package com.lkl;

import java.util.*;

public class solution_3nums {
    public static void main(String[] args) {

        int[] arr = {-1,0,1,2,-1,-4};
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap1.put(arr[i],0-arr[i]);
            hashMap2.put(arr[i],0-arr[i]-arr[i]);
        }
        List<List<Integer>> lists = new ArrayList<>();

        //判断hashMap2中的value是否在key中
        ArrayList<Integer> list = null;
        for (Integer integer : hashMap2.keySet()) {
            list = new ArrayList<>();
            if (hashMap2.containsKey(hashMap2.get(integer))){
//                System.out.println(integer+":"+hashMap2.get(integer));
                list.add(integer);
                list.add(hashMap2.get(integer));
//                System.out.println(list);
                //先把后两个数找出来存放到lists中
                lists.add(list);
            }
        }
        //对于HashMap1中找出与集合中两个数相加等于0的key，并把这个key添加到集合中
        for (List<Integer> integers : lists) {
            int i = integers.get(0) + integers.get(1);
            for (Integer integer : hashMap1.keySet()) {
                if (i == hashMap1.get(integer)){
                    integers.add(0,integer);
                    break;
                }
            }
        }
        //到此为止，找出了相加为0的三个数，但是还有排除重复的值，明天进行排重！
        //遍历lists
        for (List<Integer> list_child : lists) {
            System.out.println(list_child);
        }

        //map集合的foreach遍历方式
        /*for (Integer integer : hashMap2.keySet()) {
            if (hashMap2.containsValue(integer))
                System.out.println(integer+":"+hashMap2.get(integer));
        }*/
        //map集合的keyset遍历方式
        /*
        Set<Integer> keySet = hashMap2.keySet();
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()){
            Integer key = it.next();
            System.out.println(key+"："+hashMap2.get(key));
        }*/

        /*
        map集合的entryset遍历方式
         */
        /*Set<Map.Entry<Integer, Integer>> entries = hashMap2.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }*/
//        }
    }
}

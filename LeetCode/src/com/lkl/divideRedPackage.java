package com.lkl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
分红包算法
 */
public class divideRedPackage {
    public static void main(String[] args) {
        List<Integer> list = divideRedPackage(1000, 10);
        int count = 0;
        for (Integer integer : list) {
            System.out.println(integer);
            count += integer;
        }
        System.out.println("总金额"+count);
    }
    public static List<Integer> divideRedPackage(int MoneyNum, int peopleNum){
        ArrayList<Integer> divide_method = new ArrayList<>();    //存储分红包的一个结果
        int rest_Money = MoneyNum;    //剩余金额的初始值=总金额
        int rest_people = peopleNum;  //没有抢红包的人数的初始值=总人数
        Random random = new Random();
        //用一个循环来模拟分红包算法
        for (int i=0;i<peopleNum-1;i++){
            //每一次分所分的值是区间[1,rest_Money/rest_people*2]中的一个随机数
            int money = random.nextInt(rest_Money/rest_people*2+1);
            divide_method.add(money);
            rest_Money = rest_Money - money;  //每分给一个人，对应的减去相应的金额
            rest_people--;                    //对应的没有抢红包的人数也减少

        }
        divide_method.add(rest_Money);//剩余的最后一个都归最后一个人
        return divide_method;

    }
}

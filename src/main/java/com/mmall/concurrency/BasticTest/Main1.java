package com.mmall.concurrency.BasticTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main1 {

    public static void main(String[] args){
        //随机生成十个不重复的数
        Random r = new Random();
        List<Integer> list = new ArrayList<Integer>();
        int i;
        while(list.size() < 10){
            i = r.nextInt(10000);
            if(!list.contains(i)){
                list.add(i);
            }
        }
        System.out.println(list);

       //反转数字
        for (i=0;i<list.size();i++) {
            list.set(i,revertNumber(list.get(i)));
        }
        System.out.println(list);

        //降序排序
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);

    }
    public static int revertNumber(int orgNum){
        int reverNum = 0;
        while(orgNum!=0){
            int remainder = orgNum%10;
            orgNum = orgNum/10;
            reverNum = reverNum*10+remainder;
        }
        return reverNum;
    }

}

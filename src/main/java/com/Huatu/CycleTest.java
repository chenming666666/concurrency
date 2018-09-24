package com.Huatu;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CycleTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("该数字原来的位置是：" + cycle(50,3));

    }

    private static int cycle(int n, int m) {
        List<Integer> dataList = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            dataList.add(new Integer(i+1));
        }
        int index = -1;
        while (dataList.size()>1) {
            index = (index + m)%dataList.size();
            dataList.remove(index--);   //去除该数字，index减一
            //displayList(dataList);    //清除后打印，观察结果
            //System.out.println();
        }

        //return dataList.get(0);也可以替换下一行
        return ((Integer)dataList.get(0)).intValue();
    }

    //打印每次剩余序列
   /* private static void displayList(List<Integer> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            int a = dataList.get(i);
            System.out.print(a + " ");
        }
    }*/

}

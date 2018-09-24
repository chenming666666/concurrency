package com.Huatu;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharSqeStatistic {
   public static void main(String[] args){

       Scanner in = new Scanner(System.in);
       int size = 0;
       size = Integer.parseInt(in.nextLine().trim());
       String[] array = new String[size];

       String tmp;
       for(int i = 0; i < size; i++) {
           tmp = in.nextLine().trim();
           array[i] = tmp;
       }

       String[] res = char_count(array);
       for(int i = 0; i < res.length;i++) {
           System.out.println(res[i]);
       }

   }
    static String[] char_count(String[] str_arr) {
        int length = str_arr.length;
        List<String> list = new ArrayList<>();

        list.add(str_arr[0]);
        if(str_arr.length==1)
            list.add(String.valueOf(1));

        int k=1;
        int count=1;
        for (int i = 1; i <str_arr.length ; i++){
            if(str_arr[i].equals(str_arr[i-1])) {  //字符串的比较，==号比较的是地址
                count++;
            }else if((k+1)%2==0){//字母是奇数，数字是偶数；(在list中的下标位置)
                list.add(String.valueOf(count));
                count=1;
                k++;
                i--;       //遇到不一样的字符串，统计上一个字符串出现次数的时候，指向本字符串的指针不进位（因为暂时不处理此字符串）。
            }else{
                list.add(str_arr[i]);
                k++;
            }
            if(i==str_arr.length-1)
                list.add(String.valueOf(count));
        }

        String[] arr=new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}

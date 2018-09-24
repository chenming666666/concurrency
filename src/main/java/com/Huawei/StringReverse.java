package com.Huawei;

import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] arr=in.nextLine().split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char[] tmp=arr[i].toCharArray();
            char[] chars=new char[tmp.length];
            for (int p = tmp.length-1,j = 0; p >= 0; p--,j++) {
               chars[j]=tmp[p];
            }
            String st=new String(chars);
            if(i<arr.length-1)
                 sb.append(st+" ");
            else
                sb.append(st);
        }

        System.out.println(sb);
    }
}

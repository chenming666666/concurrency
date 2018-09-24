package com.mmall.concurrency.example.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        //char[] ch=sc.nextLine().toCharArray();
        String[] arr=sc.nextLine().split(" ");

        int[] a=new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            a[i]=Integer.parseInt(arr[i]);
           //System.out.println(a[i]);
        }
        System.out.println("字符数组：");
        System.out.println(String.valueOf(a));
        ArrayList arrayList1=new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (a[i]%2==1) {
                arrayList1.add(a[i]);
            }
        }
        Collections.sort(arrayList1);

        ArrayList arrayList2=new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (a[i]%2==0) {
                arrayList2.add(a[i]);
            }
        }
        Collections.sort(arrayList2);

        for (int i = 0; i < arrayList2.size(); i++) {
            arrayList1.add(arrayList2.get(arrayList2.size()-i-1));
        }

        System.out.println("输出结果：");
        for (int i = 0; i <arrayList1.size() ; i++) {
            System.out.print(arrayList1.get(i)+" ");

        }

      /*
            Collections.reverse(arrayList2);
            System.out.println("结果：");
            for (int i = 0; i <arrayList2.size() ; i++) {
            System.out.print(arrayList2.get(i)+" ");

        }*/
    }
 }

package com.mmall.concurrency.BasticTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

    public static int[] shellsort(int[] arr){

        int j;
        for (int gap =arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length ; i++) {
                int tmp=arr[i];
                for (j = i; j >0&&tmp>arr[j-gap] ; j-=gap) {
                    arr[j]=arr[j-gap];
                }
                arr[j]=tmp;
            }
        }
        return arr;
    }

    public static int[] sort(int[] arr){

        int p;
        for (int i=1;i<arr.length;i++){
            int tmp=arr[i];
            for (p=i;p>0&&tmp>arr[p-1];p--)
                arr[p]=arr[p-1];
            arr[p]=tmp;
        }
        return arr;
    }

    public static void main(String[] args){

        int[] arr={2,4,7,1,4,9,6,10};
        ArrayList arrayList=new ArrayList();
        for (int i = 0; i <arr.length ; i++) {
            arrayList.add(arr[i]);
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.println(arrayList);

        Arrays.sort(arr);
        int[] array=sort(arr);
        int[] arr2=shellsort(arr);
        for (int arry:arr
             ) {
            System.out.print(arry+" ");
        }
        System.out.println("\t\n.....................");
        for (int arr1:array
                ) {
            System.out.print(arr1+" ");
        }


        System.out.println("\t\n.....................");
        for (int arr1:arr2
                ) {
            System.out.print(arr1+" ");
        }
    }
}

package com.Huawei;

import java.util.*;

public class LastSingleCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] arr=in.nextLine().toCharArray();
        HashMap<Character,Integer> hs = new HashMap<>();
        for (char c : arr) {
            if(!hs.containsKey(c)){
                hs.put(c, 1);
            }
            else{
                hs.put(c, hs.get(c)+1);
            }
        }
        String tmp="NULL";
        for (int i = 0; i < arr.length; i++) {
            if(hs.get(arr[i])==1)
                tmp=String.valueOf(arr[i]);
        }

      /*  Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                return 0;
            }
        };*/
        /*for (char key:hs.keySet()) {
            System.out.println(key+"="+hs.get(key));
        }


        for (Integer value:hs.values()) {
            System.out.println(value);
        }

*/
        System.out.println(tmp);

    }


}
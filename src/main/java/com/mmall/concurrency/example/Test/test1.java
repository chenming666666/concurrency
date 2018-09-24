package com.mmall.concurrency.example.Test;
public class test1 {

    public static void main(String[] args){

        int a=10,b=2;
        if(a++>0||b++>0)
            a++;

        System.out.println("a="+a+"\n"+"b="+b+"\n");
    }

}

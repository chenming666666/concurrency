package com.Huawei;

import java.util.Scanner;

public class mulBigInt {
    public String multiplication(String n1, String n2){
        int s1=n1.length();
        int s2=n2.length();

        char[] num1=n1.toCharArray();
        char[] num2=n2.toCharArray();
        char chartemp;
        int inttemp;
        for(int i=0;i<s1/2;i++){

            chartemp=num1[i];
            num1[i]=num1[s1-1-i];
            num1[s1-1-i]=chartemp;
        }
        for(int i=0;i<s2/2;i++){
            chartemp=num2[i];
            num2[i]=num2[s2-1-i];
            num2[s2-1-i]=chartemp;
        }
        int[] result=new int[s1+s2];
        for(int i=0;i<s1;i++){
            for (int j=0;j<s2;j++){
                result[i+j]+=(Integer.valueOf(num1[i])-'0')*(Integer.valueOf(num2[j])-'0');
            }
        }
        for(int i=0;i<s1+s2-1;i++){
            if(result[i]>=10){
                result[i+1]+=result[i]/10;
                result[i]%=10;
            }
        }
        for(int i=0;i<(s1+s2)/2;i++){
            inttemp=result[i];
            result[i]=result[s1+s2-1-i];
            result[s1+s2-1-i]=inttemp;
        }

        StringBuilder resultString=new StringBuilder();
        int k=0;
        while(result[k]==0){
            k++;
        }
        for(int i=k;i<s1+s2;i++){
            resultString.append(result[i]);
        }
        return resultString.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入：");  //加入这行，笔试测试，不通过！
        String num1 = in.next();
        String num2 = in.next();
        System.out.println(new mulBigInt().multiplication(num1,num2));
    }
}
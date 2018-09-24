package com.mmall.concurrency.BasticTest;

public class Solution {

    //这种方法对于"hellow   "这种情况不易处理；
    public static String replaceSpace(StringBuffer str) {

        StringBuffer sb=new StringBuffer();
        String replscestring=str.toString();
        String[] arraystring=replscestring.split(" ");

        //对于字符串分割成一个字符串数组的情况；
        char[] array=replscestring.toCharArray();
        if("".equals(replscestring)){
            sb.append("");
        }else if(" ".equals(replscestring)){
            sb.append("%20");
        }
        else if(arraystring.length==1&&array[array.length-1]==' '){
            sb.append(arraystring[0]+"%20");
        }/*else if(" ".equals(arraystring[0])&&array[array.length-1]==' '){

        }*/
        //其他情况；
        else{
            for (int i=0;i<arraystring.length-1;i++){
                sb.append(arraystring[i]+"%20");
            }
            sb.append(arraystring[arraystring.length-1]);
        }
        return sb.toString();
    }

    //利用库函数replace();
    public static String replaceSpace1(StringBuffer str){
        String arr=str.toString();
        arr=arr.replace(" ","%20");
        return arr;
    }

    public static void main(String[] args){
        String str=" hellow ";

        StringBuffer sb=new StringBuffer(str);
        String string=replaceSpace1(sb);
        System.out.println(string);
    }
}

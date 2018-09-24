package com.SimpleTest;

public class test1 {
    public static void main(String[] args) {

        StringBuffer sbf = new StringBuffer("startle");
        sbf.insert(4, "le");
        //sbf.replace(0,2,"hellow");
        System.out.println(sbf);
        int i=1;
        int j=1;
        if(i>0||j++>0)
            System.out.println("hellow");;
        System.out.println("i="+i+"\n"+"j="+j);



    }
}

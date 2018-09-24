package com.mmall.concurrency.BasticTest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bigintegered {

    public static void main(String[] args){
        String str="1000000000000000000000000";
        BigInteger big=new BigInteger(str);
        BigInteger a=BigInteger.valueOf(99);
        System.out.println(big.remainder(a));

    }
}

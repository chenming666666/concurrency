package com.SimpleTest;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public interface Consumer {
       public void consume() throws InterruptedException;
    }

    abstract class AbstractConsumer implements Consumer, Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    consume();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        public void consume(){

        }
    }


    class AAA implements Consumer{
       public void consume(){

        }

    }


    public static void main(String[] args) {
    }
}
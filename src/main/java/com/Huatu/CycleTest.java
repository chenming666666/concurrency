package com.Huatu;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CycleTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("������ԭ����λ���ǣ�" + cycle(50,3));

    }

    private static int cycle(int n, int m) {
        List<Integer> dataList = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            dataList.add(new Integer(i+1));
        }
        int index = -1;
        while (dataList.size()>1) {
            index = (index + m)%dataList.size();
            dataList.remove(index--);   //ȥ�������֣�index��һ
            //displayList(dataList);    //������ӡ���۲���
            //System.out.println();
        }

        //return dataList.get(0);Ҳ�����滻��һ��
        return ((Integer)dataList.get(0)).intValue();
    }

    //��ӡÿ��ʣ������
   /* private static void displayList(List<Integer> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            int a = dataList.get(i);
            System.out.print(a + " ");
        }
    }*/

}

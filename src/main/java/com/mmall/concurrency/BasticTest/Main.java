package com.mmall.concurrency.BasticTest;

import java.util.Scanner;

public class Main {

    private Node root;

    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.left=null;
        }

    }

    public Main() {
        root=null;
    }
    //后序遍历实现
    public void postOrder(Node localRoot){
        if(localRoot!=null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data+" ");
        }
    }
    public void postOrder(){
        this.postOrder(this.root);
    }
    public void initTree(int[] preOrder,int []inOrder){
        this.root=this.initTree(preOrder, 0,preOrder.length-1,inOrder,0,inOrder.length);
    }

    public Node initTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2) {
        if(start1>end1 || start2>end2){
            return null;
        }
        int rootData=preOrder[start1];
        Node head=new Node(rootData);

        //根节点所在的位置
        int rootIndex=findIndexInArray(inOrder,rootData,start2,end2);
        int offSet=rootIndex-start2-1;//左子树个数
        //构建左子树
        head.left=initTree(preOrder,start1+1,start1+1+offSet,inOrder,start2,start2+offSet);
        //构建右子树
        head.right=initTree(preOrder,start1+2+offSet,end1,inOrder,rootIndex+1,end2);

        return head;
    }

    public int findIndexInArray(int[] inOrder, int rootData, int begin,
                                int end) {
        for (int i = begin; i <= end; i++) {
            if(inOrder[i]==rootData){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Main bt=new Main();
        System.out.println("样例输入：");
        Scanner sc=new Scanner(System.in);
        String[] arr1=sc.nextLine().split(",");
        String[] arr2=sc.nextLine().split(",");
        int[] preOrder=new int[arr1.length];
        int[] inOrder=new int[arr2.length];
        for (int i=0;i<arr1.length;i++) {
            preOrder[i]=Integer.parseInt(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++) {
            inOrder[i]=Integer.parseInt(arr2[i]);
        }
        bt.initTree(preOrder, inOrder);
        System.out.println("二叉树的后序遍历：");
        bt.postOrder();
    }
}

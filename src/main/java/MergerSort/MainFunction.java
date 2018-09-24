package MergerSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainFunction {
    static int N;
    static int Totalweight;
    static int Differ;
    static int CountFlag=0;							//统计程序与行过程中装入箱子中物品的个数
    static int StartNumber=0;						    //每次使用动态规划的第一个订单在订单序列a的序号
    static List<Integer>[] Box=new ArrayList[1000];
    static A[] a=new A[1000];							//创建类数组,给定订单数

    public static void main(String[] args) {

        Initialization();						 	    //给订单数，炉次的产量和同一炉次内交期之差赋值

        for (int i = 0; i < N; i++){				    //类数组使用之前必须初始化
            a[i]=new A();
        }
        IniInputData(a);							     //为输入数据赋值

        //构造空箱，用于装载物品
        for (int i = 0; i < N; i++) {
            Box[i]=new ArrayList<Integer>();
        }

        MergerSort.MergeSortRecursion(a, 0, N - 1);	// 递归实现归并排序（按订单交期从小到大排序）

        //输出排序后的结果
		/*System.out.println("\t\n"+"输出排序后的结果:\t\n");
		for (int i = 0; i < N; i++){
			System.out.print(a[i].getTime()+" ");
			if (i != 0 &&i%20==0) {
				System.out.println();
			}
		}

		System.out.println("\t\n");
		for (int i = 0; i < N; i++){
			System.out.print(a[i].getWeight()+" ");
			if (i != 0 &&i%20==0) {
				System.out.println();
			}
		}

		System.out.println("\t\n");
		for (int i = 0; i < N; i++){
			System.out.print(a[i].getFlag()+" ");
			if (i != 0 &&i%20==0) {
				System.out.println();
			}
		}*/

        int PackingSequence=0;

        while (StartNumber<N){

            DynamicProgramAlgorithm.SimpleDPA(a,PackingSequence);

            PackingSequence++;						//每次动态规划分配一个空箱，用于装入物品

            for (int i = 0; i < N; i++) {	        //获取每次动态规划的第一个物品在订单集合a中的序号
                if (a[i].getFlag()==0) {
                    StartNumber=i;
                    break;
                }
                if(i==N-1){
                    StartNumber=N;
                }
            }

        }

        //输出求解结果
        int COUNT=0;
        for (int i = 0; i < Box.length; i++) {
            if(!Box[i].isEmpty()){
                //System.out.println(Box[i]);
                COUNT++;
            }
        }
        System.out.println("小订单归并的总箱子数：");
        System.out.println(COUNT);

        for (int i = 0; i < COUNT; i++) {
            System.out.print("第"+(i+1)+"个箱子的物品集合:");

            int[] d = new int[Box[i].size()];
            int[] weights=new int[Box[i].size()];

            for(int j = 0;j<Box[i].size();j++){
                d[j] = Box[i].get(j);
                weights[j]=a[d[j]].getWeight();
            }

            System.out.println(Arrays.toString(weights));
        }
    }

    //为定单数据赋值
    private static void IniInputData(A[] a) {
        //创建随机数对象
        Random r=new Random();
        for (int i = 0; i < N; i++){
            a[i].setWeight( r.nextInt(Totalweight-2)+1);
        }
        //获取订单交期信息
        for (int i = 0; i < N; i++){
            a[i].setTime( r.nextInt(29)+1);         //做到系统里面，每个月的天数不同，需要通用性。
        }
        //获取订单号
        for (int i = 0; i < N; i++){
            a[i].setOrder_no( i+1);
        }

		/*System.out.println("\t\n");
		for (int i = 0; i < N; i++){
			System.out.print(a[i].getWeight()+" ");
			if (i != 0 &&i%20==0) {
				System.out.println();
			}
		}
		System.out.println("\t\n");
		for (int i = 0; i < N; i++){
			System.out.print(a[i].getTime()+" ");
			if (i != 0 &&i%20==0) {
				System.out.println();
			}
		}
		System.out.println("\t\n");
		for (int i = 0; i < N; i++){
			System.out.print(a[i].getOrder_no()+" ");
			if (i != 0 &&i%20==0) {
				System.out.println();
			}
		}*/
    }
    //给订单数，炉次的产量和同一炉次内交期之差赋值
    private static void Initialization() {

        Scanner sc=new Scanner(System.in);
        System.out.println("请分别输入订单数，炉次的产量和同一炉次内交期之差最大值:");
        N=sc.nextInt();
        Totalweight=sc.nextInt();
        Differ=sc.nextInt();
		/*String line=sc.nextLine();
		String[] line1=line.split(" ");
		int[] arr=new int[3];
		int k=0;
		for (String s : line1) {
			arr[k]=Integer.parseInt(s);
			k++;
		}
		//给订单数，炉次的产量和同一炉次内交期之差赋值
		N=arr[0];
		Totalweight=arr[1];
		Differ=arr[2];		*/
    }

}

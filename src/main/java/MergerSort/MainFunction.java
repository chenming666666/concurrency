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
    static int CountFlag=0;							//ͳ�Ƴ������й�����װ����������Ʒ�ĸ���
    static int StartNumber=0;						    //ÿ��ʹ�ö�̬�滮�ĵ�һ�������ڶ�������a�����
    static List<Integer>[] Box=new ArrayList[1000];
    static A[] a=new A[1000];							//����������,����������

    public static void main(String[] args) {

        Initialization();						 	    //����������¯�εĲ�����ͬһ¯���ڽ���֮�ֵ

        for (int i = 0; i < N; i++){				    //������ʹ��֮ǰ�����ʼ��
            a[i]=new A();
        }
        IniInputData(a);							     //Ϊ�������ݸ�ֵ

        //������䣬����װ����Ʒ
        for (int i = 0; i < N; i++) {
            Box[i]=new ArrayList<Integer>();
        }

        MergerSort.MergeSortRecursion(a, 0, N - 1);	// �ݹ�ʵ�ֹ鲢���򣨰��������ڴ�С��������

        //��������Ľ��
		/*System.out.println("\t\n"+"��������Ľ��:\t\n");
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

            PackingSequence++;						//ÿ�ζ�̬�滮����һ�����䣬����װ����Ʒ

            for (int i = 0; i < N; i++) {	        //��ȡÿ�ζ�̬�滮�ĵ�һ����Ʒ�ڶ�������a�е����
                if (a[i].getFlag()==0) {
                    StartNumber=i;
                    break;
                }
                if(i==N-1){
                    StartNumber=N;
                }
            }

        }

        //��������
        int COUNT=0;
        for (int i = 0; i < Box.length; i++) {
            if(!Box[i].isEmpty()){
                //System.out.println(Box[i]);
                COUNT++;
            }
        }
        System.out.println("С�����鲢������������");
        System.out.println(COUNT);

        for (int i = 0; i < COUNT; i++) {
            System.out.print("��"+(i+1)+"�����ӵ���Ʒ����:");

            int[] d = new int[Box[i].size()];
            int[] weights=new int[Box[i].size()];

            for(int j = 0;j<Box[i].size();j++){
                d[j] = Box[i].get(j);
                weights[j]=a[d[j]].getWeight();
            }

            System.out.println(Arrays.toString(weights));
        }
    }

    //Ϊ�������ݸ�ֵ
    private static void IniInputData(A[] a) {
        //�������������
        Random r=new Random();
        for (int i = 0; i < N; i++){
            a[i].setWeight( r.nextInt(Totalweight-2)+1);
        }
        //��ȡ����������Ϣ
        for (int i = 0; i < N; i++){
            a[i].setTime( r.nextInt(29)+1);         //����ϵͳ���棬ÿ���µ�������ͬ����Ҫͨ���ԡ�
        }
        //��ȡ������
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
    //����������¯�εĲ�����ͬһ¯���ڽ���֮�ֵ
    private static void Initialization() {

        Scanner sc=new Scanner(System.in);
        System.out.println("��ֱ����붩������¯�εĲ�����ͬһ¯���ڽ���֮�����ֵ:");
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
		//����������¯�εĲ�����ͬһ¯���ڽ���֮�ֵ
		N=arr[0];
		Totalweight=arr[1];
		Differ=arr[2];		*/
    }

}

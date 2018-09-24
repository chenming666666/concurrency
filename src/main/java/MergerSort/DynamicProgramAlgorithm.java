package MergerSort;

import java.awt.font.NumericShaper.Range;
import java.util.ArrayList;
import java.util.List;

public abstract class DynamicProgramAlgorithm {

    //动态规划
    @SuppressWarnings("unchecked")
    public static void SimpleDPA(A[] a,int packingsequence){

        int[] Weight;
        int[] ContrastArray;    			 //让weight数组的序号对应于a数组上的序号
        int NumberOfItems=0;				 //物品数量

        //计算装箱的物品数量
        for(int i=MainFunction.StartNumber;a[i].getTime()-a[MainFunction.StartNumber].getTime() <= MainFunction.Differ;i++){
            if (a[i].getFlag()==0) {
                NumberOfItems++;
            }
            if (i==(a.length-1)) {			 //防止数组越界
                break;
            }
        }

        //测试输出情况
        //System.out.println("startNumber="+MainFunction.StartNumber+"\t\n");
        //System.out.println("输出NumberOfItems="+NumberOfItems+"\t\n");

        //物品重量和所选订单在订单集合数组中的序号和weight数组的序号对应关系
        Weight=new int[NumberOfItems+1];
        ContrastArray=new int[NumberOfItems+1];  //所选订单在订单集合数组中的序号和weight数组的序号对应关系

        int s=1;
        for(int i=MainFunction.StartNumber;a[i].getTime()-a[MainFunction.StartNumber].getTime() <= MainFunction.Differ;i++){
            if (a[i].getFlag()==0) {
                Weight[s]=a[i].getWeight();
                ContrastArray[s]=i;
                s++;
            }
            if (i==(a.length-1)){
                break;
            }
        }

        //测试输出情况
		/*System.out.println("输出数组Weight值：");
		for (int i = 1; i < Weight.length; i++) {
			System.out.print(Weight[i]+" ");
		}

		System.out.println("输出数组ContrastArray值：");
		for (int i = 1; i < ContrastArray.length; i++) {
			System.out.print(ContrastArray[i]+" ");
		}*/

        //定义价值评价数组V
        int[][] V=new int[NumberOfItems+1][MainFunction.Totalweight+1];
        int[] ItemsOfFlag=new int[NumberOfItems+1];  //全局变量，标记被选择中的订单.

        for(int i=1;i<=NumberOfItems;i++){
            for(int j=1;j<=MainFunction.Totalweight;j++){
                if(j<Weight[i]){								   //包装不进
                    V[i][j]=V[i-1][j];
                }else{											   //能装
                    if(V[i-1][j] >= V[i-1][j-Weight[i]]+Weight[i]){ //不装价值大
                        V[i][j]=V[i-1][j];
                    }else{										   //前i-1个物品的最优解与第i个物品的价值之和更大
                        V[i][j]=V[i-1][j-Weight[i]]+Weight[i];
                    }
                }
            }
        }

        //寻找解的最优组合
        FindWhat(NumberOfItems, MainFunction.Totalweight, ItemsOfFlag,V ,Weight);

        //将选择的最优组合装入空箱中Box中
        for (int j= 1; j <= NumberOfItems; j++) {
            if (ItemsOfFlag[j]==1) {
                MainFunction.Box[packingsequence].add(ContrastArray[j]);
                MainFunction.a[ContrastArray[j]].setFlag(1);
            }
        }

    }

    //寻找解的最优组合
    public static void FindWhat(int i,int j,int[] item,int[][] v,int[] weight){
        if(i > 0){
            if(v[i][j]==v[i-1][j]){							    	//相等说明没装
                item[i]=0;											//全局变量，标记未被选中
                FindWhat(i-1,j , item ,v ,weight);
            }
            else if( j-weight[i]>=0 && v[i][j]==v[i-1][j-weight[i]]+weight[i] ){
                item[i]=1;											//标记已被选中
                FindWhat(i-1,j-weight[i], item, v,weight);	   		//回到装包之前的位置
            }
        }
    }

}
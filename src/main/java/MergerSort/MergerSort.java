package MergerSort;

public class MergerSort {

    // 递归实现的归并排序(自顶向下)
    public static void MergeSortRecursion(A b[], int left, int right) {
        if (left == right) 					// 当待排序的序列长度为1时，递归开始回溯，进行merge操作
            return;
        int mid = (left + right) / 2;
        MergeSortRecursion(b, left, mid);
        MergeSortRecursion(b, mid + 1, right);
        Merge(b, left, mid, right);
    }

    // 合并两个已排好序的数组A[left...mid]和A[mid+1...right]
    public static void Merge(A b[], int left, int mid, int right) {
        int len = right - left + 1;
        A[] temp = new A[len]; 				// 辅助空间O(n)
        int index = 0;
        int i = left; 						// 前一数组的起始元素
        int j = mid + 1; 					// 后一数组的起始元素
        while (i <= mid && j <= right) {
            // 带等号保证归并排序的稳定性
            temp[index++] = b[i].getTime()<= b[j].getTime() ? b[i++] : b[j++];
        }
        while (i <= mid) {
            temp[index++] = b[i++];
        }
        while (j <= right) {
            temp[index++] = b[j++];
        }
        for (int k = 0; k < len; k++) {
            b[left++] = temp[k];
        }
    }

}

// 存储数据的类
class A {
    private int Weight; 		// 订单重量
    private int Time; 			// 订单交期
    private int order_no; 	// 订单号
    private int Flag;			//标记是否装入箱中

    public int getWeight() {
        return Weight;
    }


    public void setWeight(int weight) {
        Weight = weight;
    }


    public int getTime() {
        return Time;
    }


    public void setTime(int time) {
        Time = time;
    }


    public int getOrder_no() {
        return order_no;
    }


    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }


    @Override
    public String toString() {
        return "A [Weight=" + Weight + ", Time=" + Time + ", order_no="
                + order_no + ", Flag="+ Flag +"]";
    }


    public int getFlag() {
        return Flag;
    }


    public void setFlag(int flag) {
        Flag = flag;
    }

}
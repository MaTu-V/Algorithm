import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(fibnacciSearch(arr,1234));
    }

    /**
     * 斐波那契 数列 生成
     * 1 1 2 3 5 8 13 21
     * @return
     */
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i=2;i<maxSize;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     * 斐波那契查找  非递归方式
     * @param arr 数组
     * @param findVal 查找数
     * @return
     */
    public static int fibnacciSearch(int[] arr,int findVal){
        int low = 0;
        int high = arr.length -1;
        int k = 0; // 分割数值的下标
        int mid = 0; // 存放mid 值
        int f[] = fib(); // 获取到斐波那契数列
        // 获取到斐波那契分割数值的下标
        while (high > f[k] -1){
            k++; // 下标一直增加
        }
        // 找到k 下标
        // 补齐 长度 使用 0 填充
        int[] temp = Arrays.copyOf(arr,f[k]);
        for (int i = high + 1;i<temp.length;i++){
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + f[k -1] + 1;
            if(findVal < temp[mid]){
                high =mid -1;
                k--;
            }else if (findVal > temp[mid]){
                low = mid + 1;
                k-=2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

}

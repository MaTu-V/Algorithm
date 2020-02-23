import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序 1s以内
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
//        int arr[] = {6,1,2,5,9,3,4,7,10,8};
        int temp[] = new int[arr.length];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        System.out.println(simpleDateFormat.format(startDate));

        mergeSort(arr, 0, arr.length - 1, temp);
        Date endDate = new Date();
        System.out.println(simpleDateFormat.format(endDate));

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并拆分和解
     * @param arr 属猪
     * @param left 左边
     * @param right 右边
     * @param temp 临时数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right){
            int mid = (left + right ) /2; // 中间位置
            mergeSort(arr,left,mid,temp); // 左边分割
            mergeSort(arr,mid+1,right,temp); // 右边分割
            merge(arr,left,mid,right,temp); // 合并
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 左侧数组
        int j = mid+1; // 右侧数组
        int t = 0; // 临时数组 t 的 下标指针
        // 两侧
        while (i<= mid && j<=right){
            if (arr[i] > arr[j]){
                // 左侧大于右侧
                temp[t] = arr[j];
                j++;
                t++;
            }else {
                temp[t] = arr[i];
                i++;
                t++;
            }
        }
        //剩余
        while (i<=mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        // 临时数组赋值到原本数组
        t = 0;
        int tempLeft = left;// 保存起始位置
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


}

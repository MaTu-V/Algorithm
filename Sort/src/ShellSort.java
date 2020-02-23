import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        System.out.println(simpleDateFormat.format(startDate));

        shellI(arr);
        Date endDate = new Date();
        System.out.println(simpleDateFormat.format(endDate));

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换法：
     * 希尔排序  将大数放在后面小数尽量前移  避免插入排序的多次后移
     * @param arr
     * @return
     */
    public static int[] shell(int[] arr){
//        gap = gap/2 => gap /=2

        // 步数
        for (int gap = arr.length/2; gap>0;gap/=2){
            // 找最大 i位置
            for (int i=gap;i<arr.length;i++){
                // 找最小j 位置
                for (int j=i-gap;j>=0;j--){
                    // 大数放在后面 小数放前面
                    if (arr[j] > arr[i]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 移位法：
     * 希尔排序  将大数放在后面小数尽量前移  避免插入排序的多次后移
     * @param arr
     * @return
     */
    public static int[] shellI(int[] arr){
        // 步数
        for (int gap = arr.length/2; gap>0;gap/=2){
            // 找最大 i位置
            for (int i=gap;i<arr.length;i++){
               int val = arr[i];
               int idx =i;
               if (arr[idx] < arr[idx-gap]){
                   while ( idx -gap>=0 && val < arr[idx-gap]){
                       arr[idx] = arr[idx-gap];
                       idx -=gap;
                   }
                   arr[idx] = val;
               }
            }
        }
        return arr;
    }
}

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序 2s
 */
public class ChooseSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        System.out.println(simpleDateFormat.format(startDate));

        choose(arr);
        Date endDate = new Date();
        System.out.println(simpleDateFormat.format(endDate));

        System.out.println(Arrays.toString(arr));
    }
    public static int[] choose(int[] arr){
        for (int i= 0;i<arr.length-1;i++){
            int min = arr[i];
            int minIdx = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j] < min){
                    min = arr[j];
                    minIdx = j;
                }

            }

            if (minIdx != i){
                // 放大数
                arr[minIdx] = arr[i];
                // 放小数
                arr[i] = min;
            }
        }
        return arr;
    }
}

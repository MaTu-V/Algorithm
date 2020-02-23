import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序 12s
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
       System.out.println(simpleDateFormat.format(startDate));

        bubble(arr);
        Date endDate = new Date();
        System.out.println(simpleDateFormat.format(endDate));

        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubble(int[] arr){
       for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i] >arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] =temp;
                }
            }
        }
        return arr;
    }
}

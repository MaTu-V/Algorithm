import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序 1s 当最小的数在后面 将会导致多次后移赋值
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        System.out.println(simpleDateFormat.format(startDate));
        insert(arr);
        Date endDate = new Date();
        System.out.println(simpleDateFormat.format(endDate));

        System.out.println(Arrays.toString(arr));
    }

    public static int[] insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; // 获取带插入数据
            int insertIdx = i; // 当前数下标
            // 从右侧开始找位置
            while (insertIdx > 0 && insertVal < arr[insertIdx - 1]) {
                // 若满足条件 则说明 该数应当放置在前一个位置
                arr[insertIdx] = arr[insertIdx - 1];
                insertIdx--;
            }

            arr[insertIdx] = insertVal;
        }
        return arr;
    }
}

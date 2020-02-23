import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 * 个位 十位 百位 千位 .....
 */
public class BaseSort {
    public static void main(String[] args) {
//        int arr[] = {53, 3, 542, 748, 14, 214};
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        System.out.println(simpleDateFormat.format(startDate));
        base(arr);
        Date endDate = new Date();
        System.out.println(simpleDateFormat.format(endDate));

        System.out.println(Arrays.toString(arr));
    }

    public static void base(int[] arr) {
        // 求出最大数的 长度
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        // 桶定义
        // 空间换时间
        int[][] bucket = new int[10][arr.length];


        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 定义一个一维数组代表当前桶中个数
            int[] bucketElementCounts = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int element = arr[j] / n % 10; //首次 按个位 其次 十位 百位千位 ....
                // 放到到对应桶中
                bucket[element][bucketElementCounts[element]] = arr[j];
                // 该桶中数量 + 1
                bucketElementCounts[element]++;
            }
            // 从桶中取出数据放置会原数组
            int idx = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 说明该桶中有数据
                if (bucketElementCounts[k] != 0) {
                    // 遍历该桶数据
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 放会原数组
                        arr[idx++] = bucket[k][l];
//                        idx++; // 增加
                    }
                }
            }
        }
    }
}

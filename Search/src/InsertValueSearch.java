/**
 * 插值查找
 * 要求 数组有序
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i=0;i<arr.length;i++){
            arr[i] = i + 1;
        }
        int idx =insertValueSearch(arr,0,arr.length-1,22);
        System.out.println(idx);
    }

    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        // 严格限制 查找数 在范围内
        if (left > right || findVal < arr[0] || findVal> arr[arr.length-1]){
            return  -1; // 返回一个不存在的下标
        }
        // 插值查找表达式
        int mid = left + (right-left)*(findVal-arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            // 右侧查找
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid+ 1; // 返回所在元素下标位置  + 1
        }
    }
}

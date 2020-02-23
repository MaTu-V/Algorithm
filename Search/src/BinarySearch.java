/**
 * 二分查找
 * 要求 数组有序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1234};
        int idx =binarySearch(arr,0,arr.length-1,100);
        System.out.println(idx);
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left > right){
            return  -1; // 返回一个不存在的下标
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            // 右侧查找
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid+ 1; // 返回所在元素下标位置  + 1
        }
    }
}

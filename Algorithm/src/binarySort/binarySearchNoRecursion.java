package binarySort;

public class binarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,7,8,24,33,89,100};
        int idx = binarySearch(arr,1001);
        System.out.println("index=>" + idx);
    }

    /**
     * 二分非递归搜索
     * @param arr
     * @param target
     * @return 返回下标
     */
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                // 左侧查找
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }
}

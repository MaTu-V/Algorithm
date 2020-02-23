public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,67};
        int key = 2;
        System.out.print(getD(a,key));
    }
    public static int getD(int[] a,int key){
        int max,min,mid;
        min = 0;
        max = a.length -1;
        mid = (max + min) /2;
        while (key != a[mid]){
            if (key > a[mid]){
                min = mid + 1;
            }else if (key < a[mid]){
                max = mid -1;
            }
            if (min > max){
                return  -1;
            }
            mid =(max + min) /2;
        }
        return mid;
    }
}

package kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1= "abbbbac";
        String target = "bacc";
        System.out.println(violenceMatch(str1,target));
    }

    public static int violenceMatch(String str1,String target){
        char[] s1 = str1.toCharArray();
        char[] s2 = target.toCharArray();
        int s1len = s1.length;
        int s2len = s2.length;
        int i=0,j=0;
        while (i<s1len && j <s2len){
          if (s1[i] == s2[j]) {
            i++;
            j++;
          }else { // 没有匹配成功
              i = i - j  + 1; // 回退 j -1 个指针
              j = 0;
          }
        }

        if ( j == s2len){
            return i-j;
        }else {
            return  -1;
        }
    }
}

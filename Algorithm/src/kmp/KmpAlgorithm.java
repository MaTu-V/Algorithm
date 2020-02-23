package kmp;

import java.util.Arrays;

public class KmpAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String target = "ABCDABD";
        int[] next = kmpNext(target);
        int idx = kmpSearch(str1,target,next);
        System.out.println(idx);
    }
    /**
     * 求Kmp字符串 部分匹配表
     */
    public static int[] kmpNext(String str){
        // 定义返回数组 长度为字符串长度
        int[] next = new int[str.length()];
        // 首位 可匹配为 0
        next[0] = 0;
        // 求法 ： 求给定字符串 前缀 和后缀中 出现的相同字符串的最大长度
        for (int i = 1,j=0;i<str.length();i++){
            // 前缀 A AB ABC ABCD ABCDA ABCDAB
            // 后缀 B BC BCD BCDA BCDAB BCDABD
            // j 代表前缀 i代表后缀
            // 两者不相同
            while (j> 0 && str.charAt(i)!=str.charAt(j)){
                j = next[j -1];
            }
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }

            next[i] = j;
        }
        return next;
    }

    /**
     * 求最早出现位置
     */
    public static int kmpSearch(String str,String target,int[] next){
        for (int i =0,j=0;i<str.length();i++){
            while (j> 0 && str.charAt(i)!=target.charAt(j)){
                j = next[j -1];
            }
            if (str.charAt(i) == target.charAt(j)){
                j++;
            }
            if (j == target.length()){
                return  i - j + 1; // 返回
            }
        }
        return -1;
    }
}

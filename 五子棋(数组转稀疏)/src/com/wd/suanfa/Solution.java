package com.wd.suanfa;

import java.io.File;

/**
 * 五子棋
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	1	0	0	0	0	0	0	0	0
 * 0	0	0	0	2	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 */
public class Solution {

    /**
     * 原始数组输出打印
     */
    public static void printfCheckerboard(int[][] checkerboard) {
        for (int[] rows : checkerboard) {
            for (int v : rows) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 棋盘转为稀疏矩阵存储
     *
     * @param checkerboard
     */
    public static int[][] changeSparseArray(int[][] checkerboard) {
        int count = 0, start = 0; //记录棋盘中棋子数量 start 存储变量idx
        for (int[] rows : checkerboard) {
            for (int v : rows) {
                if (v != 0) {
                    count++;
                }
            }
        }
        int sparseArray[][] = new int[count + 1][3]; // 定义 稀疏矩阵 行数为当前行数 + 1
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;
        for (int i = 0; i < sparseArray[0][0]; i++) {
            for (int j = 0; j < sparseArray[0][1]; j++) {
                // 获取已落棋子的位置 存放到稀疏矩阵中
                if (checkerboard[i][j] != 0) {
                    start++;
                    sparseArray[start][0] = i;
                    sparseArray[start][1] = j;
                    sparseArray[start][2] = checkerboard[i][j];
                }
            }
        }

//        for (int[] rows : sparseArray) {
//            for (int v : rows) {
//                System.out.print(v + "\t");
//            }
//            System.out.println();
//        }
        return sparseArray;
    }


    /**
     * 稀疏矩阵转换为棋盘
     * @param sparseArray
     * @return
     */
    public static int[][] changeCheckerboard(int[][] sparseArray) {
        int checkerboard[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int row = 1; row < sparseArray.length; row++) {
            // 数值存入
            checkerboard[sparseArray[row][0]][sparseArray[row][1]] = sparseArray[row][2];
        }
//        printfCheckerboard(checkerboard);
        return checkerboard;
    }

    public static void main(String[] args) {
        // 初始化棋盘 0 为无子 1为黑子 2为白子
        int checkerboard[][] = new int[11][11];
        checkerboard[1][2] = 1;
        checkerboard[2][4] = 2;
//        printfCheckerboard(checkerboard);
        int sparseArray[][] = changeSparseArray(checkerboard); // 获取转换后稀疏矩阵
        int returnCheck[][] = changeCheckerboard(sparseArray);// 稀疏矩阵转换为棋盘

    }
}

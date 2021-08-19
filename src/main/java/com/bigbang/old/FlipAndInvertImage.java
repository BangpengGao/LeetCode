package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/7/25
 */

public class FlipAndInvertImage {
    /**
     * 832. Flipping an Image
     * Easy
     * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
     * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
     * Example 1:
     * Input: [[1,1,0],[1,0,1],[0,0,0]]
     * Output: [[1,0,0],[0,1,0],[1,1,1]]
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     * Example 2:
     * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
     * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * Notes:
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     */
    public int[][] solution(int[][] A) {
        int aLen = A.length;
        if (aLen==0)
            return new int[0][0];
        int aWei = A[0].length;
        int[][] res = new int[aLen][aWei];
        for (int l=0; l<aLen; l++){
            for (int w=0; w<aWei; w++){
                if (A[l][w] == 1)
                    res[l][aWei-1-w] = 0;
                else
                    res[l][aWei-1-w] = 1;
            }
        }
        return res;
    }
}

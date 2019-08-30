package com.lkl;
/*
图的多源最短路径问题
给定一个带权图，求出各个顶点之间的最短距离

解决算法：Floyd算法（弗洛伊德算法）
 */

public class graph_shortest_source {
    final static int INF = Integer.MAX_VALUE;
    public static void floyd(int[][] matrix){
        //循环更新 矩阵的值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    //如果起点到中间点，中间点到终点 如果有一个是INF 就不用再使用中间结点计算路径了
                    if (matrix[j][i] == INF || matrix[i][k] == INF)
                        continue;
                    // 判断原本的距离和使用中间结点距离的最小值  更新到 距离矩阵中
                    matrix[j][k] = Math.min(matrix[j][k],matrix[j][i]+matrix[i][k]);
                }
            }
        }
    }
    //遍历matrix
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%3d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix= {
                {0,5,2,INF,INF,INF,INF},
                {5,0,INF,1,6,INF,INF},
                {2,INF,0,6,INF,8,INF},
                {INF,1,6,0,1,2,INF},
                {INF,6,INF,1,0,INF,7},
                {INF,INF,8,2,INF,0,3},
                {INF,INF,INF,INF,7,3,0}
        };
        floyd(matrix);
        printMatrix(matrix);
    }
}

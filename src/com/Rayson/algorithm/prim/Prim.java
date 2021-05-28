package com.Rayson.algorithm.prim;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};
        int verxs = data.length;
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, data, weight);
       // minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);
    }
}

//创建最小生成树
class MinTree {
    public void createGraph(MGraph mGraph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            mGraph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph mGraph, int v){
        int[] visied = new int[mGraph.verxs];//已访问的
        for (int i = 0; i < visied.length; i++) {
            visied[i] = 0;
        }
        visied[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < mGraph.verxs; k++) {

            for (int i = 0; i < mGraph.verxs; i++) {
                for (int j = 0; j < mGraph.verxs; j++) {
                    if (visied[i] == 1 && visied[j] == 0 && mGraph.weight[i][j] < minWeight){
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边" + mGraph.data[h1] + mGraph.data[h2] + "之间长" + mGraph.weight[h1][h2]);
            visied[h2] = 1;
            minWeight = 10000;
        }
    }
}

class MGraph {
    int verxs;//节点数目
    char[] data;//节点数据
    int[][] weight;//边数据

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

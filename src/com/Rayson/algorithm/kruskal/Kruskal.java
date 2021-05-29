package com.Rayson.algorithm.kruskal;

import java.util.Arrays;

public class Kruskal {
    private int edgeNum;//边个数
    private char[] vertex;//顶点数组
    private int[][] matrix;//临接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        Kruskal kruskal = new Kruskal(vertexs, matrix);
        //kruskal.print();
        EData[] edges = kruskal.getEdges();

//        System.out.println(Arrays.toString(edges));
//        kruskal.sort(edges);
//        System.out.println(Arrays.toString(edges));
        kruskal.kru();
    }

    public Kruskal(char[] vertex, int[][] matrix) {
        int len = vertex.length;
        //顶点初始化
        this.vertex = new char[len];
        for (int i = 0; i < len; i++) {
            this.vertex[i] = vertex[i];
        }
        //边初始化
        this.matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }


    }

    public void kru() {
        int index = 0;
        int[] ends = new int[edgeNum];
        //创建结果数组
        EData[] res = new EData[edgeNum];
        EData[] edges = getEdges();

        sort(edges);
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                res[index++] = new EData(edges[i].start, edges[i].end, edges[i].weight);
            }
        }
        System.out.println(Arrays.toString(res));
    }


    public void print() {
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%15d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void sort(EData[] eData) {
        for (int i = 0; i < eData.length - 1; i++) {
            for (int j = 0; j < eData.length - i - 1; j++) {
                if (eData[j].weight > eData[j + 1].weight) {
                    EData temp = eData[j];
                    eData[j] = eData[j + 1];
                    eData[j + 1] = temp;

                }
            }
        }
    }

    //返回节点对应下标
    public int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (ch == vertex[i]) {
                return i;
            }

        }
        return -1;
    }

    //获取边，放入EData数组中
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //获取终点下标
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

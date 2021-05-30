package com.Rayson.algorithm.dijkstra;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65355;
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
    }
}

class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix;//临接矩阵
    private VisitedVertex vv;//已访问集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void djs(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);
        for (int i = 0; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }

    }

    //更新index下标顶点到周围顶点距离和周围顶点的前驱节点
    public void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = vv.getDis(index) + matrix[index][i];
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updatePre(i, index);
                vv.updateDis(i, len);
            }
        }
    }
}

class VisitedVertex {
    //已访问顶点
    public int[] already_arr;
    //前节点下标
    public int[] pre_arr;
    //各个顶点到出发点距离
    public int[] dis;

    //length为顶点个数，index为出发点下标
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_arr = new int[length];
        this.dis = new int[length];
        this.already_arr[index] = 1;
        //初始化dis
        Arrays.fill(dis, 65355);
        dis[index] = 0;
    }

    //判断index是否被访问
    public boolean in(int index) {
        if (already_arr[index] == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    //更新dis数组
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    //更新pre数组
    public void updatePre(int index, int pre) {
        pre_arr[index] = pre;
    }

    //返回出发点到index的距离
    public int getDis(int index) {
        return dis[index];
    }

    //选择并返回新的访问顶点
    public int updateArr(){
        int min = 65355;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }
}

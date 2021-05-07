package com.Rayson.dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//存储质点集合
    private int[][] edges;//存储图对应的矩阵
    private int numOfEdges;//边数量
    //定义数组，记录是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] val = {"A","B","C","D","E"};
        Graph graph = new Graph(5);
        for (int i = 0; i < val.length; i++) {
            graph.insertVertex(val[i]);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //graph.getGraph();

       graph.dfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回节点数目
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回边数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回节点下标对应的数据
    public String getVertexByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1，v2权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图对应矩阵
    public void getGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //获取第一个临节点下标
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个节点获取下一个节点
    public int getNextNeighbor(int v1, int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历
    public void dfs(boolean[] isVisited, int i){
        System.out.println(getVertexByIndex(i) + "->");
        //设置已访问
        isVisited[i] = true;
        //查找第一个临节点
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w已被访问
            w=getNextNeighbor(i,w);
        }
    }

    //重载
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
}

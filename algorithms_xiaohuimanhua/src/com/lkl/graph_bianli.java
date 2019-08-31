package com.lkl;

import java.util.LinkedList;

/*
图的两种遍历方法：深度优先遍历（DFS）和广度优先遍历（BFS）
 */
public class graph_bianli {
    //图的顶点类
    private static class Vertex{
        int data;

        public Vertex(int data) {
            this.data = data;
        }
    }
    /*
    图
     */
    private static class Graph{
        private int size;    //图的顶点个数
        private Vertex[] vertexes;  //图的顶点数组
        private LinkedList<Integer> adj[];  //用邻接表存储图

        public Graph(int size) {
            this.size = size;
            //初始顶点和邻接矩阵
            vertexes = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertexes[i] = new Vertex(i);
                adj[i] = new LinkedList();
            }
        }
    }

    //深度优先遍历
    public static void dfs(Graph graph,int start,boolean[] visited){
        System.out.println(graph.vertexes[start].data);
        visited[start] = true;
        for (int index:graph.adj[start]){
            if (!visited[index]){
                dfs(graph,index,visited);
            }
        }
    }
    //广度优先遍历
    public static void bfs(Graph graph,int start,boolean[] visited,LinkedList<Integer> queue){
        queue.offer(start);
        //队列不为空，就一直出队列的头元素
        while (!queue.isEmpty()){
            Integer front = queue.poll();
            //判断当前节点是不是已经访问过
            if (visited[front]){
                continue;
            }
            //输出节点的数据
            System.out.println(graph.vertexes[front].data);
            //把当前节点标记为访问过的状态
            visited[front] = true;
            //把当前front相邻节点加入到queue中
            for (Integer integer : graph.adj[front]) {
                queue.offer(integer);
            }

        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);
        graph.adj[0].add(4);

        graph.adj[1].add(0);
        graph.adj[1].add(4);
        graph.adj[1].add(7);
        graph.adj[1].add(9);

        graph.adj[2].add(0);

        graph.adj[3].add(0);
        graph.adj[3].add(4);
        graph.adj[3].add(5);
        graph.adj[3].add(6);

        graph.adj[4].add(0);
        graph.adj[4].add(1);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);

        graph.adj[6].add(3);

        graph.adj[7].add(1);
        graph.adj[7].add(8);
        graph.adj[7].add(10);

        graph.adj[8].add(7);

        graph.adj[9].add(1);

        graph.adj[10].add(7);
//        dfs(graph,0,new boolean[graph.size]);
        bfs(graph,0,new boolean[graph.size],new LinkedList());
    }
}

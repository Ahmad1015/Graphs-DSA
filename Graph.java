// Adjacency List 

import java.util.*;
public class Graph{
    public static ArrayList<Edge>[] createGraph(ArrayList<Edge>[] graph) {
        graph = new ArrayList[5];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,3));   
        graph[0].add(new Edge(0, 2));  
        graph[1].add(new Edge(1, 0));  
        graph[2].add(new Edge(2, 1));         
        graph[3].add(new Edge(3, 4));   
        graph[4].add(new Edge(4, 0));
        return graph;
        
    //   1 <--- 0 ---> 3
    //   ^      ^      /
    //   |       \    v
    //   2           4


    }
    public static void main(String[] args){
        ArrayList<Edge>[] graph = new ArrayList[5];
        graph = createGraph(graph);
        GraphClass Graph = new GraphClass();
        Graph.BFS(graph,0);
    }
}

class Edge {
    int src, dest, weight;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class GraphClass {
   
    void BFS(ArrayList<Edge>[] graph,int start){
        boolean visited_arr[]= new boolean[5];
        Queue<Integer> qq = new LinkedList<Integer>();
        qq.add(start);
        while(!qq.isEmpty()){
            int temp = qq.remove();
            if(!visited_arr[temp]){
                System.out.print(temp+" ");
                visited_arr[temp] = true;

                for(int i=0;i<graph[temp].size();i++){
                    Edge e = graph[temp].get(i);
                    qq.add(e.dest);
                }
            }
        }
    }

    void DFS(ArrayList<Edge>[] graph,int start){
        
    }
    
}

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
        System.out.println();
        Graph.DFS(graph, 0);
    }
}

class Edge {
    int src, dest, weight;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class GraphClass { // BFS uses a Queue whereas DFS uses a Stack, This only is the difference
   
    // Function to perform Breadth-First Search (BFS) on a graph
    void BFS(ArrayList<Edge>[] graph,int start){
        // Create a boolean array to keep track of visited nodes
        boolean visited_arr[]= new boolean[5];
        // Create a queue and add the start node to it
        Queue<Integer> qq = new LinkedList<Integer>();
        qq.add(start);
        while(!qq.isEmpty()){
            // Remove the front node from the queue
            int temp = qq.remove();
            // If the node has not been visited
            if(!visited_arr[temp]){
                // Print the node
                System.out.print(temp+" ");
                // Mark the node as visited
                visited_arr[temp] = true;
                // For each edge from the current node
                for(int i=0;i<graph[temp].size();i++){
                    Edge e = graph[temp].get(i);
                    // Add the destination node of the edge to the queue
                    qq.add(e.dest);
                }
            }
        }
    }

    // Function to perform Depth-First Search (DFS) on a graph
    void DFS(ArrayList<Edge>[] graph,int start){
        // Create a boolean array to keep track of visited nodes
        boolean visited_arr[]= new boolean[5];
        // Create a stack and push the start node onto it
        Stack<Integer> ss = new Stack<>();
        ss.push(start);
        while(!ss.isEmpty()){
            // Pop the top node from the stack
            int temp = ss.pop();
            // If the node has not been visited
            if(!visited_arr[temp]){
                // Print the node
                System.out.print(temp+" ");
                // Mark the node as visited
                visited_arr[temp] = true;
                // For each edge from the current node
                for(int i=0;i<graph[temp].size();i++){
                    Edge e = graph[temp].get(i);
                    // Push the destination node of the edge onto the stack
                    ss.add(e.dest);
                }       
            }
        }
    }

}

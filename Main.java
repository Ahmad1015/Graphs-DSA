import java.util.*;
public class Main{
    public static void main(String[] args){
        Graph graph = new Graph();

        // Add nodes to the graph
        graph.addEdge("0","3");   
        graph.addEdge("0", "2");  
        graph.addEdge("1", "0");  
        graph.addEdge("2", "1");         
        graph.addEdge("3", "4");   
        graph.addEdge("4", "0");

        graph.BFS("0");
        System.out.println();
        graph.DFS("0");
    }
}



class Edge {
    String source;
    String destination;

    public Edge(String start,String end){
        source = start;
        destination = end;
    }


}

class Graph{
    int elements;
    int size;
    int[][] adjMatrix;
    ArrayList<Edge>[] vertixList;

    public Graph(){
        size=5;
        elements = 0;

        adjMatrix = new int[size][size];

        vertixList = new ArrayList[size];               // Declaring the Size of Array of ArrayLists
        for(int i=0;i<vertixList.length;i++){           // Handling the undefined State
            vertixList[i] = new ArrayList<>();
        }
    }

    private int indexOf(String label){
    for(int i=0; i<vertixList.length; i++){
        for(Edge e : vertixList[i]){
            if(e.source.equals(label)){
                return i;
            }
        }
    }
    return -1;
}


    void addNode(String label) {
    // Check if the node already exists
    if(indexOf(label) != -1) {
        System.out.println("Node already exists.");
        return;
    }

    // Add the node
    vertixList[elements].add(new Edge(label, null));
    elements++;
}

 
   void addEdge(String source, String dest) {
    // Check if the nodes exist, if not, add them
    if(indexOf(source) == -1) {
        vertixList[elements].add(new Edge(source, null));
        elements++;
    }
    if(indexOf(dest) == -1) {
        vertixList[elements].add(new Edge(dest, null));
        elements++;
    }

    // Create the edge
    Edge edge = new Edge(source, dest);

    // Add the edge to the adjacency list
    vertixList[indexOf(source)].add(edge);

    // Update the adjacency matrix
    adjMatrix[indexOf(source)][indexOf(dest)] = 1;
    adjMatrix[indexOf(dest)][indexOf(source)] = 1;
}


    void BFS(String start){
        // Create a boolean array to keep track of visited nodes
        boolean visited_arr[]= new boolean[this.size];
        // Create a queue and add the start node to it
        Queue<String> qq = new LinkedList<String>();
        qq.add(start);
        while(!qq.isEmpty()){
            // Remove the front node from the queue
            if(qq.peek()== null){
                qq.remove();
                continue;
            }
            String element = qq.remove();
            int temp = indexOf(element);
            // If the node has not been visited
            if(!visited_arr[temp]){
                // Print the node
                System.out.print(element+" ");
                // Mark the node as visited
                visited_arr[temp] = true;
                // For each edge from the current node
                for(int i=0;i<vertixList[temp].size();i++){
                    Edge e = vertixList[temp].get(i);
                    // Add the destination node of the edge to the queue
                    qq.add(e.destination);
                }
            }
        }
    }

    // Function to perform Depth-First Search (DFS) on a graph
    void DFS(String start){
        // Create a boolean array to keep track of visited nodes
        boolean visited_arr[]= new boolean[this.size];
        // Create a queue and add the start node to it
        Stack<String> ss = new Stack<>();
        ss.add(start);
        while(!ss.isEmpty()){
            // Remove the front node from the queue
            if(ss.peek()== null){
                ss.pop();
                continue;
            }
            String element = ss.pop();
            int temp = indexOf(element);
            // If the node has not been visited
            if(!visited_arr[temp]){
                // Print the node
                System.out.print(element+" ");
                // Mark the node as visited
                visited_arr[temp] = true;
                // For each edge from the current node
                for(int i=0;i<vertixList[temp].size();i++){
                    Edge e = vertixList[temp].get(i);
                    // Add the destination node of the edge to the queue
                    ss.add(e.destination);
                }
            }
        }
    }



    

}
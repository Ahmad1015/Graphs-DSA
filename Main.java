import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addNode(0, "A");
        graph.addNode(1, "B");
        graph.addNode(2, "C");
        graph.addNode(3, "D");
        graph.addNode(4, "E");

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 5);
        graph.addEdge(4, 3, 7);
        graph.addEdge(2, 1, 9);
        graph.addEdge(3, 2, 3);


        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(graph.adjMatrix[i][j]);
            }
            System.out.println();
        }

        System.out.print("BFS: ");
        String temp = graph.BFS("A");
        System.out.println(temp);

        System.out.print("DFS: ");
        graph.DFS("A");
        System.out.println();

        String temp2 = graph.findPathBFS("A", "D");
        System.out.println(temp2);
    }
}


class Graph {
    int[][] adjMatrix;
    int numVertices;
    String[] labels;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        labels = new String[numVertices];
    }

    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
        // adjMatrix[j][i] = weight;  For undirected graphs
    }

    public void addNode(int i, String label) {
        labels[i] = label;
    }

    public String BFS(String startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        String order = "";

        queue.add(getIndex(startVertex));

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            if (!visited[vertex]) {
                visited[vertex] = true;
                order += labels[vertex] + " ";

                for (int i = 0; i < numVertices; i++) {
                    if (adjMatrix[vertex][i] > 0 && !visited[i]) {
                        queue.add(i);
                    }
                }
            }
        }

        return order.trim();
}

    public void DFS(String startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(getIndex(startVertex));

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(labels[vertex] + " ");

                for (int i = 0; i < numVertices; i++) {
                    if (adjMatrix[vertex][i] > 0 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public String findPathBFS(String startLabel, String endLabel) {
        int startVertex = -1;
        int endVertex = -1;
        String bfsResult = BFS(startLabel);
        if (bfsResult == null) {
            return "The vertex " + startLabel + " doesn't exist.";
        }

        String[] path = bfsResult.split(" ");

        for(int i=0; i<path.length; i++){
            if(path[i].equals(String.valueOf(startLabel)))
                startVertex = i;
            if(path[i].equals(String.valueOf(endLabel)))
                endVertex = i;
        }

        if (startVertex == -1) {
            return "The vertex " + startLabel + " doesn't exist.";
        }

        if (endVertex == -1) {
            return "The vertex " + endLabel + " doesn't exist.";
        }

        if (startVertex > endVertex) {
            return "The path doesn't exist.";
        }
        
        String path_temp = "";
        for(int i=startVertex; i<=endVertex; i++){
            path_temp = path_temp + path[i] + " ";
        }
        return path_temp;
    }

    

    int getIndex(String name){
        for(int i=0;i<labels.length;i++){
            if(labels[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

}

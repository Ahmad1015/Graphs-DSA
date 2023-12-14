public class Main{
    public static void main(String[] args){

    }
}

class Vertex{
    String label;
    Vertex(String label){
        this.label = label;
    }
    Edge next;
    void addEdge(Edge value){
        next = value;
    }
}

class Edge {
    private String source;
    private String destination;
    private Edge next;

    public Edge(String start,String end){
        source = start;
        destination = end;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
}

class Graph{
    int elements;
    int size;
    int[][] adjMatrix;
    Vertex[] vertixList;

    public Graph(){
        size=5;
        elements = 0;
        adjMatrix = new int[5][5];
        vertixList = new Vertex[5];
    }

    private int indexof(String label){
        for(int i=0;i<this.elements;i++){
            if(vertixList[i].label.equals(label)){
                return i;
            }
        }
        return -1;
    }

    boolean addNode(String label,String label_2){
        try{
            // Handling Adjaceny List
            Edge edgeeee = new Edge(label,label_2);
            vertixList[indexof(label)].next = edgeeee;
            
            // handling Adjaceny matrix
            adjMatrix[indexof(label)][indexof(label_2)] = 1;
            adjMatrix[indexof(label_2)][indexof(label)] = 1;
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    

}
public class Main{
    public static void main(String[] args){

    }
}

class Vertex{
    Edge next;
    Edge tail;
    String label;
    Vertex(String label){
        this.label = label;
        this.next = null;
        this.tail=null;
    }
}

class Edge {
    String source;
    String destination;
    Edge next;

    public Edge(String start,String end){
        source = start;
        destination = end;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    boolean add(String label,String label_2){
        try{
            // Handling Adjaceny List
            Edge edgeeee = new Edge(label,label_2);
            Vertex vertex=vertixList[indexof(label)];
            addEnd(vertex,edgeeee);

            edgeeee.setSource(label_2);
            edgeeee.setDestination(label);
            vertex = vertixList[indexof(label_2)];
            addEnd(vertex, edgeeee);

            // handling Adjaceny matrix
            adjMatrix[indexof(label)][indexof(label_2)] = 1;
            adjMatrix[indexof(label_2)][indexof(label)] = 1;
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
 
    private void addEnd(Vertex v, Edge e) {
    if (v.tail == null) {
        // If tail is null, it means the vertex is empty, so initialize both next and tail
        v.next = e;
        v.tail = e;
    } else {
        // If tail is not null, add the edge to the end
        v.tail.next = e;
        v.tail = e;
    }
}

    

}
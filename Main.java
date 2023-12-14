public class Main{
    public static void main(String[] args){

    }
}
class Node{
    String label;

}
class Graph{
    int elements;
    int size;
    int[][] adjMatrix;
    String[] vertixList;

    public Graph(){
        size=5;
        elements = 0;
        adjMatrix = new int[5][5];
        vertixList = new String[5];
    }

    int indexof(String label){
        for(int i=0;i<this.size;i++){
            if(vertixList[i].equals(label)){
                return i;
            }
        }
        return -1;
    }

    

}
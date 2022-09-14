package csc351.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(false);
        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);

        System.out.println(graph);
    }
}

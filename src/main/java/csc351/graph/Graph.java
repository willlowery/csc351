package csc351.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private final HashMap<Integer, ArrayList<EdgeNode>> edges = new HashMap<>();
    private final HashMap<Integer, Integer> degrees = new HashMap<>();
    private final HashSet<Integer> vertices = new HashSet<>();
    private int numberOfEdges = 0;
    public final boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public void insertEdge(int x, int y) {
        insertEdge(x, y, directed);
    }

    private void insertEdge(int x, int y, boolean directed) {
        EdgeNode edge = new EdgeNode(y, null);

        edges
                .computeIfAbsent(x, key -> new ArrayList<>())
                .add(edge);
        degrees.put(
                x,
                degrees.computeIfAbsent(x, (key) -> 0)
        );
        vertices.add(x);
        vertices.add(y);

        if (!directed) {
            insertEdge(y, x, true);
        } else {
            numberOfEdges++;
        }
    }

    public void traverseBreadthFirst(int startingVertex, GraphVisitor visitor) {
//      todo implement this

    }

    public void traverseDepthFirst(int startingVertex, GraphVisitor visitor) {
        traverseDepthFirst(startingVertex, visitor, new GraphVisitor.SearchContext(directed));
    }

    public Set<Integer> findArticulationPoints() {
        ArticulationPointVisitor finder = new ArticulationPointVisitor();

        GraphVisitor.SearchContext context = new GraphVisitor.SearchContext(directed);
        while (!context.getDiscovered().containsAll(vertices)) {
            Integer vertex = vertices.stream().filter(i -> !context.getDiscovered().contains(i)).findFirst().orElseThrow();
            traverseDepthFirst(vertex, finder, context);
        }

        return finder.getArticulationPoints();
    }

    private void traverseDepthFirst(Integer vertex, GraphVisitor visitor, GraphVisitor.SearchContext context) {
        // todo implement this
    }

    @Override
    public String toString() {
        String edgeList = edges
                .entrySet()
                .stream().flatMap(i -> {
                    Integer x = i.getKey();
                    return i.getValue().stream().map(e -> "[" + x + " " + e.y + "]");
                })
                .collect(Collectors.joining(", "));

        return "{ 'edges': " + numberOfEdges + ", 'vertices':" + vertices.size() + " 'edges': " + edgeList + "}";
    }

    private static class EdgeNode {
        Integer y;
        Integer weight;

        public EdgeNode(Integer y, Integer weight) {
            this.y = y;
            this.weight = weight;
        }
    }
}

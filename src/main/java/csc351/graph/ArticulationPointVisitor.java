package csc351.graph;

import java.util.HashSet;

public class ArticulationPointVisitor implements GraphVisitor {
    private final HashSet<Integer> articulationPoints = new HashSet<>();

    @Override
    public void visitEdge(int x, int y, SearchContext context) {
        // todo implement this
    }

    @Override
    public void visitVertexEarly(int x, SearchContext context) {
        // todo implement this
    }

    @Override
    public void visitVertexLate(int x, SearchContext context) {
        // todo implement this
    }

    public HashSet<Integer> getArticulationPoints() {
        return articulationPoints;
    }
}

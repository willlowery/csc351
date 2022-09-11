package csc351.graph;

import java.util.Map;

public interface GraphVisitor {
    void visitEdge(int x, int y);

    void visitVertexEarly(int x);

    void visitVertexLate(int x);

    void visitParents(Map<Integer, Integer> parents);
}

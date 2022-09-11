package csc351.graph;

import java.util.Map;

public class PrintGraphVisitor implements GraphVisitor {
    @Override
    public void visitEdge(int x, int y) {
        System.out.println("Edge (" + x + "," + y + ")");
    }

    @Override
    public void visitVertexEarly(int x) {
        System.out.println("vertex (" + x + ")");

    }

    @Override
    public void visitVertexLate(int x) {

    }

    @Override
    public void visitParents(Map<Integer, Integer> parents) {
        System.out.println(parents);
    }
}

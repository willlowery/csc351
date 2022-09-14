package csc351.graph;

import java.util.Map;

public class PrintGraphVisitor implements GraphVisitor {
    @Override
    public void visitEdge(int x, int y,SearchContext context) {
        System.out.printf("visiting edge [%s,%s]%n", x, y);
    }

    @Override
    public void visitVertexEarly(int x,SearchContext context) {
        System.out.printf("visiting vertex %s %n", x);
    }

    @Override
    public void visitVertexLate(int x,SearchContext context) {
    }
}

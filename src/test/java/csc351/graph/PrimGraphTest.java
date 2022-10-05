package csc351.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimGraphTest {
    /**
     * graph line {
     * 1 -- 2 [label=5]
     * 2 -- 3 [label=7]
     * }
     **/
    @Test
    void testLineIsTheMinSpanningTree() {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, 5);
        graph.insertEdge(2, 3, 7);

        Graph.PrimResult prim = graph.prim(1);
        assertEquals(0, prim.getDistance().get(1));
        assertEquals(5, prim.getDistance().get(2));
        assertEquals(7, prim.getDistance().get(3));

        assertEquals(-1, prim.getParents().get(1));
        assertEquals(1, prim.getParents().get(2));
        assertEquals(2, prim.getParents().get(3));
    }

    /**
     * graph circle {
     * 1 -- 2 [label=5]
     * 2 -- 3 [label=6]
     * 3 -- 1 [label=5]
     * }
     **/
    @Test
    void testCircleOfThree() {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, 5);
        graph.insertEdge(2, 3, 6);
        graph.insertEdge(3, 1, 5);

        Graph.PrimResult prim = graph.prim(1);
        assertEquals(0, prim.getDistance().get(1));
        assertEquals(5, prim.getDistance().get(2));
        assertEquals(5, prim.getDistance().get(3));

        assertEquals(-1, prim.getParents().get(1));
        assertEquals(1, prim.getParents().get(2));
        assertEquals(1, prim.getParents().get(3));
    }
}

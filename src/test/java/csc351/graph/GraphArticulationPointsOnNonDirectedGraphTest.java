package csc351.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphArticulationPointsOnNonDirectedGraphTest {
    private final Graph graph = new Graph(false);

    @Test
    void twoVertexGraph() {
        graph.insertEdge(1, 2);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(), points);
    }

    @Test
    void testFindLineOf3ArticulationPoint() {
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);

        Set<Integer> points = graph.findArticulationPoints();

        assertEquals(points, items(2));
    }

    @Test
    void testFindLineOf5ArticulationPoint() {
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 5);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(points, items(2, 3, 4));
    }

    @Test
    void testFindLineOf4WithLinkBetween1and3ArticulationPoint() {
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);

        Set<Integer> points = graph.findArticulationPoints();

        assertEquals(points, items(3));
    }

    @Test
    void rootCutNode() {
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(1), points);
    }

    @Test
    void parentCutNode() {
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 6);
        graph.insertEdge(5, 6);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(3), points);
    }


    @Test
    void bridgeCutNode() {
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(4, 5);


        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(2, 3), points);
    }


    private HashSet<Integer> items(Integer... i) {
        return new HashSet<>(Arrays.asList(i));
    }
}
package csc351.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloydTest {

    @Test
    void singleEdgeGraphIsUnchanged() {
        Floyd floyd = new Floyd(10, false);

        floyd.insertEdge(1, 2, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
    }

    @Test
    void twoEdgeGraphHasPairWeights() {
        Floyd floyd = new Floyd(10, false);

        floyd.insertEdge(1, 2, 10);
        floyd.insertEdge(2, 3, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
        assertEquals(10, floyd.getWeight(2, 3));
        assertEquals(20, floyd.getWeight(1, 3));
        assertEquals(20, floyd.getWeight(3, 1));
        assertEquals(10, floyd.getWeight(3, 2));
        assertEquals(10, floyd.getWeight(2, 1));
    }

    @Test
    void twoEdgeDiGraphHasPairWeights() {
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1, 2, 10);
        floyd.insertEdge(2, 3, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
        assertEquals(10, floyd.getWeight(2, 3));
        assertEquals(20, floyd.getWeight(1, 3));
        assertTrue(floyd.edgeMissing(2, 1));
        assertTrue(floyd.edgeMissing(3, 2));
        assertTrue(floyd.edgeMissing(3, 1));
    }

    @Test
    void threeCycleDiGraphHasPairWeights() {
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1, 2, 10);
        floyd.insertEdge(2, 3, 10);
        floyd.insertEdge(3, 1, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
        assertEquals(10, floyd.getWeight(2, 3));
        assertEquals(10, floyd.getWeight(3, 1));
        assertEquals(20, floyd.getWeight(1, 3));
        assertEquals(20, floyd.getWeight(3, 2));
    }
}
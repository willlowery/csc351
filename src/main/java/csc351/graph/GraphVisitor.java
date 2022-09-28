package csc351.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public interface GraphVisitor {
    void visitEdge(int x, int y, SearchContext context);

    void visitVertexEarly(int x, SearchContext context);

    void visitVertexLate(int x, SearchContext context);

    enum EdgeClass {
        TREE,
        BACK,
        CROSS,
        FORWARD,
        UNKNOWN
    }

    class SearchContext {
        private final boolean directed;
        private final HashSet<Integer> discovered = new HashSet<>();
        private final HashSet<Integer> processed = new HashSet<>();
        private final HashMap<Integer, Integer> parents = new HashMap<>();
        private final HashMap<Integer, Integer> entryTime = new HashMap<>();
        private final HashMap<Integer, Integer> exitTime = new HashMap<>();
        private int time = 0;

        public SearchContext(boolean directed) {
            this.directed = directed;
        }

        public HashSet<Integer> getDiscovered() {
            return discovered;
        }

        public HashSet<Integer> getProcessed() {
            return processed;
        }

        public HashMap<Integer, Integer> getParents() {
            return parents;
        }

        public HashMap<Integer, Integer> getEntryTime() {
            return entryTime;
        }

        public void updateEntryTime(int vertex) {
            entryTime.put(vertex, time);
            time++;
        }

        public void updateExitTime(int vertex) {
            exitTime.put(vertex, time);
            time++;
        }

        public void setParent(int child, int parent) {
            this.parents.put(child, parent);
        }

        public void setDiscovered(int v) {
            this.discovered.add(v);
        }

        public void setProcessed(int v) {
            this.processed.add(v);
        }

        public boolean isRoot(int vertex) {
            return this.parents.get(vertex) == null;
        }

        public EdgeClass classify(int x, int y) {
            if (directed) {
                if (Objects.equals(parents.get(y), x)) return EdgeClass.TREE;
                if (discovered.contains(y) && !processed.contains(y)) return EdgeClass.BACK;
                if (processed.contains(y) && entryTime.getOrDefault(y, 0) > entryTime.getOrDefault(x, 0))
                    return EdgeClass.FORWARD;
                if (processed.contains(y) && entryTime.getOrDefault(y, 0) < entryTime.getOrDefault(x, 0))
                    return EdgeClass.CROSS;
                return EdgeClass.UNKNOWN;
            } else {
                if (Objects.equals(parents.get(y), x))
                    return EdgeClass.TREE;
                else
                    return EdgeClass.BACK;
            }
        }

        public int parent(int vertex) {
            return parents.getOrDefault(vertex, -1);
        }

        public int entryTime(int vertex) {
            return entryTime.getOrDefault(vertex, -1);
        }

        public boolean processed(int vertex) {
            return processed.contains(vertex);
        }

        public boolean discovered(int vertex) {
            return discovered.contains(vertex);
        }
    }
}

package csc351.backtracking;

public class BackTracking<Type> {

    protected boolean finished = false;
    protected int maxCandidates;

    protected final void backtrack(int[] a, int k, Type input) {
        int[] candidates = new int[maxCandidates];

        if (isSolution(a, k, input)) {
            processSolution(a, k, input);
        } else {
            k++;
            int n = constructCandidate(a, k, input, candidates);
            for (int i = 0; i < n; i++) {
                a[k] = candidates[i];

                makeMove(a, k, input);
                backtrack(a, k, input);
                unmakeMove(a, k, input);
                if (finished) return;
            }
        }
    }

    protected void makeMove(int[] a, int k, Type input) {

    }

    protected void unmakeMove(int[] a, int k, Type input) {

    }

    protected void processSolution(int[] a, int k, Type input) {
    }


    protected boolean isSolution(int[] a, int k, Type input) {
        return false;
    }


    protected int constructCandidate(int[] a, int k, Type input, int[] candidates) {
        return 0;
    }

}

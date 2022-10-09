package csc351.backtracking;

public class SubsetsBacktracking extends BackTracking<Integer> {

    public SubsetsBacktracking() {
        super.maxCandidates = 2;
    }

    public void generateSubsets(int n) {
        int[] a = new int[n + 1];
        backtrack(a, 0, n);
    }

    protected int constructCandidate(int[] a, int k, Integer input, int[] c) {
        c[0] = 1;
        c[1] = 0;
        return 2;
    }


    protected void processSolution(int[] a, int k, Integer input) {
        System.out.print("{");
        for (int i = 1; i <= k; i++) {
            if (a[i] == 1) {
                System.out.print(" " + i);
            }
        }
        System.out.println("}");
    }

    protected boolean isSolution(int[] a, int k, Integer input) {
        return k == input;
    }


    public static void main(String[] args) {
        new SubsetsBacktracking().generateSubsets(3);
    }
}

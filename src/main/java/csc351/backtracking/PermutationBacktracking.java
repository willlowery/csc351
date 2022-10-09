package csc351.backtracking;

public class PermutationBacktracking extends BackTracking<Integer> {

    public PermutationBacktracking() {
        super.maxCandidates = 100;
    }

    public void perms(int n) {
        int[] a = new int[n + 1];
        backtrack(a, 0, n);

    }

    protected int constructCandidate(int[] a, int k, Integer input, int[] candidates) {
        boolean[] inPerm = new boolean[maxCandidates];
        for (int i = 0; i < k; i++) {
            inPerm[a[i]] = true;
        }
        int count = 0;
        for (int i = 1; i <= input; i++) {
            if (!inPerm[i]) {
                candidates[count] = i;
                count = count + 1;
            }
        }
        return count;
    }


    protected void processSolution(int[] a, int k, Integer input) {
        System.out.print("{");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println("}");
    }

    protected boolean isSolution(int[] a, int k, Integer input) {
        return k == input;
    }


    public static void main(String[] args) {
        new PermutationBacktracking().perms(3);
    }
}

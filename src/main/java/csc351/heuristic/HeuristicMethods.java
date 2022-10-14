package csc351.heuristic;

public class HeuristicMethods {

    public static TileBoard randomSample(TileBoard board, int n) {
        TileBoard best = board.copy();
        int bestScore = best.score();
        for (int i = 0; i < n; i++) {
            board.fillRandom();
            int score = board.score();
            if (score > bestScore) {
                bestScore = score;
                best = board.copy();
            }

        }
        return best;
    }

    public static TileBoard hillClimb(TileBoard board) {
        int bestScore = board.score();

        boolean stuck;
        do {
            stuck = true;
            for (int i = 0; i < board.getXSize(); i++) {
                for (int j = 0; j < board.getYSize(); j++) {
                    for (Tile value : Tile.values()) {
                        Tile temp = board.get(i, j);
                        board.set(i, j, value);

                        int score = board.score();

                        if (bestScore < score) {
                            stuck = false;
                            bestScore = score;
                        } else {
                            board.set(i, j, temp);
                        }
                    }
                }
            }

        } while (!stuck);

        return board;
    }

    public static void main(String[] args) {
        TileBoard board = new TileBoard(8, 8);

//        board = randomSample(board, 200_000);
        hillClimb(board);
        System.out.println(board);
        System.out.println(board.score());
    }
}

package csc351.heuristic;

import java.util.Random;

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

    public static void anneal(TileBoard board, double initialTemp, double coolingFactor, int coolingSteps, int stepsPerTemp, double k) {
        Random r = new Random();
        double temp = initialTemp;
        int currentValue = board.score();

        for (int i = 1; i <= coolingSteps; i++) {
            temp = temp * coolingFactor;
            int startValue = currentValue;
            for (int j = 1; j <= stepsPerTemp; j++) {
                int x = r.nextInt(board.getXSize());
                int y = r.nextInt(board.getYSize());

                double flip = r.nextDouble();

                Tile tile = board.get(x, y);
                board.set(x, y, Tile.random());

                int newScore = board.score();
                int delta = currentValue - newScore;

                double exponent;
                if (currentValue == 0) {
                    exponent = (-delta) / (k * temp);
                } else {
                    exponent = (-delta / (double) currentValue) / (k * temp);
                }
                double merit = Math.pow(Math.E, exponent);

                if (delta < 0) {
                    currentValue = newScore;
                } else if (merit > flip) {
                    currentValue = newScore;
                } else {
                    board.set(x, y, tile);
                }
            }
        }
    }

    public static void main(String[] args) {
        TileBoard board = new TileBoard(8, 8);
        board.blank();

//        board = randomSample(board, 200_000);
//        board.fillRandom();
//        hillClimb(board); 172
        anneal(board, 1, .15, 10, 200, 1);
        System.out.println(board);
        System.out.println(board.score());
    }
}

package csc351.heuristic;

import java.util.Arrays;
import java.util.List;

public class ScoreBoard {
    private final TileBoard board;
    private final List<Rule> RULES = Arrays.asList(
            new Rule(Tile.HOUSE, 2, 1, 4, 1),
            new Rule(Tile.PARK, 0, 0, 2, 1),
            new Rule(Tile.STORE, 0, 0, 2, 1),
            new Rule(Tile.OFFICE, 3, 1, 5, 2),
            new Rule(Tile.FACTORY, 5, 2, 8, 5)
    );


    public ScoreBoard(TileBoard board) {
        this.board = board;
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < board.getXSize(); i++) {
            for (int j = 0; j < board.getYSize(); j++) {
                Tile tile = board.get(i, j);
                if (Tile.HOUSE.equals(tile)) {
                    for (Rule rule : RULES) {
                        int closest = closestTile(i, j, rule.tile);
                        if (closest < rule.dangerLength) {
                            totalScore += -rule.penalty;
                        } else if (closest < rule.benifitLength) {
                            totalScore += rule.reward;
                        }
                    }
                }
            }
        }
        return totalScore;
    }

    private int closestTile(int x, int y, Tile t) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < board.getXSize(); i++) {
            for (int j = 0; j < board.getYSize(); j++) {
                if (x == i && y == j) continue;
                if (t.equals(board.get(i, j))) {
                    int dist = manhattanDistance(x, y, i, j);
                    if (dist < result) {
                        result = dist;
                    }
                }
            }
        }
        return result;
    }

    private int manhattanDistance(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }


    private static class Rule {
        Tile tile;
        int dangerLength;
        int penalty;
        int benifitLength;
        int reward;

        public Rule(Tile tile, int dangerLength, int penalty, int benifitLength, int reward) {
            this.tile = tile;
            this.dangerLength = dangerLength;
            this.penalty = penalty;
            this.benifitLength = benifitLength;
            this.reward = reward;
        }
    }
}

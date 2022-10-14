package csc351.heuristic;

import java.util.Arrays;
import java.util.Random;

public class TileBoard {
    private final Tile[][] board;
    private final int xSize;
    private final int ySize;

    public TileBoard(int xSize, int ySize) {
        this(new Tile[xSize][ySize], xSize, ySize);
    }

    public TileBoard(Tile[][] board, int xSize, int ySize) {
        this.board = board;
        this.xSize = xSize;
        this.ySize = ySize;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                board[i][j] = Tile.EMPTY;
            }
        }
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void set(int x, int y, Tile tile) {
        board[x][y] = tile;
    }

    public Tile get(int x, int y) {
        return board[x][y];
    }

    public void fillRandom() {

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {

                board[i][j] = Tile.random();
            }
        }
    }

    public int score() {
        return new ScoreBoard(this).score();
    }

    public TileBoard copy() {
        Tile[][] newBoard = Arrays.copyOf(board, board.length);
        for (int i = 0, boardLength = board.length; i < boardLength; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return new TileBoard(newBoard, xSize, ySize);
    }

    @Override
    public String toString() {
        String out = "";
        for (Tile[] tiles : board) {
            String line = "";
            for (Tile tile : tiles) {
                line += " " + tile.tile;
            }
            out += line + "\n";

        }

        return out;
    }
}

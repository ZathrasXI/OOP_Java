package edu.uob;

import java.util.ArrayList;
import java.util.List;

public class OXOModel {

    private OXOPlayer[] players;
    private int currentPlayerNumber;
    private OXOPlayer winner;
    private boolean gameDrawn;
    int rows;
    int cols;
    private int winThreshold;
    private List<List<OXOPlayer>> board;

    public OXOModel(int numberOfRows, int numberOfColumns, int winThresh) {
        winThreshold = winThresh;
        players = new OXOPlayer[2];
        rows = 3;
        cols = 3;
        board = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                board.get(i).add(new OXOPlayer(' '));
            }
        }
    }
    public List<List<OXOPlayer>> getBoard() {
        return board;
    }

    public int getNumberOfPlayers() {
        return players.length;
    }

    public void addPlayer(OXOPlayer player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

    public OXOPlayer getPlayerByNumber(int number) {
        return players[number];
    }

    public OXOPlayer getWinner() {
        return winner;
    }

    public void setWinner(OXOPlayer player) {
        winner = player;
    }

    public int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

    public void setCurrentPlayerNumber(int playerNumber) {
        currentPlayerNumber = playerNumber;
    }

    public int getNumberOfRows() {return board.size(); }

    public int getNumberOfColumns() {
        return board.get(0).size();
    }

    public OXOPlayer getCellOwner(int rowNumber, int colNumber) {
        return board.get(rowNumber).get(colNumber);
    }

    public void setCellOwner(int rowNumber, int colNumber, OXOPlayer player) {
        board.get(rowNumber).set(colNumber, player);
    }

    public void setWinThreshold(int winThresh) {
        winThreshold = winThresh;
    }

    public int getWinThreshold() {
        return winThreshold;
    }

    public void setGameDrawn(boolean isDrawn) {
        gameDrawn = isDrawn;
    }

    public boolean isGameDrawn() {
        return gameDrawn;
    }

    public void addRow() {
        board.add(new ArrayList<>());
        int end = board.size() - 1;
        for (int i = 0; i < this.cols; i++) {
            board.get(end).add(new OXOPlayer(' '));
        }
        this.rows++;
    }

    public void addColumn() {
        for (int i = 0; i < this.rows; i++) {
            board.get(i).add(new OXOPlayer(' '));
        }
        this.cols++;
    }

    public void removeRow() {
        if (this.rows > 3) {
            board.remove(board.size() -1 );
            this.rows--;
        }
    }

    public void removeColumn() {
        if (this.cols > 3) {
            int endCol = board.get(0).size() - 1;
            for (int i = 0; i < this.rows; i++) {
                board.get(i).remove(endCol);
            }
            this.cols--;
        }
    }



}

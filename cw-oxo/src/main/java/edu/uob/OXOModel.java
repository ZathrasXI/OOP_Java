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

    public int getNumberOfRows() {
        return cells.length;
    }

    public int getNumberOfColumns() {
        return cells[0].length;
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

}

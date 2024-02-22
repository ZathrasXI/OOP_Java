package edu.uob;

public class OXOController {
    OXOModel gameModel;

    public OXOController(OXOModel model) {
        gameModel = model;
    }

    public void handleIncomingCommand(String command) throws OXOMoveException {
        int row, col;
        command = command.toLowerCase();
        switch (command.substring(0, 1)) {
            case "a" -> row = 0;
            case "b" -> row = 1;
            case "c" -> row = 2;
            default -> row = -1;
        }

        col = switch (command.substring(1)) {
            case "1" -> 0;
            case "2" -> 1;
            case "3" -> 2;
            default -> -1;
        };
        int player_id = this.gameModel.getCurrentPlayerNumber();
        OXOPlayer cur_player = this.gameModel.getPlayerByNumber(player_id);
        this.gameModel.setCellOwner(row, col, cur_player);

        if (player_id == 0) {
            this.gameModel.setCurrentPlayerNumber(1);
        } else {
            this.gameModel.setCurrentPlayerNumber(0);
        }
    }
    public void addRow() { gameModel.addRow(); }
    public void removeRow() {}
    public void addColumn() { gameModel.addColumn(); }
    public void removeColumn() {}
    public void increaseWinThreshold() {}
    public void decreaseWinThreshold() {}
    public void reset() {
        int rows = this.gameModel.getNumberOfRows();
        int cols = this.gameModel.getNumberOfColumns();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.gameModel.setCellOwner(r,c,null);
            }
        }
        this.gameModel.setCurrentPlayerNumber(0);
    }
}

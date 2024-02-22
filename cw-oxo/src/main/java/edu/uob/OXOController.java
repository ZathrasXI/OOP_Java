package edu.uob;

public class OXOController {
    OXOModel gameModel;

    public OXOController(OXOModel model) {
        gameModel = model;
    }

    public void handleIncomingCommand(String command) throws OXOMoveException {
        int row, col;
        command = command.toLowerCase();

        char[] rowAsChar = command.substring(0,1).toCharArray();
        row = rowAsChar[0] - 'a';

        col = Integer.parseInt(command.substring(1,2)) - 1;
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
    public void removeRow() { gameModel.removeRow(); }
    public void addColumn() { gameModel.addColumn(); }
    public void removeColumn() { gameModel.removeColumn(); }
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

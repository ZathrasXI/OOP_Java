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

        if (this.winningMove()) System.out.println("win");
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

    public boolean winningMove() {

        OXOPlayer curPlayer = gameModel.getPlayerByNumber(gameModel.getCurrentPlayerNumber());
        char letter = curPlayer.getPlayingLetter();

        //check horizontal
        int horiCount = 0;
        for (int r = 0; r < gameModel.rows; r++) {
            for (int c = 0; c < gameModel.cols; c++) {
                if (gameModel.getBoard().get(r).get(c).getPlayingLetter() == letter) horiCount++;
            }
            if (horiCount == gameModel.cols) {
                System.out.println("horizontal winner");
                return true;
            } else {
                horiCount = 0;
            }
        }

        //check vertical
        int colIndex = 0;
        int vertCount = 0;
        while (colIndex < gameModel.cols ) {
            for (int r = 0; r < gameModel.rows; r++) {
                if (gameModel.getBoard().get(r).get(colIndex).getPlayingLetter() == letter) vertCount++;
            }
            if (vertCount == gameModel.rows) {
                System.out.println("vert winner");
                return true;
            } else {
                vertCount = 0;
                colIndex++;
            }
        }

        //check diagonal
        int win = Math.min(gameModel.cols, gameModel.rows);
        int l2r_diagCount = 0;
        int r2l_diagCount = 0;
        int r2l_index = gameModel.cols - 1;
        for (int i = 0; i < win; i++) {
            if (gameModel.getBoard().get(i).get(i).getPlayingLetter() == letter) l2r_diagCount++;
            if (gameModel.getBoard().get(i).get(r2l_index).getPlayingLetter() == letter) {
                r2l_index--;
                r2l_diagCount++;
            }
        }
        if (r2l_diagCount == win || l2r_diagCount == win) {
            System.out.println("diagonal winner");
            return true;
        }

        return false;
    }
}



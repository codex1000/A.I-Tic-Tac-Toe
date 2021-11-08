import java.awt.*;

public class TicTacToeAPI {
    private String player1, player2;
    private String winType;

    public TicTacToeAPI() {
        player1 = "O";
        player2 = "X";
        winType = " ";
    }

    public String changeTurns(String turn) {
        if (turn.equals(" "))
            return player1;
        else if (turn.equals(player1))
            turn = player2;
        else
            turn = player1;
        return turn;
    }

    public Square winner(Square[][] board, int rows, int columns) {
        // check column wins
        for (int i = 0; i < rows; i++) {
            if (board[i][0].getPiece().getValue().equals(board[i][1].getPiece().getValue())
                    && board[i][1].getPiece().getValue().equals(board[i][2].getPiece().getValue())
                    && board[i][0].getPiece().getValue().equals(board[i][0].getPiece().getValue())
                    && !board[i][0].getPiece().getValue().equals(" ") && !board[i][1].getPiece().getValue().equals(" ")
                    && !board[i][2].getPiece().getValue().equals(" ")) {
                winType = "column";
                return board[i][0];
            }
        }
        // checks row wins
        for (int i = 0; i < columns; i++) {
            if (board[0][i].getPiece().getValue().equals(board[1][i].getPiece().getValue())
                    && board[1][i].getPiece().getValue().equals(board[2][i].getPiece().getValue())
                    && board[0][i].getPiece().getValue().equals(board[2][i].getPiece().getValue())
                    && !board[0][i].getPiece().getValue().equals(" ") && !board[1][i].getPiece().getValue().equals(" ")
                    && !board[2][i].getPiece().getValue().equals(" ")) {
                winType = "row";
                return board[0][i];
            }
        }
        // checks diagonal wins
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])
                && !board[0][0].getPiece().getValue().equals(" ")) {
            winType = "diagonal";
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])
                && !board[0][2].getPiece().getValue().equals(" ")) {
            winType = "diagonal";
            return board[0][2];
        }
        return null;
    }

    public void drawWinningPath(Graphics g, Square winner, int squareLength) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(8));
        if (winType.equals("diagonal")) {
            if (winner.getCol() - 1 == 0) {
                g.drawLine((winner.getCol() - 1) * squareLength + 100, (winner.getRow() - 1) * squareLength + 90,
                        squareLength * 3 + 100, squareLength * 3 + 90);
            } else if (winner.getCol() - 1 == 2) {
                g.drawLine((winner.getCol() - 1) * squareLength + 100 + squareLength,
                        (winner.getRow() - 1) * squareLength + 90, 100, squareLength * 3 + 90);
            }
        } else if (winType.equals("row")) {
            g.drawLine((winner.getRow() - 1) * squareLength + 100, (winner.getCol() - 1) * squareLength + 200,
                    squareLength * 3 + 100, (winner.getCol() - 1) * squareLength + 200);
        } else if (winType.equals("column")) {
            g.drawLine((winner.getRow() - 1) * squareLength + 200, (winner.getCol() - 1) * squareLength + 90,
                    (winner.getRow() - 1) * squareLength + 200, squareLength * 3 + 90);
        }
    }

    public void gameResult(Graphics g, String result) {
        g.setFont(new Font("Arial", Font.BOLD, 75));
        if (result.equals("TIE")) {
            g.setColor(Color.CYAN);
            g.drawString("GAME TIED!", Frame.WIDTH / 2 - 220, Frame.HEIGHT - 40);
        } else {
            g.setColor(new Color(209, 242, 235));
            g.drawString("Player \'" + result + "\' WON!", Frame.WIDTH / 2 - 290, Frame.HEIGHT - 40);
        }
    }
}
public class Pawn extends ChessPiece {

    private boolean canPromote;

    public Pawn(String color) {
        super(color);
        canPromote = false;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        int dx = Math.abs(toLine - fromLine);
        int dy = Math.abs(toColumn - fromColumn);

        if (getColor().equals("White")) {
            if (dx == 1 && dy == 0 && toLine > fromLine && chessBoard.board[toLine][toColumn] == null) {
                if (toLine == 7) {
                    canPromote = true;
                }
                return true;
            }
            if (dx == 2 && dy == 0 && fromLine == 1 && toLine == 3 && chessBoard.board[2][toColumn] == null && chessBoard.board[3][toColumn] == null) {
                return true;
            }
            if (dx == 1 && dy == 1 && toLine > fromLine && Math.abs(toColumn - fromColumn) == 1 &&
                    chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                if (toLine == 7) {
                    canPromote = true;
                }
                return true;
            }
        } else if (getColor().equals("Black")) {
            if (dx == 1 && dy == 0 && toLine < fromLine && chessBoard.board[toLine][toColumn] == null) {
                if (toLine == 0) {
                    canPromote = true;
                }
                return true;
            }
            if (dx == 2 && dy == 0 && fromLine == 6 && toLine == 4 && chessBoard.board[5][toColumn] == null && chessBoard.board[4][toColumn] == null) {
                return true;
            }
            if (dx == 1 && dy == 1 && toLine < fromLine && Math.abs(toColumn - fromColumn) == 1 &&
                    chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                if (toLine == 0) {
                    canPromote = true;
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean canEat(ChessBoard chessBoard, int fromLine, int fromColumn, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, fromLine, fromColumn, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean canPromote() {
        return canPromote;
    }
}
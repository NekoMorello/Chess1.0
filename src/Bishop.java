public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
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

        if (dx == 0 && dy == 0) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
            return dx == dy;
        }

        if (dx == dy) {
            int rowDirection = (toLine - fromLine) / dx;
            int colDirection = (toColumn - fromColumn) / dy;

            int row = fromLine + rowDirection;
            int col = fromColumn + colDirection;

            while (row != toLine && col != toColumn) {
                if (chessBoard.board[row][col] != null) {
                    return false;
                }
                row += rowDirection;
                col += colDirection;
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean canEat(ChessBoard chessBoard, int fromLine, int fromColumn, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, fromLine, fromColumn, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
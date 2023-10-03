public class Rook extends ChessPiece {

    public Rook(String color) {
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

        if (dx == 0 || dy == 0) {
            int stepX = Integer.compare(toLine, fromLine);
            int stepY = Integer.compare(toColumn, fromColumn);
            int currentX = fromLine + stepX;
            int currentY = fromColumn + stepY;

            while (currentX != toLine || currentY != toColumn) {
                if (chessBoard.board[currentX][currentY] != null) {
                    return false;
                }
                currentX += stepX;
                currentY += stepY;
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
        return "R";
    }
}
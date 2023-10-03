public class King extends ChessPiece {

    public King(String color) {
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

        return dx <= 1 && dy <= 1;
    }

    @Override
    public boolean canEat(ChessBoard chessBoard, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        int dx = Math.abs(toLine - fromLine);
        int dy = Math.abs(toColumn - fromColumn);

        if (dx == 0 && dy == 0) {
            return false;
        }

        return dx <= 1 && dy <= 1;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        return false;
    }
}
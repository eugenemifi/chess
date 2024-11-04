package ru.mifi.chess;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int dLine = Math.abs(line - toLine);
        int dColumn = Math.abs(column - toColumn);

        if ((dLine == 2 && dColumn == 1) || (dLine == 1 && dColumn == 2)) {
            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

package ru.mifi.chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int direction = color.equals("White") ? 1 : -1;
        if (column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            if (line + direction == toLine) return true;
            if ((line == 1 && color.equals("White") || line == 6 && color.equals("Black")) && line + 2 * direction == toLine) {
                return chessBoard.board[line + direction][column] == null;
            }
        }
        if (Math.abs(column - toColumn) == 1 && line + direction == toLine && chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

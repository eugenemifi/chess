package ru.mifi.chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return new Bishop(color).canMoveToPosition(chessBoard, line, column, toLine, toColumn) ||
                new Rook(color).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

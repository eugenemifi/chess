package ru.mifi.chess;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine || column == toColumn) {
            int stepLine = Integer.compare(toLine, line);
            int stepColumn = Integer.compare(toColumn, column);

            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;

            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine += stepLine;
                currentColumn += stepColumn;
            }

            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

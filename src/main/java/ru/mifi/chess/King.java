package ru.mifi.chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color) &&
                        board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}

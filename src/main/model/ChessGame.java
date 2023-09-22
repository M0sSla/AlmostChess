package main.model;

import main.model.entities.Board;
import main.model.entities.PieceColor;
import main.model.entities.Position;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ChessGame {
    private final PieceColor currentPlayer;
    private final List<Board> previousStates;
    private final List<PieceMove> previousMoves;
    private final Board board;

    private boolean finished = false;
    private PieceColor winner = null;
    private Map<Position, Set<Position>> validMovesForCurrentPlayer;

    public ChessGame(PieceColor currentPlayer,
                     List<Board> previousStates, List<PieceMove> previousMoves,
                     Board board) {
        this.currentPlayer = currentPlayer;
        this.previousStates = previousStates;
        this.previousMoves = previousMoves;
        this.board = board;
    }

    public Optional<Piece> at(Position p) {
        return board.at(p);
    }
}

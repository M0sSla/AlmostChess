package main.data;

import main.model.Piece;
import main.model.Repository;
import main.model.entities.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {
    private Board board;
    @Override
    public Board move(Position to) {

        return null;
    }

    public RepositoryImpl(Board board) {
        createBoard();
    }

    private void createBoard() {
        board = new Board(createArrangement());


        // Here we need to create start arrangement

    }

    private Collection<Piece> createArrangement() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(new Imp(
                new Position(1, 2),
                PieceColor.RED,
                Tier.FIRST_LEVEL,
                4.0
        ));

        return pieces;
    }

    public Board getBoard() {
        return board;
    }
}

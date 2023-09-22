package main.model.entities;

import main.model.Piece;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board implements Cloneable{
    final Map<Position, Piece> bluePieces = new HashMap<>();
    final Map<Position, Piece> redPieces = new HashMap<>();

    public Board() {
    }

    /**
     * This code creates a new Board object and initializes it with a collection of Piece objects.
     * The pieces are filtered by their color, and then added to a Maps called
     * bluePieces & redPieces using their position as the key and the Piece object as the value.
     * The Map is created using a stream and Collectors.toMap() method,
     * which takes a function to extract the key and another function to extract the value
     * from each Piece object.
     * @param pieces
     */
    public Board(Collection<Piece> pieces) {
        bluePieces.putAll(pieces.stream().filter(p -> p.getPieceColor() == PieceColor.BLUE)
                .collect(Collectors.toMap(Piece::getPosition, Function.identity())));
        redPieces.putAll(pieces.stream().filter(p -> p.getPieceColor() == PieceColor.RED)
                .collect(Collectors.toMap(Piece::getPosition, Function.identity())));
    }

    public static Board startBoard() {
        Board board = new Board();

        // Here we need to create start arrangement

        return board;
    }

    public Optional<Piece> at(Position p) {
        return bluePieces.containsKey(p)
                ? Optional.of(bluePieces.get(p))
                : Optional.ofNullable(redPieces.get(p));
    }

    @Override
    public Board clone() {
        Board clonned = new Board();
        clonned.bluePieces.putAll(bluePieces);
        clonned.redPieces.putAll(redPieces);
        return clonned;
    }
}

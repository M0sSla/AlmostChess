package main.model.entities;

import main.model.Piece;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board implements Cloneable{
    List<Piece> pieces = new ArrayList<>();

    public Board() {
    }

    public Board(Collection<Piece> pieces) {
        this.pieces = (List<Piece>) pieces;
    }

    public static Board startBoard() {
        Board board = new Board();

        // Here we need to create start arrangement

        return board;
    }

    @Override
    public Board clone() {
        Board clonned = new Board();
        clonned.pieces.addAll(pieces);
        return clonned;
    }
}

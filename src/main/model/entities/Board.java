package main.model.entities;

import main.model.Piece;

import java.util.HashMap;
import java.util.Map;

public class Board implements Cloneable{
    final Map<Position, Piece> whitePieces = new HashMap<>();
    final Map<Position, Piece> blackPieces = new HashMap<>();
}

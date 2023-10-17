package main.model;

import main.model.entities.PieceColor;
import main.model.entities.Position;
import main.model.entities.Tier;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    protected final Position position;
    protected final PieceColor pieceColor;
    protected final Tier pieceTier;
    protected final List<Position> possiblePositions;
    protected final Double speed;

     public Piece(Position position, PieceColor pieceColor, Tier pieceType, Double speed) {
        this.position = position;
        this.pieceColor = pieceColor;
        this.pieceTier = pieceType;
        this.speed = speed;
        possiblePositions = new ArrayList<>();
        generatePossiblePosition(position.getX(), position.getY(), speed);
    }

    /**
     * each straight step cost 1 point of speed
     * each diagonal step cost 1.5 points of speed
     * @param x - coord axis by x
     * @param y - coord axis by y
     * @param speed - current speed
     * @return
     */
    public void generatePossiblePosition(Integer x, Integer y, Double speed) {

    }

    public Position getPosition() {
        return position;
    }
    public PieceColor getPieceColor() {
        return pieceColor;
    }
    public Tier getPieceTier() {
        return pieceTier;
    }
    public List<Position> getPossiblePositions() {
        return possiblePositions;
    }
    public Double getSpeed() {
        return speed;
    }
}

package main.model;

import main.model.entities.PieceColor;
import main.model.entities.Position;
import main.model.entities.Tier;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    /**
     * current piece position
     */
    protected final Position position;
    protected final PieceColor pieceColor;
    protected final Tier pieceTier;
    protected final List<Position> possiblePositions;
    /**
     * Piece speed that shows max lens path
     */
    protected final Double speed;

     public Piece(Position position, PieceColor pieceColor, Tier pieceType, Double speed) throws IllegalAccessException {
        this.position = position;
        this.pieceColor = pieceColor;
        this.pieceTier = pieceType;
        this.speed = speed;
        possiblePositions = new ArrayList<>();
        generatePossiblePosition(position.getX(), position.getY(), speed);
    }
    public abstract Piece moveTo(Position to);

    /**
     * each straight step cost 1 point of speed
     * each diagonal step cost 1.5 points of speed
     * @param x - coord axis by x
     * @param y - coord axis by y
     * @param speed - current speed
     * @return
     */
    public void generatePossiblePosition(Integer x, Integer y, Double speed) throws IllegalAccessException {
        if (speed < 1) return;
        Position up1 = new Position(x, y - 1);
        if (!possiblePositions.contains(up1) && (y - 1) >= 1) {
            possiblePositions.add(up1);
            generatePossiblePosition(x, y - 1, speed - 1);
        }
        Position down1 = new Position(x, y + 1);
        if (!possiblePositions.contains(down1) && (y + 1) <= 10) {
            possiblePositions.add(down1);
            generatePossiblePosition(x, y + 1, speed - 1);
        }
        Position left1 = new Position(x - 1, y);
        if (!possiblePositions.contains(left1) && (x - 1) >= 1) {
            possiblePositions.add(left1);
            generatePossiblePosition(x - 1, y, speed - 1);
        }
        Position right1 = new Position(x + 1, y);
        if (!possiblePositions.contains(right1) && (x + 1) <= 12) {
            possiblePositions.add(right1);
            generatePossiblePosition(x + 1, y, speed - 1);
        }

        Position upLeft1 = new Position(x - 1, y - 1);
        if (!possiblePositions.contains(upLeft1) && (x - 1) >= 1 && (y - 1) >= 1) {
            possiblePositions.add(upLeft1);
            generatePossiblePosition(x - 1, y - 1, speed - 1.5);
        }
        Position downLeft1 = new Position(x - 1, y + 1);
        if (!possiblePositions.contains(downLeft1) && (x - 1) >= 1 && (y + 1) <= 10) {
            possiblePositions.add(downLeft1);
            generatePossiblePosition(x - 1, y + 1, speed - 1.5);
        }
        Position upRight1 = new Position(x + 1, y - 1);
        if (!possiblePositions.contains(upRight1) && (x + 1) <= 12 && (y - 1) >= 1) {
            possiblePositions.add(upRight1);
            generatePossiblePosition(x + 1, y - 1, speed - 1.5);
        }
        Position downRight1 = new Position(x + 1, y + 1);
        if (!possiblePositions.contains(downRight1) && (x + 1) <= 12 && (y + 1) <= 10) {
            possiblePositions.add(downRight1);
            generatePossiblePosition(x + 1, y + 1, speed - 1.5);
        }
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

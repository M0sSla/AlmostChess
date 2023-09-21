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
     * Piece speed thats shows max lens path
     */
    protected final Integer speed;

     public Piece(Position position, PieceColor pieceColor, Tier pieceType, Integer speed) throws IllegalAccessException {
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
     * @param speed
     * @return
     */
    public void generatePossiblePosition(Integer x, Integer y, Integer speed) throws IllegalAccessException {
        if (speed < 0) return;
        Position up1 = new Position(x, y - 1);
        // сделать все тоже самое но и для остальных шажков
        if (!possiblePositions.contains(up1)) {
            possiblePositions.add(up1);
            generatePossiblePosition(x, y - 1, speed - 1);
        }
        Position down1 = new Position(x, y + 1);
        Position left1 = new Position(x - 1, y);
        Position right1 = new Position(x + 1, y);

        Position upLeft1 = new Position(x - 1, y - 1);
        Position downLeft1 = new Position(x - 1, y + 1);
        Position upRight1 = new Position(x + 1, y - 1);
        Position downRight1 = new Position(x + 1, y + 1);
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
}

package main.model;

import main.model.entities.Board;
import main.model.entities.Position;

public interface Repository {

    Board move(Position to);
}

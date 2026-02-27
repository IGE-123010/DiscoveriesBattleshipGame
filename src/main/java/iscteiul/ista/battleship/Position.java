package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a position on the Battleship game board.
 *
 * A position is defined by its row and column coordinates within the board.
 * Each position keeps track of:
 * - Whether it is occupied by a ship
 * - Whether it has already been hit by a shot
 *
 * The Position class is a fundamental element of the game model,
 * used by ships, the fleet, and the game logic to manage board state.
 */
public class Position implements IPosition {

    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Creates a new position with the specified coordinates.
     *
     * The position is initially:
     * - Not occupied by any ship
     * - Not hit by any shot
     *
     * @param row the row index of the position
     * @param column the column index of the position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row index of this position.
     *
     * @return the row coordinate
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column index of this position.
     *
     * @return the column coordinate
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Computes a hash code for this position.
     *
     * The hash code is based on the row, column, occupation state,
     * and hit state.
     *
     * @return hash code value for this position
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compares this position with another object for equality.
     *
     * Two positions are considered equal if they share the same
     * row and column coordinates, independently of their state
     * (occupied or hit).
     *
     * @param otherPosition the object to compare with
     * @return true if both objects represent the same board coordinates,
     *         false otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;

        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() &&
                    this.getColumn() == other.getColumn());
        }

        return false;
    }

    /**
     * Determines whether this position is adjacent to another position.
     *
     * Adjacency includes:
     * - Horizontal neighbors
     * - Vertical neighbors
     * - Diagonal neighbors
     *
     * @param other the position to compare with
     * @return true if the positions are adjacent, false otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 &&
                Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as hit by a shot.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indicates whether this position is currently occupied by a ship.
     *
     * @return true if occupied, false otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indicates whether this position has already been hit.
     *
     * @return true if the position was hit, false otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a string representation of this position.
     *
     * @return a formatted string containing row and column values
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}
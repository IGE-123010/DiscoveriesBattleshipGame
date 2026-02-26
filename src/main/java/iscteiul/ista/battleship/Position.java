/**
 *
 */
package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a position on the Battleship game board.
 * 
 * A position is identified by its row and column coordinates.
 * It may be occupied by a ship and may have been hit by a shot.
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Constructs a new Position with the specified row and column.
     * Initially, the position is not occupied and not hit.
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
     * @return the row index
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column index of this position.
     *
     * @return the column index
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Returns a hash code value for this position.
     *
     * @return the hash code based on row and column
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compares this position with another object for equality.
     * Two positions are considered equal if they have the same row and column.
     *
     * @param otherPosition the object to compare
     * @return true if both positions have the same coordinates, false otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Determines whether this position is adjacent to another position.
     * Adjacency includes horizontal, vertical, and diagonal neighbors.
     *
     * @param other the position to compare with
     * @return true if the positions are adjacent, false otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as hit.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indicates whether this position is occupied by a ship.
     *
     * @return true if the position is occupied, false otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indicates whether this position has been hit.
     *
     * @return true if the position has been hit, false otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a string representation of this position.
     *
     * @return a string containing the row and column values
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}

package iscteiul.ista.battleship;

/**
 * Interface that represents a position on the Battleship board.
 *
 * A position is defined by:
 * - A row coordinate
 * - A column coordinate
 *
 * Additionally, a position maintains state information about:
 * - Whether it is occupied by a ship
 * - Whether it has been hit by a shot
 *
 * Implementations are responsible for handling adjacency checks,
 * occupation status, and shot registration.
 *
 * @author fba
 */
public interface IPosition {

    /**
     * Returns the row index of the position.
     *
     * @return the row coordinate
     */
    int getRow();

    /**
     * Returns the column index of the position.
     *
     * @return the column coordinate
     */
    int getColumn();

    /**
     * Compares this position with another object for equality.
     *
     * Two positions are considered equal if they share the same
     * row and column coordinates.
     *
     * @param other the object to compare with
     * @return true if both positions have the same coordinates
     */
    boolean equals(Object other);

    /**
     * Determines whether this position is adjacent to another position.
     *
     * Adjacency typically includes horizontal, vertical,
     * and possibly diagonal neighboring positions,
     * depending on the implementation.
     *
     * @param other the position to compare with
     * @return true if the positions are adjacent
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marks the position as occupied by a ship.
     */
    void occupy();

    /**
     * Registers a shot at this position.
     *
     * If the position is occupied, it becomes marked as hit.
     */
    void shoot();

    /**
     * Checks whether the position is occupied by a ship.
     *
     * @return true if occupied, false otherwise
     */
    boolean isOccupied();

    /**
     * Checks whether the position has been hit by a shot.
     *
     * @return true if the position was hit
     */
    boolean isHit();
}
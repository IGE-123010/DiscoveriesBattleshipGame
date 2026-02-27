package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface that defines the behaviour of a ship in the Battleship game.
 *
 * A ship has:
 * - A category (e.g., galleon, frigate, carrack, etc.)
 * - A fixed size
 * - An orientation (bearing)
 * - A starting position
 * - A collection of board positions that it occupies
 *
 * Implementations are responsible for managing:
 * - Ship placement and occupied positions
 * - Hit detection and sinking state
 * - Boundary calculations
 * - Collision and proximity validation
 */
public interface IShip {

    /**
     * Returns the category of the ship.
     *
     * @return the ship category
     */
    String getCategory();

    /**
     * Returns the size of the ship.
     *
     * The size corresponds to the number of board positions
     * occupied by the ship.
     *
     * @return the ship size
     */
    Integer getSize();

    /**
     * Returns the list of positions occupied by the ship.
     *
     * @return list of occupied positions
     */
    List<IPosition> getPositions();

    /**
     * Returns the initial (starting) position of the ship.
     *
     * @return the starting board position
     */
    IPosition getPosition();

    /**
     * Returns the bearing (orientation) of the ship.
     *
     * @return the ship orientation
     */
    Compass getBearing();

    /**
     * Determines whether the ship is still floating.
     *
     * A ship is considered floating if at least one of its
     * positions has not been hit.
     *
     * @return true if the ship is not completely sunk
     */
    boolean stillFloating();

    /**
     * Returns the smallest row index occupied by the ship.
     *
     * @return the top-most row position
     */
    int getTopMostPos();

    /**
     * Returns the largest row index occupied by the ship.
     *
     * @return the bottom-most row position
     */
    int getBottomMostPos();

    /**
     * Returns the smallest column index occupied by the ship.
     *
     * @return the left-most column position
     */
    int getLeftMostPos();

    /**
     * Returns the largest column index occupied by the ship.
     *
     * @return the right-most column position
     */
    int getRightMostPos();

    /**
     * Checks whether the ship occupies a given position.
     *
     * @param pos the position to check
     * @return true if the ship occupies the position
     */
    boolean occupies(IPosition pos);

    /**
     * Checks whether this ship is too close to another ship.
     *
     * Ships are considered too close if any of their positions
     * are adjacent or overlapping.
     *
     * @param other the other ship to compare with
     * @return true if the ships are adjacent or overlapping
     */
    boolean tooCloseTo(IShip other);

    /**
     * Checks whether this ship is too close to a specific position.
     *
     * @param pos the position to compare with
     * @return true if the ship is adjacent to that position
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Registers a shot at a given position.
     *
     * If the ship occupies that position, it should be marked as hit.
     *
     * @param pos the position where the shot was fired
     */
    void shoot(IPosition pos);
}
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface that defines the behaviour of a fleet in the Battleship game.
 *
 * A fleet represents the collection of ships belonging to a player.
 * It is responsible for:
 * - Managing ship placement on the board
 * - Enforcing board size and fleet size constraints
 * - Preventing collisions or adjacency between ships
 * - Retrieving ships by category
 * - Tracking ships that are still floating
 * - Providing information about ship positions
 *
 * Implementations must ensure that all placement and validation
 * rules are respected according to the game specifications.
 */
public interface IFleet {

    /**
     * The size of the game board (BOARD_SIZE x BOARD_SIZE).
     */
    Integer BOARD_SIZE = 10;

    /**
     * The maximum number of ships allowed in a fleet.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Returns the list of ships currently in the fleet.
     *
     * @return list of ships
     */
    List<IShip> getShips();

    /**
     * Adds a ship to the fleet.
     *
     * The implementation must validate that:
     * - The fleet size limit is not exceeded
     * - The ship is fully inside board boundaries
     * - There are no collisions or adjacency conflicts
     *
     * @param s the ship to add
     * @return true if the ship was successfully added, false otherwise
     */
    boolean addShip(IShip s);

    /**
     * Returns all ships that belong to a given category.
     *
     * @param category the ship category
     * @return list of ships matching the category
     */
    List<IShip> getShipsLike(String category);

    /**
     * Returns all ships that are still floating.
     *
     * A ship is considered floating if it has at least one
     * position that has not been hit.
     *
     * @return list of floating ships
     */
    List<IShip> getFloatingShips();

    /**
     * Returns the ship occupying a given position, if any.
     *
     * @param pos the position to check
     * @return the ship occupying the position, or null if none exists
     */
    IShip shipAt(IPosition pos);

    /**
     * Prints the current status of the fleet.
     *
     * Typically includes all ships, floating ships,
     * and ships grouped by category.
     */
    void printStatus();
}
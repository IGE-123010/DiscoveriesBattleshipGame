package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface that defines the behaviour of a Battleship game session.
 *
 * An implementation of this interface is responsible for:
 * - Processing shots fired by the player
 * - Tracking game statistics (hits, invalid shots, repeated shots, sunk ships)
 * - Providing information about the current game state
 * - Displaying board representations
 *
 * The game interacts with a fleet and manages overall game flow.
 */
public interface IGame {

    /**
     * Fires a shot at a given position.
     *
     * The implementation must validate the shot, check for repetition,
     * update statistics, and determine whether a ship was hit or sunk.
     *
     * @param pos the position to fire at
     * @return the ship that was sunk as a result of the shot,
     *         or null if no ship was sunk
     */
    IShip fire(IPosition pos);

    /**
     * Returns the list of valid shots fired so far.
     *
     * @return list of shot positions
     */
    List<IPosition> getShots();

    /**
     * Returns the number of repeated shots attempted.
     *
     * @return number of repeated shots
     */
    int getRepeatedShots();

    /**
     * Returns the number of invalid shots attempted.
     *
     * @return number of invalid shots
     */
    int getInvalidShots();

    /**
     * Returns the total number of successful hits.
     *
     * @return number of hits
     */
    int getHits();

    /**
     * Returns the number of ships that have been sunk.
     *
     * @return number of sunk ships
     */
    int getSunkShips();

    /**
     * Returns the number of ships that are still floating.
     *
     * @return number of remaining ships
     */
    int getRemainingShips();

    /**
     * Prints a board representation showing all valid shots fired.
     */
    void printValidShots();

    /**
     * Prints a board representation showing the fleet's ship positions.
     */
    void printFleet();
}
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Battleship game session.
 * 
 * This class is responsible for managing the interaction between the player
 * and the fleet, including:
 * - Processing shots
 * - Tracking statistics (hits, sinks, invalid and repeated shots)
 * - Providing information about the current game state
 * - Displaying board representations
 * 
 * The Game class delegates fleet-related logic to the {@link IFleet} 
 * implementation and focuses on game flow control.
 */
public class Game implements IGame {

    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;

    /**
     * Creates a new game instance associated with a fleet.
     *
     * @param fleet the fleet that will be used in this game
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * Fires a shot at a given position.
     *
     * The method validates the shot, checks for repetition, updates
     * statistics, and determines whether a ship has been hit or sunk.
     *
     * @param pos the position to fire at
     * @return the ship that was sunk as a result of this shot,
     *         or null if no ship was sunk
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else {
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the list of valid shots fired so far.
     *
     * @return list of shot positions
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * @return the number of repeated shots attempted
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * @return the number of invalid shots attempted
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * @return the total number of successful hits
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * @return the number of ships that have been sunk
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Returns the number of ships that are still floating.
     *
     * @return remaining ships in the fleet
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Checks whether a shot is within board boundaries.
     *
     * @param pos position to validate
     * @return true if the position is inside the board, false otherwise
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE &&
                pos.getColumn() >= 0 && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Checks whether a shot was previously fired.
     *
     * @param pos position to check
     * @return true if the position was already shot, false otherwise
     */
    private boolean repeatedShot(IPosition pos) {
        for (IPosition p : shots)
            if (p.equals(pos))
                return true;
        return false;
    }

    /**
     * Prints a board representation using the given positions and marker.
     *
     * @param positions positions to be marked
     * @param marker character used to represent those positions
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }
    }

    /**
     * Prints the board showing all valid shots fired.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Prints the board showing ship positions.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}

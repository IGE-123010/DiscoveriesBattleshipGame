package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's fleet in the Battleship game.
 *
 * A Fleet is composed of multiple ships and is responsible for:
 * - Adding ships to the board
 * - Ensuring ships are placed within board boundaries
 * - Preventing collisions or adjacency between ships
 * - Retrieving ships by category
 * - Tracking which ships are still floating
 *
 * The Fleet acts as a container and manager of ship instances,
 * delegating ship-specific logic (such as hit detection and adjacency)
 * to the {@link IShip} implementations.
 */
public class Fleet implements IFleet {

    /**
     * Prints a list of ships to the console.
     *
     * @param ships the list of ships to print
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    private List<IShip> ships;

    /**
     * Constructs an empty fleet.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Returns the list of ships currently in the fleet.
     *
     * @return list of ships
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adds a ship to the fleet if all placement rules are satisfied:
     * <ul>
     *   <li>The fleet size limit is not exceeded</li>
     *   <li>The ship is fully inside the board boundaries</li>
     *   <li>There is no collision or adjacency with existing ships</li>
     * </ul>
     *
     * @param s the ship to add
     * @return true if the ship was successfully added, false otherwise
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Returns all ships that belong to a given category.
     *
     * @param category the ship category
     * @return list of ships matching the category
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Returns all ships that are still floating.
     *
     * A ship is considered floating if it has at least one
     * unhit position.
     *
     * @return list of floating ships
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Returns the ship occupying a given position, if any.
     *
     * @param pos the position to check
     * @return the ship occupying the position, or null if none exists
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Checks whether a ship is completely inside the board boundaries.
     *
     * @param s the ship to validate
     * @return true if the ship is fully inside the board
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 &&
                s.getTopMostPos() >= 0 && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Checks whether placing a ship would cause a collision
     * or adjacency with existing ships.
     *
     * @param s the ship to validate
     * @return true if there is a collision or proximity risk
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Prints the current fleet status.
     *
     * This includes:
     * - All ships
     * - Ships still floating
     * - Ships grouped by category
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Prints all ships belonging to a specific category.
     *
     * @param category the category of ships to print
     */
    public void printShipsByCategory(String category) {
        assert category != null;
        printShips(getShipsLike(category));
    }

    /**
     * Prints only the ships that are still floating.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Prints all ships in the fleet.
     */
    void printAllShips() {
        printShips(ships);
    }
}
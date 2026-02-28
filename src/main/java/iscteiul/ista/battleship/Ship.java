package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents an abstract ship in the Battleship game.
 *
 * A ship has:
 * - A category (galleon, frigate, carrack, caravel, barge)
 * - A bearing (orientation on the board)
 * - An initial position
 * - A list of board positions that it occupies
 *
 * Concrete subclasses define the specific ship type and its size.
 * This class provides common behavior shared by all ships, including:
 * - Position tracking
 * - Hit detection
 * - Adjacency validation
 * - Floating/sunk state verification
 *
 * Ship creation is handled through the factory method
 * {@link #buildShip(String, Compass, Position)}.
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Factory method that creates a concrete ship instance
     * based on the provided category.
     *
     * @param shipKind the ship category identifier
     * @param bearing the ship orientation on the board
     * @param pos the starting position of the ship
     * @return a concrete {@link Ship} instance corresponding to the
     *         given type, or null if the type is invalid
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }

    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;

    /**
     * Constructs a ship with a given category, bearing and initial position.
     *
     * Subclasses are responsible for defining the ship size and populating
     * the list of occupied positions.
     *
     * @param category the ship category
     * @param bearing the orientation of the ship
     * @param pos the starting position on the board
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        this.positions = new ArrayList<>();
    }

    /**
     * Returns the ship category.
     *
     * @return the category identifier
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the list of board positions occupied by the ship.
     *
     * @return list of {@link IPosition} objects representing the ship cells
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Returns the starting position of the ship.
     *
     * @return the initial {@link IPosition}
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Returns the ship bearing (orientation).
     *
     * @return the {@link Compass} direction of the ship
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Determines whether the ship is still floating.
     *
     * A ship is considered floating if at least one of its
     * occupied positions has not been hit.
     *
     * @return true if at least one segment is not hit, false otherwise
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Returns the smallest row index occupied by the ship.
     *
     * @return the topmost row coordinate
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Returns the largest row index occupied by the ship.
     *
     * @return the bottommost row coordinate
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Returns the smallest column index occupied by the ship.
     *
     * @return the leftmost column coordinate
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Returns the largest column index occupied by the ship.
     *
     * @return the rightmost column coordinate
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Checks whether the ship occupies a given position.
     *
     * @param pos the position to check
     * @return true if the ship occupies the given position, false otherwise
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Determines whether this ship is adjacent to another ship.
     *
     * Two ships are considered too close if any of their
     * positions are adjacent.
     *
     * @param other the other ship to compare against
     * @return true if they are adjacent, false otherwise
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Determines whether this ship is adjacent to a given position.
     *
     * @param pos the position to verify
     * @return true if any ship segment is adjacent to the position
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Registers a shot on the ship at the given position.
     *
     * If the position belongs to this ship, the corresponding
     * segment is marked as hit.
     *
     * @param pos the position that was shot
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**
     * Returns a textual representation of the ship.
     *
     * @return a string describing the ship category and orientation
     */
    @Override
    public String toString() {
        return "[" + category + " facing " + bearing + "]";
    }
}

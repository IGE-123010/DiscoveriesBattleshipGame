package iscteiul.ista.battleship;

/**
 * Represents a Barge ship in the Battleship game.
 *
 * A Barge is the smallest type of ship, with a fixed size of 1.
 * It occupies a single position on the game board, independently
 * of its {@link Compass} bearing.
 *
 * This class extends {@link Ship}, inheriting common ship behavior
 * such as hit detection, floating state verification, and position
 * management.
 */
public class Barge extends Ship {

    /**
     * The fixed size of the Barge.
     */
    private static final Integer SIZE = 1;

    /**
     * The display name of this ship type.
     */
    private static final String NAME = "Barca";

    /**
     * Creates a new Barge with the specified bearing and starting position.
     *
     * Since a Barge has size 1, it occupies only the provided position.
     * The bearing does not affect its shape, but is passed to the
     * superclass for consistency with other ship types.
     *
     * @param bearing the orientation of the ship
     * @param pos     the starting position of the ship
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the fixed size of the Barge.
     *
     * @return the size of this ship (1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
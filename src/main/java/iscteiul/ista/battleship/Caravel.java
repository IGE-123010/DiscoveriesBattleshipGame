package iscteiul.ista.battleship;

/**
 * Represents a Caravel ship in the Battleship game.
 *
 * A Caravel is a small ship with a fixed size of 2 positions.
 * It can be oriented according to a given {@link Compass} bearing:
 * - NORTH or SOUTH (vertical placement)
 * - EAST or WEST (horizontal placement)
 *
 * The ship's occupied positions are calculated starting from
 * an initial position and extending in the specified direction.
 *
 * This class extends {@link Ship}, inheriting common ship
 * behavior such as shooting, floating state verification,
 * and position management.
 */
public class Caravel extends Ship {

    /**
     * The fixed size of the Caravel.
     */
    private static final Integer SIZE = 2;

    /**
     * The display name of the ship.
     */
    private static final String NAME = "Caravela";

    /**
     * Creates a Caravel with the specified bearing and starting position.
     *
     * The ship's positions are generated automatically based on:
     * - The given initial position
     * - The direction (bearing)
     * - The fixed size (2)
     *
     * Vertical placement (NORTH or SOUTH):
     * Positions extend along increasing row indices.
     *
     * Horizontal placement (EAST or WEST):
     * Positions extend along increasing column indices.
     *
     * @param bearing the direction in which the Caravel is oriented
     *                (NORTH, SOUTH, EAST, or WEST)
     * @param pos     the starting position of the Caravel
     * @throws NullPointerException     if the bearing is null
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos)
            throws NullPointerException, IllegalArgumentException {

        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(
                            new Position(pos.getRow() + r, pos.getColumn()));
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(
                            new Position(pos.getRow(), pos.getColumn() + c));
                break;

            default:
                throw new IllegalArgumentException(
                        "ERROR! invalid bearing for the caravel");
        }
    }

    /**
     * Returns the fixed size of the Caravel.
     *
     * @return the size of this ship (2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
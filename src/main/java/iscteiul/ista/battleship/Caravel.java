/**
 * Represents a Caravel ship in the Battleship game.
 * <p>
 * A Caravel has a fixed size of 2 positions and can be placed
 * either vertically (NORTH or SOUTH) or horizontally (EAST or WEST)
 * starting from a given initial position.
 * </p>
 * <p>
 * The ship's occupied positions are calculated based on the provided
 * bearing and starting position.
 * </p>
 */
package iscteiul.ista.battleship;

public class Caravel extends Ship {

    /**
     * The fixed size of the Caravel.
     */
    private static final Integer SIZE = 2;

    /**
     * The name of the ship.
     */
    private static final String NAME = "Caravela";

    /**
     * Constructs a Caravel with a given bearing and starting position.
     *
     * @param bearing the direction in which the Caravel is oriented
     *                (NORTH, SOUTH, EAST, or WEST)
     * @param pos     the initial position of the Caravel
     * @throws NullPointerException     if the bearing is null
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Returns the size of the Caravel.
     *
     * @return the fixed size of this ship (2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}

package iscteiul.ista.battleship;

/**
 * Represents a frigate in the Battleship game.
 * <p>
 * A frigate is a type of ship with a fixed size of 4 positions
 * that can be placed in different orientations on the board.
 * </p>
 */
public class Frigate extends Ship {

    /**
     * Fixed size of the frigate on the board.
     */
    private static final Integer SIZE = 4;

    /**
     * Name of the frigate.
     */
    private static final String NAME = "Fragata";

    /**
     * Creates a new frigate with the given orientation and starting position.
     * <p>
     * The frigate occupies four consecutive positions on the board,
     * depending on the provided orientation.
     * </p>
     *
     * @param bearing the orientation of the frigate (NORTH, SOUTH, EAST, or WEST)
     * @param pos the starting board position of the frigate
     *
     * @throws IllegalArgumentException if bearing is invalid
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);

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
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Returns the size of the frigate.
     *
     * @return the number of positions occupied by the frigate
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}

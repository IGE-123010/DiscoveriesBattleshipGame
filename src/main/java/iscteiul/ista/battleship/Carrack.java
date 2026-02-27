package iscteiul.ista.battleship;

/**
 * Represents a Carrack-type ship in the Battleship game.
 *
 * This class is a specialized type of {@link Ship} with a fixed size
 * and name. It manages the ship's positions based on its initial
 * location and bearing (orientation).
 *
 * A Carrack occupies 3 consecutive positions on the board, arranged
 * either vertically (NORTH/SOUTH) or horizontally (EAST/WEST).
 */
public class Carrack extends Ship {

    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Creates a new Carrack ship at a given position and bearing.
     *
     * The constructor calculates all board positions occupied by the ship
     * based on the initial position and the orientation.
     *
     * @param bearing the direction the ship is facing (NORTH, SOUTH, EAST, WEST)
     * @param pos the starting position of the ship's bow (front)
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Returns the size of the Carrack ship.
     *
     * @return the number of board positions occupied by this ship
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}
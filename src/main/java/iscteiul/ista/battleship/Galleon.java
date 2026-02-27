package iscteiul.ista.battleship;

/**
 * Represents the Galleon ship in the Discoveries Battleship Game.
 *
 * A Galleon has a fixed size of 5 positions and a specific geometric
 * configuration depending on its bearing (NORTH, SOUTH, EAST, WEST).
 *
 * The ship's occupied positions are calculated at construction time
 * based on the initial reference position and orientation.
 */
public class Galleon extends Ship {

    private static final Integer SIZE = 5;
    private static final String NAME = "Galeao";

    /**
     * Creates a Galleon with a given orientation and initial position.
     *
     * The bearing determines how the ship's positions are calculated
     * relative to the starting position.
     *
     * @param bearing the orientation of the ship (NORTH, SOUTH, EAST or WEST)
     * @param pos the initial reference position of the ship
     * @throws NullPointerException if the bearing is null
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the size of the Galleon.
     *
     * @return the number of positions occupied by this ship (5)
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Fills ship positions assuming a NORTH orientation.
     *
     * @param pos reference position
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Fills ship positions assuming a SOUTH orientation.
     *
     * @param pos reference position
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Fills ship positions assuming an EAST orientation.
     *
     * @param pos reference position
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Fills ship positions assuming a WEST orientation.
     *
     * @param pos reference position
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}
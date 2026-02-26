/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Represents a Barge ship in the Battleship game.
 * 
 * A Barge is a ship with size 1, occupying a single position
 * on the game board.
 */
public class Barge extends Ship {
    
    /**
     * The fixed size of the Barge.
     */
    private static final Integer SIZE = 1;
    
    /**
     * The name of this ship type.
     */
    private static final String NAME = "Barca";

   /**
     * Constructs a new Barge with the specified bearing and starting position.
     * 
     * Since a Barge has size 1, it occupies only the given position.
     *
     * @param bearing the orientation of the ship
     * @param pos the upper-left (starting) position of the ship
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the Barge.
     *
     * @return the size of the ship (1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}

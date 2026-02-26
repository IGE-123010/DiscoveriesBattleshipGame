/**
 * Enum representing the four cardinal directions (compass bearings) used in the Battleship game.
 *
 * This enum provides a type-safe way to represent directional bearings (North, South, East, West)
 * with support for conversion to/from single character representations. Each direction is associated
 * with a character code for compact representation.
 *
 * <p>Direction mappings:</p>
 * <ul>
 *   <li>NORTH ('n') - North direction</li>
 *   <li>SOUTH ('s') - South direction</li>
 *   <li>EAST ('e') - East direction</li>
 *   <li>WEST ('o') - West direction</li>
 *   <li>UNKNOWN ('u') - Unknown or invalid direction</li>
 * </ul>
 *
 * @author fba
 * @version 1.0
 */
package iscteiul.ista.battleship;

/**
 * Enum representing the four cardinal directions (compass bearings) used in the Battleship game.
 *
 * This enum provides a type-safe way to represent directional bearings (North, South, East, West)
 * with support for conversion to/from single character representations. Each direction is associated
 * with a character code for compact representation.
 *
 * <p>Direction mappings:</p>
 * <ul>
 *   <li>NORTH ('n') - North direction</li>
 *   <li>SOUTH ('s') - South direction</li>
 *   <li>EAST ('e') - East direction</li>
 *   <li>WEST ('o') - West direction</li>
 *   <li>UNKNOWN ('u') - Unknown or invalid direction</li>
 * </ul>
 *
 * @author fba
 * @version 1.0
 */
public enum Compass {
    /** Represents North direction, associated with character 'n'. */
    NORTH('n'),
    /** Represents South direction, associated with character 's'. */
    SOUTH('s'),
    /** Represents East direction, associated with character 'e'. */
    EAST('e'),
    /** Represents West direction, associated with character 'o'. */
    WEST('o'),
    /** Represents an unknown or invalid direction, associated with character 'u'. */
    UNKNOWN('u');

    /** The character code representing this compass direction. */
    private final char c;

    /**
     * Constructs a Compass enum constant with the specified character representation.
     *
     * @param c the character code associated with this compass direction
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Returns the character representation of this compass direction.
     *
     * @return the character code associated with this direction
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the string representation of this compass direction.
     *
     * @return the character code as a String
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts a character to its corresponding Compass enum constant.
     *
     * <p>Valid character mappings are:</p>
     * <ul>
     *   <li>'n' -> NORTH</li>
     *   <li>'s' -> SOUTH</li>
     *   <li>'e' -> EAST</li>
     *   <li>'o' -> WEST</li>
     *   <li>any other character -> UNKNOWN</li>
     * </ul>
     *
     * @param ch the character to convert
     * @return the corresponding Compass enum constant, or UNKNOWN if the character is not recognized
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}

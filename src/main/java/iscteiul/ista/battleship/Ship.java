package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe abstrata que representa um navio no jogo da Batalha Naval.
 *
 * Um navio possui:
 * - uma categoria (galeão, fragata, nau, caravela, barca)
 * - uma orientação (bearing)
 * - uma posição inicial no tabuleiro
 * - um conjunto de posições que ocupa
 *
 * As subclasses concretas definem o tipo específico e o tamanho do navio.
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Método fábrica que cria um navio consoante a categoria indicada.
     *
     * @param shipKind tipo de navio
     * @param bearing orientação do navio
     * @param pos posição inicial
     * @return instância do navio correspondente ou null se o tipo for inválido
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
     * Constrói um navio com categoria, orientação e posição inicial.
     *
     * @param category categoria do navio
     * @param bearing orientação do navio
     * @param pos posição inicial no tabuleiro
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Obtém a categoria do navio.
     *
     * @return categoria do navio
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Obtém a lista de posições ocupadas pelo navio.
     *
     * @return lista de posições
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Obtém a posição inicial do navio.
     *
     * @return posição inicial
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Obtém a orientação do navio.
     *
     * @return orientação (bearing)
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Verifica se o navio ainda está a flutuar.
     *
     * @return true se pelo menos uma das posições não tiver sido atingida
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Obtém a linha mais acima ocupada pelo navio.
     *
     * @return valor da linha superior
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
     * Obtém a linha mais abaixo ocupada pelo navio.
     *
     * @return valor da linha inferior
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
     * Obtém a coluna mais à esquerda ocupada pelo navio.
     *
     * @return valor da coluna esquerda
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
     * Obtém a coluna mais à direita ocupada pelo navio.
     *
     * @return valor da coluna direita
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
     * Verifica se o navio ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return true se o navio ocupar essa posição
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
     * Verifica se este navio está demasiado próximo de outro navio.
     *
     * @param other outro navio
     * @return true se estiverem adjacentes
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
     * Verifica se este navio está adjacente a uma determinada posição.
     *
     * @param pos posição a verificar
     * @return true se estiver adjacente
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Regista um disparo numa posição do navio.
     *
     * @param pos posição onde foi efetuado o disparo
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
     * Representação textual do navio.
     *
     * @return descrição do navio
     */
    @Override
    public String toString() {
        return "[" + category + " facing " + bearing + "]";
    }
}

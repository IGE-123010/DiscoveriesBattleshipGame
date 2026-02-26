package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a frota de um jogador.
 *
 * A frota é composta por vários navios e é responsável por:
 * - adicionar navios ao tabuleiro
 * - verificar colisões
 * - obter navios por categoria
 * - verificar quais ainda estão a flutuar
 */
public class Fleet implements IFleet {

    /**
     * Imprime no ecrã uma lista de navios.
     *
     * @param ships lista de navios a imprimir
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    private List<IShip> ships;

    /**
     * Constrói uma frota vazia.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Obtém a lista de navios da frota.
     *
     * @return lista de navios
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um navio à frota se:
     * - não ultrapassar o tamanho máximo
     * - estiver dentro do tabuleiro
     * - não houver risco de colisão
     *
     * @param s navio a adicionar
     * @return true se o navio foi adicionado com sucesso
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Obtém todos os navios de uma determinada categoria.
     *
     * @param category categoria pretendida
     * @return lista de navios dessa categoria
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Obtém todos os navios que ainda não foram completamente afundados.
     *
     * @return lista de navios ainda a flutuar
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Obtém o navio que ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return navio que ocupa essa posição ou null se não existir
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um navio está completamente dentro dos limites do tabuleiro.
     *
     * @param s navio a verificar
     * @return true se estiver dentro do tabuleiro
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 &&
                s.getTopMostPos() >= 0 && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se existe risco de colisão ou proximidade com outros navios.
     *
     * @param s navio a verificar
     * @return true se houver risco de colisão
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Mostra o estado atual da frota.
     * Imprime todos os navios e organiza-os por categoria.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios de uma determinada categoria.
     *
     * @param category categoria dos navios a imprimir
     */
    public void printShipsByCategory(String category) {
        assert category != null;
        printShips(getShipsLike(category));
    }

    /**
     * Imprime apenas os navios que ainda estão a flutuar.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime todos os navios da frota.
     */
    void printAllShips() {
        printShips(ships);
    }
}
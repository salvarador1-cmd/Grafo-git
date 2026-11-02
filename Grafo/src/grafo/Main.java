package grafo;

/**
 *
 * @author Samuel Alvarado
 */
public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");
        g.agregarArista("C", "D");
        g.mostrar();
        g.bfs("A");
        g.dfs("A");
        g.eliminarArista("B", "D");
        g.eliminarVertice("C");
        g.mostrar();

    }
}

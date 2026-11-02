
package grafo;
/**
 *
 * @author Samuel Alvarado
 */
import java.util.*;
public class Grafo {
    private final Map<String, List<String>> adyacencia = new LinkedHashMap<>();
    public void agregarVertice(String v) {
        adyacencia.putIfAbsent(v, new ArrayList<>());
    }
    public void agregarArista(String a, String b) {
        agregarVertice(a);
        agregarVertice(b);
        adyacencia.get(a).add(b);
        adyacencia.get(b).add(a);
    }
    public void mostrar() {
        for (Map.Entry<String, List<String>> e : adyacencia.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
public void eliminarArista(String a, String b) {
        if (adyacencia.containsKey(a)) adyacencia.get(a).remove(b);
        if (adyacencia.containsKey(b)) adyacencia.get(b).remove(a);
    }
    public void eliminarVertice(String v) {
        if (!adyacencia.containsKey(v)) return;
        for (String vecino : new ArrayList<>(adyacencia.get(v))) {
            adyacencia.get(vecino).remove(v);
        }
        adyacencia.remove(v);
    }
    public void bfs(String inicio) {
        if (!adyacencia.containsKey(inicio)) return;
        Set<String> visitados = new LinkedHashSet<>();
        Queue<String> cola = new LinkedList<>();
        visitados.add(inicio);
         cola.add(inicio);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");
            for (String vecino : adyacencia.get(actual)) {
                if (visitados.add(vecino)) cola.add(vecino);
            }
        }
        System.out.println();
    }
    public void dfs(String inicio) {
        if (!adyacencia.containsKey(inicio)) return;
        dfs(inicio, new HashSet<>());
        System.out.println();
    }
    private void dfs(String actual, Set<String> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");
        for (String vecino : adyacencia.get(actual)) {
            if (!visitados.contains(vecino)) dfs(vecino, visitados);
        }
    }
}
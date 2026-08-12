import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoLista {
    private final Map<String, List<String>> listaAdyacencia = new HashMap<>();

    public void agregarVertice(String v) {
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException("El nombre del vértice no puede estar vacío.");
        }

        listaAdyacencia.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(String v1, String v2) {
        if (v1 == null || v2 == null || v1.isBlank() || v2.isBlank()) {
            throw new IllegalArgumentException("Los vértices no pueden estar vacíos.");
        }

        agregarVertice(v1);
        agregarVertice(v2);

        if (!listaAdyacencia.get(v1).contains(v2)) {
            listaAdyacencia.get(v1).add(v2);
        }

        if (!listaAdyacencia.get(v2).contains(v1)) {
            listaAdyacencia.get(v2).add(v1);
        }
    }

    public void mostrarGrafo() {
        System.out.println("Lista de adyacencia:");

        for (String vertice : listaAdyacencia.keySet()) {
            System.out.println(vertice + " -> " + listaAdyacencia.get(vertice));
        }
    }

    public int obtenerGrado(String vertice) {
        if (!listaAdyacencia.containsKey(vertice)) {
            return -1;
        }

        return listaAdyacencia.get(vertice).size();
    }

    public boolean esConexo() {
        if (listaAdyacencia.isEmpty()) {
            return true;
        }

        String inicio = listaAdyacencia.keySet().iterator().next();
        List<String> visitados = new ArrayList<>();

        dfs(inicio, visitados);

        return visitados.size() == listaAdyacencia.size();
    }

    private void dfs(String vertice, List<String> visitados) {
        visitados.add(vertice);

        for (String vecino : listaAdyacencia.get(vertice)) {
            if (!visitados.contains(vecino)) {
                dfs(vecino, visitados);
            }
        }
    }
}

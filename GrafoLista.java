import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoLista {
    private final Map<String, List<String>> listaAdyacencia =
        new HashMap<>();

    public void agregarVertice(String v) {
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException(
                "El vertice no puede estar vacio."
            );
        }

        if (!listaAdyacencia.containsKey(v)) {
            listaAdyacencia.put(v, new ArrayList<>());
        }
    }

    public void agregarArista(String v1, String v2) {
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
        for (String v : listaAdyacencia.keySet()) {
            System.out.println(
                v + " -> " + listaAdyacencia.get(v)
            );
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

        String inicio =
            listaAdyacencia.keySet().iterator().next();

        List<String> visitados = new ArrayList<>();
        dfs(inicio, visitados);

        return visitados.size() == listaAdyacencia.size();
    }

    private void dfs(String v, List<String> visitados) {
        visitados.add(v);

        for (String vecino : listaAdyacencia.get(v)) {
            if (!visitados.contains(vecino)) {
                dfs(vecino, visitados);
            }
        }
    }
}

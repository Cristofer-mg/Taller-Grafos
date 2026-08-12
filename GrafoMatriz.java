public class GrafoMatriz {
    private int[][] matriz;
    private int cantidadVertices;

    public GrafoMatriz() {
        matriz = new int[0][0];
        cantidadVertices = 0;
    }

    public void agregarVertice() {
        int[][] nuevaMatriz = new int[cantidadVertices + 1][cantidadVertices + 1];

        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                nuevaMatriz[i][j] = matriz[i][j];
            }
        }

        matriz = nuevaMatriz;
        cantidadVertices++;
    }

    public void agregarArista(int v1, int v2) {
        if (!verticeValido(v1) || !verticeValido(v2)) {
            throw new IllegalArgumentException("Los vértices indicados no son válidos.");
        }

        matriz[v1 - 1][v2 - 1] = 1;
        matriz[v2 - 1][v1 - 1] = 1;
    }

    public boolean existeArista(int v1, int v2) {
        if (!verticeValido(v1) || !verticeValido(v2)) {
            return false;
        }

        return matriz[v1 - 1][v2 - 1] == 1;
    }

    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia:");

        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int obtenerCantidadVertices() {
        return cantidadVertices;
    }

    private boolean verticeValido(int vertice) {
        return vertice >= 1 && vertice <= cantidadVertices;
    }
}

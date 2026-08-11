public class GrafoMatriz {
    private int[][] matriz;
    private int cantidadVertices;

    public GrafoMatriz(int cantidadVertices) {
        if (cantidadVertices <= 0) {
            throw new IllegalArgumentException("La cantidad de vertices debe ser mayor que 0.");
        }
        this.cantidadVertices = cantidadVertices;
        matriz = new int[cantidadVertices][cantidadVertices];
    }

    public void agregarArista(int v1, int v2) {
        if (!verticeValido(v1) || !verticeValido(v2)) {
            System.out.println("Error: vertice invalido.");
            return;
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

    private boolean verticeValido(int vertice) {
        return vertice >= 1 && vertice <= cantidadVertices;
    }
}

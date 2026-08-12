public class GrafoMatriz {
    private int[][] matriz;
    private int cantidadVertices;

    public GrafoMatriz(int cantidadVertices) {
        if (cantidadVertices < 0) {
            throw new IllegalArgumentException(
                "La cantidad de vertices no puede ser negativa."
            );
        }

        this.cantidadVertices = cantidadVertices;
        this.matriz = new int[cantidadVertices][cantidadVertices];
    }

    public void agregarVertice() {
        int[][] nuevaMatriz =
            new int[cantidadVertices + 1][cantidadVertices + 1];

        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                nuevaMatriz[i][j] = matriz[i][j];
            }
        }

        matriz = nuevaMatriz;
        cantidadVertices++;
    }

    public void agregarArista(int v1, int v2) {
        validarVertice(v1);
        validarVertice(v2);

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

    private void validarVertice(int vertice) {
        if (!verticeValido(vertice)) {
            throw new IllegalArgumentException(
                "El vertice " + vertice + " no existe."
            );
        }
    }
}

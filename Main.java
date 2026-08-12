public class Main {
    public static void main(String[] args) {

        System.out.println("===== EJERCICIO 1: MATRIZ DE ADYACENCIA =====");

        GrafoMatriz gm = new GrafoMatriz();

        // Agregar los cuatro vértices solicitados.
        gm.agregarVertice();
        gm.agregarVertice();
        gm.agregarVertice();
        gm.agregarVertice();

        // Grafo: 1-2, 2-3, 3-4, 4-1, 1-3.
        gm.agregarArista(1, 2);
        gm.agregarArista(2, 3);
        gm.agregarArista(3, 4);
        gm.agregarArista(4, 1);
        gm.agregarArista(1, 3);

        gm.mostrarMatriz();

        System.out.println("¿2 y 4 están conectados? "
                + gm.existeArista(2, 4));

        System.out.println("¿1 y 3 están conectados? "
                + gm.existeArista(1, 3));


        System.out.println("\n===== EJERCICIO 2: LISTA DE ADYACENCIA =====");

        GrafoLista gl = new GrafoLista();

        // Grafo: X-Y, Y-Z, Z-W, W-X, Y-W.
        gl.agregarArista("X", "Y");
        gl.agregarArista("Y", "Z");
        gl.agregarArista("Z", "W");
        gl.agregarArista("W", "X");
        gl.agregarArista("Y", "W");

        gl.mostrarGrafo();

        System.out.println("Grado del vértice Y: "
                + gl.obtenerGrado("Y"));


        System.out.println("\n===== EJERCICIO 3: CONECTIVIDAD =====");

        System.out.println("¿El grafo es conexo? "
                + gl.esConexo());
    }
}

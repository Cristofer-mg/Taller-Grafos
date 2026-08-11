public class Main {
    public static void main(String[] args) {
        // Ejercicio 1: Grafo mediante matriz de adyacencia
        GrafoMatriz gm = new GrafoMatriz(4);

        gm.agregarArista(1, 2);
        gm.agregarArista(2, 3);
        gm.agregarArista(3, 4);
        gm.agregarArista(4, 1);
        gm.agregarArista(1, 3);

        gm.mostrarMatriz();

        System.out.println("¿Existe arista entre 2 y 4? " + gm.existeArista(2, 4));
        System.out.println("¿Existe arista entre 1 y 3? " + gm.existeArista(1, 3));

        System.out.println();

        // Ejercicio 2 y 3: Grafo mediante lista de adyacencia
        GrafoLista gl = new GrafoLista();

        gl.agregarArista("X", "Y");
        gl.agregarArista("Y", "Z");
        gl.agregarArista("Z", "W");
        gl.agregarArista("W", "X");
        gl.agregarArista("Y", "W");

        gl.mostrarGrafo();

        System.out.println("Grado de Y: " + gl.obtenerGrado("Y"));
        System.out.println("Grado de A: " + gl.obtenerGrado("A"));
        System.out.println("¿El grafo es conexo? " + gl.esConexo());
    }
}

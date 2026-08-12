public class Main {
    public static void main(String[] args) {

        // EJERCICIO 1: GRAFO CON MATRIZ DE ADYACENCIA
        System.out.println("===== EJERCICIO 1 =====");

        GrafoMatriz gm = new GrafoMatriz(4);

        gm.agregarArista(1, 2);
        gm.agregarArista(2, 3);
        gm.agregarArista(3, 4);
        gm.agregarArista(4, 1);
        gm.agregarArista(1, 3);

        gm.mostrarMatriz();

        System.out.println(
            "¿Existe arista entre 2 y 4? "
            + gm.existeArista(2, 4)
        );

        // EJERCICIO 2: LISTA DE ADYACENCIA
        System.out.println("\n===== EJERCICIO 2 =====");

        GrafoLista gl = new GrafoLista();

        gl.agregarVertice("X");
        gl.agregarVertice("Y");
        gl.agregarVertice("Z");
        gl.agregarVertice("W");

        gl.agregarArista("X", "Y");
        gl.agregarArista("Y", "Z");
        gl.agregarArista("Z", "W");
        gl.agregarArista("W", "X");
        gl.agregarArista("Y", "W");

        gl.mostrarGrafo();

        System.out.println(
            "Grado de Y: " + gl.obtenerGrado("Y")
        );

        // EJERCICIO 3: GRAFO CONEXO
        System.out.println("\n===== EJERCICIO 3 =====");

        System.out.println(
            "¿El grafo es conexo? " + gl.esConexo()
        );

        // VALIDACIONES
        System.out.println("\n===== VALIDACIONES =====");

        System.out.println(
            "existeArista(1,3) = " + gm.existeArista(1, 3)
        );

        System.out.println(
            "existeArista(2,4) = " + gm.existeArista(2, 4)
        );

        System.out.println(
            "obtenerGrado(Y) = " + gl.obtenerGrado("Y")
        );

        System.out.println(
            "obtenerGrado(A) = " + gl.obtenerGrado("A")
        );

        System.out.println(
            "esConexo() = " + gl.esConexo()
        );
    }
}

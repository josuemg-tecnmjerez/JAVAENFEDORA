/*
 * ============================================================================
 * ANÁLISIS DE ALGORITMOS - NOTACIÓN BIG-O
 * ============================================================================
 * A continuación se muestran los ejemplos basados en los análisis de los videos
 * proporcionados. La complejidad se obtiene analizando cómo crece el tiempo de
 * ejecución a medida que aumenta el tamaño de la entrada (N).
 *
 * 1. O(1) - Tiempo Constante:
 *    - ¿Cómo se obtiene?: No hay ciclos. El algoritmo realiza un número fijo
 *      de operaciones básicas (asignaciones, acceso a índices, matemáticas).
 *      Fórmula: c (constante) -> O(1)
 *
 * 2. O(N) - Tiempo Lineal:
 *    - ¿Cómo se obtiene?: El algoritmo tiene un ciclo simple que itera
 *      proporcionalmente al tamaño de N. Si N es 100, se hacen ~100 operaciones.
 *      Fórmula: c * N -> O(N)
 *
 * 3. O(N^2) - Tiempo Cuadrático:
 *    - ¿Cómo se obtiene?: Existen dos bucles anidados. El bucle externo se
 *      ejecuta N veces y, por cada vez, el interno se ejecuta N veces.
 *      Fórmula: N * N -> O(N^2)
 *
 * 4. O(log N) - Tiempo Logarítmico:
 *    - ¿Cómo se obtiene?: En cada paso de la iteración o recursión, la cantidad
 *      de elementos restantes se divide (generalmente a la mitad, como en la
 *      búsqueda binaria).
 * ============================================================================
 */

public class T1_A10_AcevedoSandovalSalvador {

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("--- Ejemplo O(1) ---");
        imprimirPrimerElemento(arreglo);

        System.out.println("\n--- Ejemplo O(N) ---");
        buscarElementoLineal(arreglo, 7);

        System.out.println("\n--- Ejemplo O(N^2) ---");
        imprimirPares(arreglo);

        System.out.println("\n--- Ejemplo O(log N) ---");
        busquedaBinaria(arreglo, 8);
    }

    /**
     * Complejidad: O(1) - Constante
     * Solo accede a una posición de memoria, sin importar si el arreglo
     * tiene 10 o 1,000,000 de elementos. El tiempo es el mismo.
     */
    public static void imprimirPrimerElemento(int[] arr) {
        if (arr.length > 0) {
            System.out.println("El primer elemento es: " + arr[0]); // O(1)
        }
    }

    /**
     * Complejidad: O(N) - Lineal
     * (Equivalente al Insertion Search/Búsqueda Lineal mencionada en los videos)
     * Recorre el arreglo de tamaño N. En el peor de los casos, tiene que
     * iterar N veces para encontrar (o no encontrar) el elemento.
     */
    public static void buscarElementoLineal(int[] arr, int objetivo) {
        for (int i = 0; i < arr.length; i++) { // Bucle de 0 a N -> O(N)
            if (arr[i] == objetivo) {
                System.out.println("Elemento " + objetivo + " encontrado en el índice: " + i);
                return;
            }
        }
        System.out.println("Elemento no encontrado.");
    }

    /**
     * Complejidad: O(N^2) - Cuadrática
     * Recorre un arreglo de tamaño N dentro de otro recorrido de tamaño N.
     * Operaciones = N * N = N^2. Típico en Bubble Sort o combinaciones pares.
     */
    public static void imprimirPares(int[] arr) {
        int contadorIteraciones = 0;
        // Bucle externo: N veces
        for (int i = 0; i < arr.length; i++) {
            // Bucle interno: N veces por cada i
            for (int j = 0; j < arr.length; j++) {
                contadorIteraciones++;
            }
        }
        System.out.println("Total de combinaciones generadas (N * N): " + contadorIteraciones);
    }

    /**
     * Complejidad: O(log N) - Logarítmica
     * Búsqueda Binaria. El tamaño de los datos de entrada se reduce a la mitad
     * en cada ciclo (N, N/2, N/4...). Es muchísimo más rápido que O(N).
     */
    public static void busquedaBinaria(int[] arr, int objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) { // La ventana de búsqueda se divide en 2 -> O(log N)
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == objetivo) {
                System.out.println("Búsqueda binaria encontró el " + objetivo + " en el índice: " + medio);
                return;
            }
            if (arr[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        System.out.println("Elemento no encontrado.");
    }
}

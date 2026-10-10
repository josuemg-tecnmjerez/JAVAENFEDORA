public class DEFECTIVO {

    // Método principal para evaluar la clasificación del número
    public static String clasificarNumero(int numero) {
        if (numero <= 0) {
            return "El número debe ser un entero positivo.";
        }

        int suma = sumaDivisores(numero, 1);

        if (suma == numero) {
            return "Perfecto";
        } else if (suma > numero) {
            return "Abundante";
        } else {
            return "Defectivo";
        }
    }

    // Función recursiva que calcula la suma de los divisores propios
    private static int sumaDivisores(int numero, int divisorActual) {
        // Caso base: no existen divisores propios mayores a (numero / 2)
        if (divisorActual > numero / 2) {
            return 0;
        }

        // Si es divisor exacto, se suma y pasa al siguiente divisor
        if (numero % divisorActual == 0) {
            return divisorActual + sumaDivisores(numero, divisorActual + 1);
        } else {
            return sumaDivisores(numero, divisorActual + 1);
        }
    }

    public static void main(String[] args) {
        int[] ejemplos = {6, 12, 8};

        for (int num : ejemplos) {
            System.out.println("El número " + num + " es: " + clasificarNumero(num));
        }
    }
}
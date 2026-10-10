public class ROTARALAIZQUIERDA {
    public class RotacionRecursiva {

    // Método principal para iniciar la rotación
    public static int rotar(int numero, int n) {
        int totalDigitos = contarDigitos(Math.abs(numero));
        if (totalDigitos <= 1) return numero;

        // Simplificar 'n' en caso de ser mayor al número de dígitos o negativo
        n = n % totalDigitos;
        if (n < 0) {
            n += totalDigitos;
        }

        return rotarRecursivo(numero, n, totalDigitos);
    }

    // Función recursiva que realiza las 'n' rotaciones
    private static int rotarRecursivo(int numero, int n, int totalDigitos) {
        // Caso base: si ya no quedan rotaciones pendientes, retorna el número
        if (n == 0) {
            return numero;
        }

        int ultimoDigito = numero % 10;
        int resto = numero / 10;
        
        // Mueve el último dígito a la primera posición
        int numeroRotado = ultimoDigito * (int) Math.pow(10, totalDigitos - 1) + resto;

        // Llamada recursiva reduciendo n en 1
        return rotarRecursivo(numeroRotado, n - 1, totalDigitos);
    }

    // Función recursiva para contar los dígitos del número
    public static int contarDigitos(int numero) {
        if (numero < 10) {
            return 1;
        }
        return 1 + contarDigitos(numero / 10);
    }

    public static void main(String[] args) {
        int numero = 12345;
        int n = 2;

        int resultado = rotar(numero, n);

        System.out.println("Número original: " + numero);
        System.out.println("Rotado " + n + " veces a la derecha: " + resultado);
    }
}
}

        import java.util.Scanner;

public class INVERTIR {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("AHORA EL PROGRAMA QUE CALCULA LA INVERSION DE UN NUMERO");
        System.out.println("Un numero para invertir?");

        int numero = sc.nextInt();
        invertir(numero);
    }

    static void invertir(int numero) {
        if (numero < 10) {
            System.out.print(numero);
            return;
        }

        System.out.print(numero % 10);
        invertir(numero / 10);
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, BIENVENIDO AL PROGRAMA DE FACTORIL DE UN NUMERO"); //SALUDO
        Scanner sc = new Scanner(System.in); //Llamada

        System.out.println("Que numero quieres sacar su factorial?"); //Pedir numero
        int num = sc.nextInt(); //GUARDAR

        int factorial = 1; //Declarar variable 

        for(int i = num ; i >= 1; i--){
            factorial = factorial * i; //Formula

            System.out.println("El factorial de " + num + " * " + i + "; " + factorial); //Imprimir

        }


        System.out.println("AHORA EL PROGRAMA QUE CALCULA LA DIVICION DE UN NUMERO MEDIANTE RESTAS SUCESIVAS");

        System.out.println("Un numero?");
        int dividendo = sc.nextInt();
        System.out.println("Con que numero lo quieres dividir(solo enteros");
        int divisor = sc.nextInt(); //Divisor


        int cociente = 0;
        if(divisor == 0){
            System.out.println("No se puede dividir entre 0;");
        }

        else{  
             while(divisor <= dividendo){

                 System.out.println("El numero divisor es "+ divisor + " menos el dividendo "+ dividendo + " = ");

                 dividendo = dividendo - divisor;
                 System.out.println(dividendo);


                cociente++;

        }

        

    
    









 

    
    sc.close();
    
    
    
    
    
    }   
    }}

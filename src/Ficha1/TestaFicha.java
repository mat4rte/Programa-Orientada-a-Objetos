package Ficha1;
import java.util.Scanner;

public class TestaFicha {

    private static Ficha1 f;
    private static Scanner is;

    public static void exercicio1(){
        Ficha1 f = new Ficha1();
        Scanner is = new Scanner(System.in);
        System.out.print("Temperatura em graus C:");
        double tempC = is.nextDouble();
        double tempF = f.celsiusParaFarenheit(tempC);
        System.out.println("Em F é: " + tempF);
        is.close();
    }

    public static void exercicio2(){
        Ficha1 f = new Ficha1();
        Scanner is = new Scanner(System.in);
        System.out.println("Indica 2 números:");
        int n1 = is.nextInt();
        int n2 = is.nextInt();
        int max = f.maximoNumeros(n1,n2);
        System.out.println("O maior é " + max);
        is.close();
    }

    public static void exercicio3(){
        Ficha1 f = new Ficha1();
        Scanner is = new Scanner(System.in);
        System.out.println("Indica um nome e o seu saldo:");
        String nome = is.nextLine();
        double saldo = is.nextDouble();
        System.out.println(f.criaDescricaoConta(nome, saldo));
        is.close();
    }

    public static void exercicio4(){
        Ficha1 f = new Ficha1();
        Scanner is = new Scanner(System.in);
        System.out.println("Indica um valor e uma taxa de conversao");
        double valor = is.nextDouble();
        double taxa = is.nextDouble();
        double novo_valor = f.eurosParaLibras(valor, taxa);
        System.out.println("O valor é: " + novo_valor);
        is.close();
    }

    public static void exercicio5(){
        Ficha1 f = new Ficha1();
        Scanner is = new Scanner(System.in);
        System.out.println("Indique 2 números");
        int n1 = is.nextInt();
        int n2 = is.nextInt();
        System.out.println(f.decreMedia(n1, n2));
        is.close();
    }

    public static void exercicio6(){
        Ficha1 f = new Ficha1();
        Scanner is = new Scanner(System.in);
        System.out.println("Indique um número");
        int num = is.nextInt();
        long fact = f.factorial(num);
        System.out.println("O factorial de " + num + " é " + fact);
        is.close();
    }

    public static void exercicio7(){
        System.out.println("Factorial de 5000 demorou" + f.tempoGasto());
    }


    public static void main(String[] args){
        is = new Scanner (System.in);

        int alinea = is.nextInt();
        switch (alinea) {
            case 1:
                exercicio1();
                break;
            case 2:
                exercicio2();
                break;
            case 3:
                exercicio3();
                break;
            case 4:
                exercicio4();
                break;
            case 5:
                exercicio5();
                break;
            case 6:
                exercicio6();
                break;
            case 7:
                exercicio7();
                break;
            default:
                break;
        }
        is.close();
    }
}
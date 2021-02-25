package Ficha1;
import java.time.LocalDateTime;

public class Ficha1 {

    //1
    public double celsiusParaFarenheit(double graus){
        return graus*1.8+32;
    }

    //Ex2
    public int maximoNumeros(int a, int b){
        int maior = a;
        if(b > a) maior = b;
        return maior;
    }

    //Ex3

    public String criaDescricaoConta(String nome, double saldo){
        return nome + " tem " + saldo;
    }

    //Ex4

    public double eurosParaLibras(double valor, double taxaConversao){
        return valor*taxaConversao;
    }

    //Ex5

    public String decreMedia(int n1, int n2){
        if(n1 > n2) return n2 + ", " + n1 + "\nMédia: " + ((n1+n2)/2);
        else return n1 + ", " + n2 + "\nMédia: " + ((n1+n2)/2);
    }

    //Ex6
    public long factorial(int num){

        long fact = 1;
        for(int i = 1; i <= num; i++)
            fact *= i;
        return fact;
    }

    //Ex 7
    public long tempoGasto(){

        long antes = System.currentTimeMillis();
        this.factorial(5000);
        long depois = System.currentTimeMillis();
        return depois-antes;
    }
}
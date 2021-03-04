package Ex1;

import java.util.Scanner;

public class TestaEx1 {
    public static void main(String[] args){
        Ex1 f = new Ex1();
        Scanner sc = new Scanner ( System . in ) ;
        int n;
        System . out . print (" Número de inteiros a ler ?: ");
        n = sc.nextInt ();

        int [] valores = new int [n];  //cria array com tamanho n

        for(int i = 0; i < n ; i ++) {
            System.out.print("Valor da posição " + i + ": ");
            valores[i] = sc.nextInt();
        }

        System.out.print("O minimo é: " + f.minimo(valores));
        sc.close();
    }
}

import java.time.LocalDate;
import java.util.ArrayList;

public class TestaEncomendaEficiente {

    public static void main(String[] args) {
        EncomendaEficiente encomenda1 = new EncomendaEficiente("Paulo Bento", 030201000,
                "Banco da Seleção Portuguesa 2013", 1, LocalDate.now(), new ArrayList<LinhaEncomenda>());

        LinhaEncomenda linha1 = new LinhaEncomenda("3152120", "Tazos", 35, 2, 5, 10);
        LinhaEncomenda linha2 = new LinhaEncomenda("3152152", "Discos do Toy", 12, 6, 3, 10);

        encomenda1.adicionaLinha(linha1);
        encomenda1.adicionaLinha(linha2);

        System.out.println("\nEncomenda: " + encomenda1.toString() + "\n");

        System.out.println("Linha 1: " + linha1.toString() + "\n");
        System.out.println("Linha 2: " + linha2.toString() + "\n");

        System.out.println(encomenda1.calculaValorTotal());
        System.out.println(encomenda1.calculaValorDesconto());
        System.out.println(encomenda1.existeProdutoEncomenda("3152120"));
        encomenda1.removeProduto("3152152");

        System.out.println("\nEncomenda: " + encomenda1.toString() + "\n");

    }

}

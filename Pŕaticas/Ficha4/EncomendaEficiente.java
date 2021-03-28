import java.time.LocalDate;
import java.util.ArrayList;

public class EncomendaEficiente {

    private String nomCliente;
    private int numFiscal;
    private String morada;
    private int numEncomenda;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;

    // diag. classe
    // contrutores
    // getters, setters
    // equals, toString, clone

    // resoluções dos excs
    // em grupo comentario no ficheiro grpo
    // Classes LinhaEncomenda, EncomendaEficiente, TesteEncomenda, Diag.Classes em
    // zip

    // Construtores

    public EncomendaEficiente() {
        this.nomCliente = "";
        this.numFiscal = -1;
        this.morada = "";
        this.numEncomenda = -1;
        this.data = LocalDate.now();
        this.linhas = new ArrayList<LinhaEncomenda>();
    }

    public EncomendaEficiente(String nomeCliente, int novoFiscal, String novaMorada, int novoNumEnc, LocalDate novaData,
            ArrayList<LinhaEncomenda> novaLinha) {
        this.nomCliente = nomeCliente;
        this.numFiscal = novoFiscal;
        this.morada = novaMorada;
        this.numEncomenda = novoNumEnc;
        this.data = novaData;
        this.setLinhas(novaLinha);
    }

    public EncomendaEficiente(EncomendaEficiente ee) {
        this.nomCliente = ee.getNomCliente();
        this.numFiscal = ee.getNumFiscal();
        this.morada = ee.getMorada();
        this.numEncomenda = ee.getNumEncomenda();
        this.data = ee.getData();
        this.linhas = ee.getLinhas();
    }

    // Getters e Setters

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getNumFiscal() {
        return numFiscal;
    }

    public void setNumFiscal(int numFiscal) {
        this.numFiscal = numFiscal;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumEncomenda() {
        return numEncomenda;
    }

    public void setNumEncomenda(int numEncomenda) {
        this.numEncomenda = numEncomenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<LinhaEncomenda> getLinhas() {
        ArrayList<LinhaEncomenda> le = new ArrayList<>();
        for (LinhaEncomenda l : this.linhas) {
            le.add(l.clone());
        }
        return le;
    }

    public void setLinhas(ArrayList<LinhaEncomenda> nlinhas) {
        this.linhas = new ArrayList<>();
        for (LinhaEncomenda l : linhas) {
            this.linhas.add(l.clone());
        }
    }

    // Clone, toString, equals

    public EncomendaEficiente clone() {
        return new EncomendaEficiente(this);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Nome de cliente : ").append(nomCliente);
        sb.append("\nNIF : ").append(numFiscal);
        sb.append("\nMorada : ").append(morada);
        sb.append("\nNúmero de encomenda : ").append(numEncomenda);
        sb.append("\nData : ").append(data.toString());
        sb.append("\nLinhas : ").append(linhas.toString());
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        EncomendaEficiente n = (EncomendaEficiente) o;
        return this.numFiscal == n.numFiscal && this.numEncomenda == n.numEncomenda
                && this.nomCliente.equals(n.nomCliente) && this.morada.equals(n.morada) && this.data.equals(n.data)
                && this.linhas.equals(n.linhas);
    }

    // B)
    // ii)
    public double calculaValorTotal() {
        double total = 0;
        for (LinhaEncomenda l : this.linhas) {
            total += l.calculaValorLinhaEnc();
        }
        return total;
    }

    // iii)
    public double calculaValorDesconto() {
        double totalDes = 0;
        for (LinhaEncomenda l : this.linhas) {
            totalDes += l.calculaValorDesconto();
        }
        return totalDes;
    }

    // iv)
    public int numeroTotalProdutos() {
        int total = 0;
        for (LinhaEncomenda l : this.linhas) {
            total += l.getQuantidade();
        }
        return total;
    }

    // v)
    public boolean existeProdutoEncomenda(String refProduto) {
        for (LinhaEncomenda l : this.linhas) {
            if (l.getReferencia().equals(refProduto))
                return true;
        }
        return false;
    }

    // vi)
    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha.clone());
    }

    // vii)
    public void removeProduto(String codProd) {
        this.linhas.removeIf(enc -> enc.getReferencia().equals(codProd));
    }
}
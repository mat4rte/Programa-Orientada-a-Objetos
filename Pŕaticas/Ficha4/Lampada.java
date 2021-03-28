public class Lampada {

    public enum Modo {
        ON, OFF, ECO
    }

    // ligado, desligado ou eco
    private Modo modo;
    // consumo ligado
    private double co;
    // consumo eco
    private double ce;
    // consumo total
    private double cTotal;
    // inicio do estado mais recente
    private double inicioEstado; // System.currentTimeMillis()

    public Lampada() {
        modo = Modo.OFF;
        co = 2;
        ce = 1;
        cTotal = 0;
        inicioEstado = System.currentTimeMillis();
    }

    public Lampada(Modo m, double nco, double nce, double ncTotal, double ninicioEstado) {
        modo = m;
        co = nco;
        ce = nce;
        cTotal = ncTotal;
        inicioEstado = ninicioEstado;
    }

    public Lampada(Lampada l) {
        modo = l.getModo();
        co = l.getCo();
        ce = l.getCe();
        cTotal = l.getCTotal();
        inicioEstado = l.getInicioEstado();
    }

    /**
     * @param modo the modo to set
     */
    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public Modo getModo() {
        return modo;
    }

    /**
     * @param co the co to set
     */
    public void setCo(double co) {
        this.co = co;
    }

    public double getCo() {
        return co;
    }

    public void setCe(double ce) {
        this.ce = ce;
    }

    public double getCe() {
        return ce;
    }

    public void setCTotal(double cTotal) {
        this.cTotal = cTotal;
    }

    public double getCTotal() {
        return cTotal;
    }

    public double getInicioEstado() {
        return inicioEstado;
    }

    public void setInicioEstado(double ni) {
        inicioEstado = ni;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || this.getClass() == o.getClass())
            return false;

        Lampada l = (Lampada) o;
        return l.getModo() == this.modo && l.getCo() == this.co && l.getCe() == this.ce && l.getCTotal() == this.cTotal
                && l.getInicioEstado() == this.inicioEstado;
    }

    public Lampada clone() {
        return new Lampada(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lapmada modo: ").append(modo).append("\nConsumo ON: ").append(co).append("\nConsumo ECO: ")
                .append(ce).append("\nConsumo total: ").append(cTotal).append("\nUltimo reset foi feito a: ")
                .append(inicioEstado);
        return sb.toString();
    }

    // *********************************** */

    private void calculaECO() {
        double periodoDeTempo = System.currentTimeMillis() - inicioEstado;
        // num milissegundos * consumo por milisegundo
        this.cTotal += periodoDeTempo * ce;
    }

    private void calculaON() {
        double periodoDeTempo = System.currentTimeMillis() - inicioEstado;
        // num milissegundos * consumo por milisegundo
        this.cTotal += periodoDeTempo * co;
    }

    public void lampON() {
        if (this.modo == Modo.ECO) {
            calculaECO();
        }
        inicioEstado = System.currentTimeMillis();
        this.modo = Modo.ON;

    }

    public void lampOFF() {
        if (this.modo == Modo.ECO) {
            calculaECO();
        }
        if (this.modo == Modo.ON) {
            calculaON();
        }
        this.inicioEstado = System.currentTimeMillis();
        this.modo = Modo.OFF;
    }

    public void lampECO() {
        if (this.modo == Modo.ON) {
            calculaON();
        }
        this.inicioEstado = System.currentTimeMillis();
        this.modo = Modo.ECO;
    }

    public double totalConsumo() {
        return this.cTotal + periodoConsumo();
    }

    public double periodoConsumo() {
        double cAtual = 0;
        if (this.modo == Modo.ON) {
            cAtual = (System.currentTimeMillis() - inicioEstado) * co;
        }
        if (this.modo == Modo.ECO) {
            cAtual = (System.currentTimeMillis() - inicioEstado) * ce;
        }
        return cTotal + cAtual;
    }
}
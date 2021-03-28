import java.util.ArrayList;
import java.util.Iterator;

public class CasaInteligente {

    private ArrayList<Lampada> lampadas;

    public CasaInteligente() {
        lampadas = new ArrayList<>();
    }

    public CasaInteligente(ArrayList<Lampada> l) {
        this.setLampadas(l);
    }

    public CasaInteligente(CasaInteligente ci) {
        this.setLampadas(ci.getLampadas());
    }

    public void setLampadas(ArrayList<Lampada> l) {
        this.lampadas = new ArrayList<>();
        for (Lampada lamp : l) {
            this.lampadas.add(lamp.clone());
        }
    }

    public ArrayList<Lampada> getLampadas() {
        ArrayList<Lampada> ret = new ArrayList<>();
        for (Lampada lamp : this.lampadas) {
            ret.add(lamp.clone());
        }
        return ret;
    }

    // falta equals, toString e clone

    public void addLampada(Lampada l) {
        this.lampadas.add(l.clone());
    }

    public void ligaLampadaNormal(int index) {
        if (lampadas.size() < index && index >= 0) {
            this.lampadas.get(index).lampON();
        }
    }

    public void ligaLampadaECO(int index) {
        if (lampadas.size() < index && index >= 0) {
            this.lampadas.get(index).lampECO();
        }
    }

    public int qtEmEco() {
        int r = 0;
        for (Lampada l : lampadas) {
            if (l.getModo() == Lampada.Modo.ECO)
                r++;
        }
        return r;
    }

    public int qtEmEcoIter() {
        int r = 0;
        Iterator<Lampada> it = lampadas.iterator();
        while (it.hasNext()) {
            Lampada l = it.next();
            if (l.getModo() == Lampada.Modo.ECO)
                r++;
        }
        return r;
    }

    public int qtEmEcoStream() {
        return (int) lampadas.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).count();
    }

    /*
     * public int qtEmEcoStream2(){ return lampadas.stream().mapToInt(l -> {
     * if(l.getModo() == Lampada.Modo.ECO) return 1; else return 0; }) }
     */

    public void removeLampada(int index) {
        this.lampadas.remove(index);
    }

    public void ligaTodasEco() {
        for (Lampada l : lampadas) {
            l.lampECO();
        }
    }

    public void ligaTodasMax() {
        this.lampadas.forEach(l -> l.lampON());
    }

    /*
     * public double consumoTotal() { this.lampadas.stream().mapToDouble(l ->
     * l.totalConsumo()); }
     */

    public void reset() {
        for (Lampada l : lampadas) {
            l.setInicioEstado(0);
        }
    }

}
import java.util.ArrayList;
import java.util.List;

public class PivskaSteklenica extends Steklenica implements AlkoholnaPijaca {
    private String vrstaPiva;
    private double alkoholniPct;

    public PivskaSteklenica(String material, double volumen, String vrstaPiva, double alkoholniPct) {
        super(material, volumen);
        this.vrstaPiva = vrstaPiva;
        this.alkoholniPct = alkoholniPct;
    }

    public void nalijPivo(String vrsta) {
        this.vrstaPiva = vrsta;
        System.out.println("Pivska steklenica je napolnjena z " + vrsta + ".");
    }

    public void izpisVrstaPiva() {
        System.out.println("V steklenici je " + vrstaPiva + ".");
    }

    public String getVrstaPiva() {
        return vrstaPiva;
    }

    public void setVrstaPiva(String vrstaPiva) {
        this.vrstaPiva = vrstaPiva;
    }

    @Override
    public double getAlkoholniPct() {
        return alkoholniPct;
    }
}

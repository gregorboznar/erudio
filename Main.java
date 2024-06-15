import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Steklenica> seznamSteklenic = new ArrayList<>();
        seznamSteklenic.add(new Steklenica("Steklo", 0.75));
        seznamSteklenic.add(new Steklenica("Plastika", 1.0));
        seznamSteklenic.add(new PivskaSteklenica("Steklo", 0.5, "Lager", 5.0));

        for (Steklenica steklenica : seznamSteklenic) {
            steklenica.preveriStanje();
            try {
                steklenica.odpri();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            if (steklenica instanceof PivskaSteklenica) {
                PivskaSteklenica pivskaSteklenica = (PivskaSteklenica) steklenica;
                pivskaSteklenica.izpisVrstaPiva();
                System.out.println("Alkoholni delež: " + pivskaSteklenica.getAlkoholniPct() + "%");
                pivskaSteklenica.nalijPivo("IPA");
                pivskaSteklenica.izpisVrstaPiva();
            }

            steklenica.preveriStanje();
            try {
                steklenica.zapri();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            steklenica.preveriStanje();
            System.out.println();
        }
    }
}

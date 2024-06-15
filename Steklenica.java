public class Steklenica {
    private String material;
    private double volumen;
    private boolean zaprta;

    public Steklenica(String material, double volumen) {
        this.material = material;
        this.volumen = volumen;
        this.zaprta = true;
    }

    public void odpri() throws IllegalStateException {
        if (zaprta) {
            zaprta = false;
            System.out.println("Steklenica je zdaj odprta.");
        } else {
            throw new IllegalStateException("Steklenica je že odprta.");
        }
    }

    public void zapri() throws IllegalStateException {
        if (!zaprta) {
            zaprta = true;
            System.out.println("Steklenica je zdaj zaprta.");
        } else {
            throw new IllegalStateException("Steklenica je že zaprta.");
        }
    }

    public void preveriStanje() {
        if (zaprta) {
            System.out.println("Steklenica je zaprta.");
        } else {
            System.out.println("Steklenica je odprta.");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public boolean isZaprta() {
        return zaprta;
    }
}

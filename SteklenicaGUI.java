import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SteklenicaGUI extends JFrame implements ActionListener {
    private JButton preveriStanjeButton, odpriButton, zapriButton, nalijPivoButton;
    private JLabel stanjeLabel, vrstaPivaLabel;
    private JTextField vrstaPivaTextField;
    private List<Steklenica> seznamSteklenic;
    private int currentIndex;

    public SteklenicaGUI() {
        seznamSteklenic = new ArrayList<>();
        seznamSteklenic.add(new Steklenica("Steklo", 0.75));
        seznamSteklenic.add(new Steklenica("Plastika", 1.0));
        seznamSteklenic.add(new PivskaSteklenica("Steklo", 0.5, "Lager", 5.0));

        setTitle("SeznamSteklenic GUI");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        preveriStanjeButton = new JButton("Preveri stanje");
        odpriButton = new JButton("Odpri");
        zapriButton = new JButton("Zapri");
        nalijPivoButton = new JButton("Nalij pivo");
        stanjeLabel = new JLabel("Stanje: ");
        vrstaPivaLabel = new JLabel("Vrsta piva: ");
        vrstaPivaTextField = new JTextField();

        preveriStanjeButton.addActionListener(this);
        odpriButton.addActionListener(this);
        zapriButton.addActionListener(this);
        nalijPivoButton.addActionListener(this);

        add(preveriStanjeButton);
        add(odpriButton);
        add(zapriButton);
        add(nalijPivoButton);
        add(stanjeLabel);
              add(vrstaPivaLabel);
        add(vrstaPivaTextField);

        currentIndex = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == preveriStanjeButton) {
            preveriStanje();
        } else if (e.getSource() == odpriButton) {
            odpriSteklenico();
        } else if (e.getSource() == zapriButton) {
            zapriSteklenico();
        } else if (e.getSource() == nalijPivoButton) {
            nalijPivo();
        }
    }

    private void preveriStanje() {
        Steklenica steklenica = seznamSteklenic.get(currentIndex);
        stanjeLabel.setText("Stanje: " + (steklenica.isZaprta() ? "Zaprta" : "Odprta"));
    }

    private void odpriSteklenico() {
        Steklenica steklenica = seznamSteklenic.get(currentIndex);
        try {
            steklenica.odpri();
            stanjeLabel.setText("Stanje: Odprta");
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void zapriSteklenico() {
        Steklenica steklenica = seznamSteklenic.get(currentIndex);
        try {
            steklenica.zapri();
            stanjeLabel.setText("Stanje: Zaprta");
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void nalijPivo() {
        if (seznamSteklenic.get(currentIndex) instanceof PivskaSteklenica) {
            PivskaSteklenica pivskaSteklenica = (PivskaSteklenica) seznamSteklenic.get(currentIndex);
            pivskaSteklenica.nalijPivo(vrstaPivaTextField.getText());
            vrstaPivaLabel.setText("Vrsta piva: " + pivskaSteklenica.getVrstaPiva());
        }
    }

    public static void main(String[] args) {
        SteklenicaGUI gui = new SteklenicaGUI();
        gui.setVisible(true);
    }
}


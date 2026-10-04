import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {

    private JLabel rundenErgebnisLabel;
    private JLabel gesamtPunkteLabel;

    private JTextField spielerEingabe;
    private JTextField computerAusgabe;

    private JButton nochmalButton;

    public GewinnView() {

        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        rundenErgebnisLabel = new JLabel("Tippe eine Zahl von 1 bis 9");
        gesamtPunkteLabel = new JLabel("Gesamtpunkte: 30");

        spielerEingabe = new JTextField();
        computerAusgabe = new JTextField();

        computerAusgabe.setEditable(false);

        nochmalButton = new JButton("Noch einmal!");
        nochmalButton.setEnabled(false);

        setLayout(new GridLayout(3, 2));

        add(rundenErgebnisLabel);
        add(gesamtPunkteLabel);
        add(spielerEingabe);
        add(computerAusgabe);
        add(new JLabel(""));
        add(nochmalButton);
    }
    public JTextField getSpielerEingabe() {
        return spielerEingabe;
    }

    public JTextField getComputerAusgabe() {
        return computerAusgabe;
    }

    public JButton getNochmalButton() {
        return nochmalButton;
    }

    public void setRundenErgebnis(String text) {
        rundenErgebnisLabel.setText(text);
    }

    public void setGesamtPunkte(String text) {
        gesamtPunkteLabel.setText(text);
    }

    public void setNochmalButtonAktiv(boolean aktiv) {
        nochmalButton.setEnabled(aktiv);
    }

    public void leereFelder() {
        spielerEingabe.setText("");
        computerAusgabe.setText("");
    }
}

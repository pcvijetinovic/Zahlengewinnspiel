public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.getSpielerEingabe().addActionListener(e -> spieleRunde());
        view.getNochmalButton().addActionListener(e -> neueRunde());
    }

    private void spieleRunde() {
        try {
            int spielerZahl = Integer.parseInt(
                    view.getSpielerEingabe().getText()
            );

            if (spielerZahl < 1 || spielerZahl > 9) {
                view.setRundenErgebnis("Bitte Zahl von 1 bis 9!");
                return;
            }

            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);

            view.getComputerAusgabe().setText(
                    String.valueOf(model.getComputerZahl())
            );

            // Prüfen, ob das Spiel vorbei ist
            if (model.hatGewonnen()) {
                view.setRundenErgebnis("Gewonnen!");
                view.getSpielerEingabe().setEditable(false);
            } else if (model.hatVerloren()) {
                view.setRundenErgebnis("Verloren!");
                view.getSpielerEingabe().setEditable(false);
            } else {
                view.setRundenErgebnis(
                        String.valueOf(model.getRundenErgebnis())
                );
            }

            view.setGesamtPunkte(
                    "Gesamtpunkte: " + model.getGesamtPunkte()
            );

            view.getSpielerEingabe().setEditable(false);
            view.setNochmalButtonAktiv(true);

        } catch (NumberFormatException e) {
            view.setRundenErgebnis("Bitte Zahl von 1 bis 9!");
        }
    }

    private void neueRunde() {
        view.leereFelder();

        if (!model.hatGewonnen() && !model.hatVerloren()) {
            view.getSpielerEingabe().setEditable(true);
            view.getSpielerEingabe().requestFocus();
        }

        view.setNochmalButtonAktiv(false);
    }
}

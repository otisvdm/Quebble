package Vagado;

public class TelStrategie1 extends Puntentelling {
    @Override
    public int telPunten(Ronde[] rondes) {
        int punten = 0;
        for (Ronde ronde : rondes) {
            if (ronde.getVraag().getVraag().equals(ronde.getAntwoord())) {
                punten++;
                if (ronde.getRondeTijd() < 10) {
                    punten++;
                }
            }
        }
        return punten;
    }
}

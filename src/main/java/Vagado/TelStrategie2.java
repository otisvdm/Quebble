package Vagado;

import Vagado.Puntentelling;

public class TelStrategie2 extends Puntentelling {
    @Override
    public int telPunten(Ronde[] rondes) {
        int punten = 0;
        for (Ronde ronde : rondes) {
            if (ronde.getVraag().getVraag().equals(ronde.getAntwoord())) {
                punten += 2;
                if (ronde.getRondeTijd() < 10) {
                    punten++;
                }
            } else if (punten > 0) {
                punten--;
            }
        }
        return punten;
    }
}

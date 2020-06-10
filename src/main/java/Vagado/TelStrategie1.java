package Vagado;

public class TelStrategie1 extends Puntentelling {

    public TelStrategie1() {
        super();
    }

    @Override
    public int telPunten(Ronde[] rondes) {
        int punten = 0;
        for (Ronde ronde : rondes) {
            if (ronde.isCorrect()) {
                punten++;
                if (ronde.getRondeTijd() < 10) {
                    punten++;
                }
            }
        }
        return punten;
    }
}

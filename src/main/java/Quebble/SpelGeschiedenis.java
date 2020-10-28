package Quebble;

public class SpelGeschiedenis {
    private Quiz quiz;
    private iSpeler speler;
    private int punten;

    public SpelGeschiedenis(iSpeler speler, Quiz quiz, int punten) {
        this.speler = speler;
        this.quiz = quiz;
        this.punten = punten;
    }
}

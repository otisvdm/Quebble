package Quebble;

public class SpelGeschiedenis {

    private iQuiz quiz;
    private iSpeler speler;
    private int punten;

    public SpelGeschiedenis(iSpeler speler, iQuiz quiz, int punten) {
        this.speler = speler;
        this.quiz = quiz;
        this.punten = punten;
    }

    public iQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(iQuiz quiz) {
        this.quiz = quiz;
    }

    public iSpeler getSpeler() {
        return speler;
    }

    public void setSpeler(iSpeler speler) {
        this.speler = speler;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }
}

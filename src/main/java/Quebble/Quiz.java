package Quebble;

public class Quiz implements iQuiz{
    private Long id;
    private SpelGeschiedenis sg;
    private Speler speler;
    private SpelerAntwoord[] antwoorden;
    private Vraag[] vragen;

    public Quiz(Long id, Vraag[] vragen) {
        this.id = id;
        this.vragen = vragen;
        this.antwoorden = new SpelerAntwoord[8];
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public Vraag[] getVragen() {
        return this.vragen;
    }

    private Vraag getVraag(int vraagNummer) {
        return this.vragen[vraagNummer - 1];
    }

    public void beantwoordVraag(int vraagNummer, String antwoord, int tijd) {
        Vraag vraag = this.getVraag(vraagNummer);
        SpelerAntwoord sa = new SpelerAntwoord(antwoord, tijd);
        if (vraag.controleerAntwoord(antwoord)) {
            sa.setLetter(vraag.getLetter());
        }
        this.antwoorden[vraagNummer-1] = sa;
    }

    public char[] getLetters() {
        char[] letters = new char[8];
        for (int i = 0; i < 8; i++) {
            letters[i] = antwoorden[i].getLetter();
        }
        return letters;
    }

    public void setWoord(String spelerWoord) {
        Woord woord = new Woord(spelerWoord);
        woord.setWoord();
    }

    public int telpunten() {
        return 1;
    }
}

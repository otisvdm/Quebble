package Quebble;

public class Quiz implements iQuiz {

    private int id;
    private iSpeler speler;
    private iSpelerAntwoord[] antwoorden;
    private iVraag[] vragen;
    private iTelstrategie telstrategie;
    private iWoord woord;

    public Quiz(int id, iVraag[] vragen) {
        this.id = id;
        this.vragen = vragen;
        this.antwoorden = new SpelerAntwoord[8];

        // Hier kun je de standaard telstrategie wijzigen
        this.telstrategie = new Strategie1();
    }

    @Override
    public void setSpeler(iSpeler speler) {
        this.speler = speler;
    }

    @Override
    public iVraag[] getVragen() {
        return this.vragen;
    }

    @Override
    public void setVragen(iVraag[] vragen) {
        this.vragen = vragen;
    }

    @Override
    public void beantwoordVraag(int vraagNummer, String antwoord, int tijd) {
        SpelerAntwoord sa = new SpelerAntwoord(antwoord, tijd);
        iVraag vraag = this.getVraag(vraagNummer);
        if (vraag.controleerAntwoord(antwoord)) {
            sa.setLetter(vraag.getLetter());
        }
        this.antwoorden[vraagNummer - 1] = sa;
    }

    @Override
    public char[] getLetters() {
        char[] letters = new char[8];
        for (int i = 0; i < 8; i++) {
            letters[i] = antwoorden[i].getLetter();
        }
        return letters;
    }

    @Override
    public void setWoord(String spelerWoord) {
        iWoord woord = new Woord(spelerWoord);
        Bibliotheek b = new Bibliotheek();
        woord.setBibliotheek(b);
        if (woord.controleerWoord()) {
            this.woord = woord;
        }
    }

    @Override
    public SpelGeschiedenis telPunten() {
        int punten = telstrategie.telPunten(antwoorden, woord);
        return new SpelGeschiedenis(speler, this, punten);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private iVraag getVraag(int vraagNummer) {
        return this.vragen[vraagNummer-1];
    }

    //Hier kun je de telstrategie wijzigen terwijl de applicatie runt
    public void setTelstrategie(iTelstrategie telstrategie) {
        this.telstrategie = telstrategie;
    }
}

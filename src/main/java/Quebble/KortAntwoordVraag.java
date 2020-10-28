package Quebble;

public class KortAntwoordVraag extends Vraag implements iVraag{
    private String vraag;
    private KortAntwoord[] mogelijkeAntwoorden;
    private char letter;

    public KortAntwoordVraag(String vraag, KortAntwoord[] mogelijkeAntwoorden, char letter) {
        this.mogelijkeAntwoorden = mogelijkeAntwoorden;
        this.vraag = vraag;
        this.letter = letter;
    }

    public String getVraag() {
        return this.vraag;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        for (KortAntwoord kortAntwoord : mogelijkeAntwoorden) {
            if (kortAntwoord.controleerAntwoord(antwoord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public char getLetter() {
        return this.letter;
    }
}

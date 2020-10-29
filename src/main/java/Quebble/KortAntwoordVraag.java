package Quebble;

public class KortAntwoordVraag extends Vraag {

    private KortAntwoord[] mogelijkeAntwoorden;

    public KortAntwoordVraag(int id, String vraag, KortAntwoord[] mogelijkeAntwoorden, char letter) {
        super(id, vraag, letter, true);
        this.mogelijkeAntwoorden = mogelijkeAntwoorden;
    }

    public String getVraag() {
        return this.vraag;
    }

    @Override
    public MeerkeuzeAntwoord[] getAntwoorden() {
        throw new UnsupportedOperationException("Kort antwoord heeft geen meerkeuze antwoorden");
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

    @Override
    public void setLetter(char letter) {

    }

    @Override
    public int getId() {
        return this.id;
    }
}

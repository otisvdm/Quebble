package Quebble;

public abstract class Vraag implements iVraag {
    private String vraag;
    private boolean isActief;
    private char letter;

    public String getVraag() {
        return this.vraag;
    }
    public MeerkeuzeAntwoord[] getAntwoorden() {
        throw new UnsupportedOperationException();
    }
    public boolean controleerAntwoord(String antwoord) {
        throw new UnsupportedOperationException();
    }

    public char getLetter() {
        throw new UnsupportedOperationException();
    }
}

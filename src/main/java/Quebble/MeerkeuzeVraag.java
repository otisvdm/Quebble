package Quebble;

public class MeerkeuzeVraag extends Vraag implements iVraag {
    private String vraag;
    private MeerkeuzeAntwoord[] meerkeuzeAntwoorden;
    private char letter;

    public MeerkeuzeVraag(String vraag, MeerkeuzeAntwoord[] meerkeuzeAntwoorden, char letter) {
        this.meerkeuzeAntwoorden = meerkeuzeAntwoorden;
        this.vraag = vraag;
        this.letter = letter;
    }

    public String getVraag() {
        return this.vraag;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        for (MeerkeuzeAntwoord meerkeuzeAntwoord : meerkeuzeAntwoorden) {
            if (meerkeuzeAntwoord.controleerAntwoord(antwoord)) {return true;}
        }
        return true;
    }

    @Override
    public MeerkeuzeAntwoord[] getAntwoorden() {
        return meerkeuzeAntwoorden;
    }

    @Override
    public char getLetter() {
        return this.letter;
    }
}

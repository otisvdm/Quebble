package Quebble;

public class KortAntwoord implements iAntwoord{
    private String antwoord;

    public KortAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equals(this.antwoord);
    }
}

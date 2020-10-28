package Quebble;

public class MeerkeuzeAntwoord implements iAntwoord {
    private String antwoord;
    private boolean isCorrect;

    public MeerkeuzeAntwoord(String antwoord, boolean isCorrect) {
        this.antwoord = antwoord;
        this.isCorrect = isCorrect;
    }

    public String getAntwoord() {
        return this.antwoord;
    }

    public boolean controleerAntwoord(String antwoord) {
        return (antwoord.equals(this.antwoord) && this.isCorrect);
    }
}

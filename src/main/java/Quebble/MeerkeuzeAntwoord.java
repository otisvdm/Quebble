package Quebble;

public class MeerkeuzeAntwoord extends Antwoord {

    private boolean isCorrect;

    public MeerkeuzeAntwoord(String antwoord, boolean isCorrect) {
        super(antwoord);
        this.isCorrect = isCorrect;
    }

    @Override
    public String getAntwoord() {
        return this.antwoord;
    }

    @Override
    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return (antwoord.equals(this.antwoord) && this.isCorrect);
    }

}

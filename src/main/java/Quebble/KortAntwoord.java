package Quebble;

public class KortAntwoord extends Antwoord {

    public KortAntwoord(String antwoord) {
        super(antwoord);
    }

    @Override
    public String getAntwoord() {
        return this.antwoord;
    }

    @Override
    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equals(this.antwoord);
    }
}

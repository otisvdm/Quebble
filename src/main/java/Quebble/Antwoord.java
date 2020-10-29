package Quebble;

public abstract class Antwoord implements iAntwoord {

    protected String antwoord;

    public Antwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    @Override
    public abstract String getAntwoord();

    @Override
    public abstract void setAntwoord(String antwoord);

    @Override
    public abstract boolean controleerAntwoord(String antwoord);

}

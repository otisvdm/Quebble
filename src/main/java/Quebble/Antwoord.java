package Quebble;

public abstract class Antwoord implements iAntwoord {

    protected String antwoord;

    public Antwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public abstract  String getAntwoord();

    public abstract void setAntwoord(String antwoord);

}

package Quebble;

public class SpelerAntwoord implements iSpelerAntwoord{

    private String antwoord;
    private int tijd;
    private char letter;

    public SpelerAntwoord(String antwoord, int tijd){
        this.antwoord = antwoord;
        this.tijd = tijd;
    }
    public char getLetter() {
        return this.letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public int getTijd() {
        return tijd;
    }

    public void setTijd(int tijd) {
        this.tijd = tijd;
    }
}

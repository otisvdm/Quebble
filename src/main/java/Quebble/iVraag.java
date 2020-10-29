package Quebble;

public interface iVraag {

    int getId();

    String getVraag();

    boolean controleerAntwoord(String antwoord);

    char getLetter();

    void setLetter(char letter);

}

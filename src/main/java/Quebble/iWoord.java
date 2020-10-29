package Quebble;

public interface iWoord {

    boolean controleerWoord();

    String getWoord();

    void setWoord(String woord);

    boolean isCorrect();

    void setCorrect(boolean correct);

    void setBibliotheek(iBibliotheek bibliotheek);

}

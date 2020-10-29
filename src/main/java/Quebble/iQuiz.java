package Quebble;

public interface iQuiz {

    iVraag[] getVragen();

    void beantwoordVraag(int vraagNummer, String antwoord, int tijd);

    void setVragen(iVraag[] vragen);

    void setId(int id);

    int getId();

    char[] getLetters();

    void setWoord(String woord);

    SpelGeschiedenis telPunten();

    void setSpeler(iSpeler speler);
}

package Quebble;

public class MeerkeuzeVraag extends Vraag {

    private MeerkeuzeAntwoord[] meerkeuzeAntwoorden;

    public MeerkeuzeVraag(int id, String vraag, MeerkeuzeAntwoord[] meerkeuzeAntwoorden, char letter) {
        super(id, vraag, letter, true);
        this.meerkeuzeAntwoorden = meerkeuzeAntwoorden;
    }

    public String getVraag() {
        return this.vraag;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        try {
            int antwoordIndex = this.getAntwoordIndex(antwoord);
            return meerkeuzeAntwoorden[antwoordIndex].controleerAntwoord(antwoord);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MeerkeuzeAntwoord[] getAntwoorden() {
        return meerkeuzeAntwoorden;
    }

    public String[] getAntwoordenVoorQuiz() {
        String[] quizAntwoorden = new String[meerkeuzeAntwoorden.length];
        for (int i = 0; i < meerkeuzeAntwoorden.length; ++i) {
            quizAntwoorden[i] = meerkeuzeAntwoorden[i].getAntwoord();
        }
        return quizAntwoorden;
    }

    @Override
    public char getLetter() {
        return this.letter;
    }

    @Override
    public void setLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public int getId() {
        return this.id;
    }

    private int getAntwoordIndex(String antwoord) throws Exception {
        switch(antwoord) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            default:
                throw new Exception("Answer not possible");
        }
    }
}

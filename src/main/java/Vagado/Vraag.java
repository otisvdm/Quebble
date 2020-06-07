package Vagado;

public class Vraag {

    private String id;
    private boolean isMultipleChoice;
    private String vraag;
    private Antwoord[] antwoorden;

    public Vraag(String vraag, boolean isMultipleChoice) {
        this.vraag = vraag;
        this.isMultipleChoice = isMultipleChoice;

        // Hard coded solution just for this demo
        if (isMultipleChoice) {
            this.antwoorden = new Antwoord[]{new Antwoord("1", true),new Antwoord("2", false),new Antwoord("3", false)};
        } else {
            this.antwoorden = new Antwoord[]{new Antwoord("2", true)};
        }
    }

    public Antwoord[] getAntwoorden() {
        return antwoorden;
    }

    public String getVraag() {
        return vraag;
    }

    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }
}

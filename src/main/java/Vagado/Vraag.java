package Vagado;

public class Vraag {

    private String vraag;
    private boolean isMultipleChoice;

    public Vraag(String vraag) {
        this.vraag = vraag;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }
}

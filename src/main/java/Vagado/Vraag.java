package Vagado;

public class Vraag {

    private int vraagId;
    private String vraag;

    public Vraag(int vraagId) {
        this.vraagId = vraagId;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }
}

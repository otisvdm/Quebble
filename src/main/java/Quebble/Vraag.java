package Quebble;

public abstract class Vraag implements iVraag {

    protected int id;
    protected String vraag;
    protected boolean isActief;
    protected char letter;

    public Vraag(int id, String vraag, char letter, boolean isActief) {
        this.id = id;
        this.vraag = vraag;
        this.letter = letter;
        this.isActief = isActief;
    }

    public abstract String getVraag();

    public abstract boolean controleerAntwoord(String antwoord);

    public abstract char getLetter();

    public abstract void setLetter(char letter);

    public abstract int getId();
}

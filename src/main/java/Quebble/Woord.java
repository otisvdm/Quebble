package Quebble;

public class Woord implements iWoord {

    private String woord;

    private boolean correct;

    private iBibliotheek bibliotheek;

    public Woord(String woord){
        this.woord = woord;
    }

    public String getWoord() {
        return this.woord;
    }

    @Override
    public boolean controleerWoord() {
        return bibliotheek.controleerWoord(this.woord);
    }

    @Override
    public void setWoord(String woord) {
        this.woord = woord;
    }

    @Override
    public void setBibliotheek(iBibliotheek bibliotheek) {
        this.bibliotheek = bibliotheek;
    }

    @Override
    public boolean isCorrect() {
        return correct;
    }

    @Override
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

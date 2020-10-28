package Quebble;

public class Woord extends Bibliotheek{
    private String woord;
    private boolean correct;
    public Woord(String woord){
        this.woord = woord;
    }

    public void setWoord() {
        controleerWoord();
    }
}

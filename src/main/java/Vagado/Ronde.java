package Vagado;

public class Ronde implements iRonde{

    private int rondenummer;
    private String antwoord;
    private Vraag vraag;
    private int rondeTijd;

    public Ronde(int rondenummer) {
        this.rondenummer = rondenummer;
    }

    public void bewaarAntwoordInRonde(int rondenummer, String antwoord, int tijd, Vraag vraag) {
        this.rondenummer = rondenummer;
        this.antwoord = antwoord;
        this.rondeTijd = tijd;
        this.vraag = vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public int getRondeTijd() {
        return rondeTijd;
    }

    public Vraag getVraag() {
        return vraag;
    }

    public int getRondenummer() {
        return rondenummer;
    }
}

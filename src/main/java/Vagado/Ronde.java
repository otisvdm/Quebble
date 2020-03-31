package Vagado;

public class Ronde {
    int rondenummer;
    String antwoord;
    Vraag vraag;
    int rondeTijd;

    public Ronde(int rondenummer) {
        this.rondenummer = rondenummer;
    }

    public void bewaarAntwoordInRonde(String antwoord, int tijd, Vraag vraag) {
        this.antwoord = antwoord;
        this.rondeTijd = tijd;
        this.vraag = vraag;
    }
}

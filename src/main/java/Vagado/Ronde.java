package Vagado;

import java.util.Arrays;

public class Ronde implements iRonde{

    private int rondenummer;
    private String antwoord;
    private Vraag vraag;
    private int rondeTijd;
    private boolean correct = false;

    public Ronde(int rondenummer) {
        this.rondenummer = rondenummer;
    }

    public void bewaarAntwoordInRonde(int rondenummer, String antwoord, int tijd, Vraag vraag) {
        this.rondenummer = rondenummer;
        this.antwoord = antwoord;
        this.rondeTijd = tijd;
        this.vraag = vraag;
        if (vraag.isMultipleChoice() && antwoord.equals(vraag.getAntwoorden()[0].getAntwoord())) {
            this.correct = true;
        } else if (!vraag.isMultipleChoice()) {
            Antwoord antwoordObject = (Antwoord) Arrays.stream(vraag.getAntwoorden()).filter(Antwoord::isJuist).toArray()[0];
            String correctAntwoord = antwoordObject.getAntwoord();
            if (correctAntwoord.equals(antwoord)) {
                this.correct = true;
            }
        }
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

    public boolean isCorrect() {
        return correct;
    }
}

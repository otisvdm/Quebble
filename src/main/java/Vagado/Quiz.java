package Vagado;

import java.util.ArrayList;
import java.util.UUID;

public class Quiz {

    private String quizId;
    private int punten;
    private String playerId;
    private ArrayList<Ronde> rondes;
    private Vragenlijst[] vragenlijsten;
    private Puntentelling puntenTeller;
    private Vragenlijst vragenlijst = new Vragenlijst(new Vraag[]{new Vraag("Vraag1")}, "1", new Thema());
    public Vraag[] vragen;

    public Quiz(String playerId) {
        this.playerId = playerId;
        vragenlijsten = this.getBeschikbareVragenlijsten(playerId);
        rondes = new ArrayList<>();
        rondes.add(new Ronde(1));
        puntenTeller = new Puntentelling();
    }

    public String maakQuiz() {
        this.quizId = UUID.randomUUID().toString();
        return this.quizId;
    }

    public Vragenlijst[] getBeschikbareVragenlijsten(String playerId) {
        return vragenlijst.getBeschikbareVragenlijsten(playerId);
    }

    public void kiesVragenlijst(Vragenlijst lijst) {
        vragenlijst = lijst;
        vragen = vragenlijst.getWillekeurigeVragen(lijst);
    }

    public void beantwoordVraag(String antwoord, Vraag vraag, int tijd) {
        rondes.get(rondes.size() - 1).bewaarAntwoordInRonde(antwoord, tijd, vraag);
        if(rondes.size() < 10) {
            rondes.add(new Ronde(rondes.size() + 1));
        }
    }

    public int eindigQuiz() {
        if (rondes.size() == 10) {
            return puntenTeller.telPunten(vragen, rondes);
        } else {
            return 0;
        }
    }
}

package Vagado;

import java.util.ArrayList;
import java.util.UUID;

public class Quiz {
    String quizId;
    int punten;
    String playerId;
    ArrayList<Ronde> rondes;
    Vragenlijst[] vragenlijsten;
    Vragenlijst vragenlijst = new Vragenlijst(new Vraag[]{new Vraag(1)}, "1", new Thema());
    Vraag[] vragen;

    public Quiz(String playerId) {
        this.playerId = playerId;
        vragenlijsten = this.getBeschikbareVragenlijsten(playerId);
        rondes.add(new Ronde(1));
    }

    public String maakQuiz() {
        quizId = UUID.randomUUID().toString();
        return quizId;
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

    public int eindigQuiz(int quizId) {
        if (rondes.size() == 10) {
            return punten;
        } else {
            return 0;
        }
    }
}

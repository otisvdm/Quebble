package Vagado;

import java.util.ArrayList;
import java.util.UUID;

public interface iQuiz {
    public String maakQuiz();

    public Vragenlijst[] getBeschikbareVragenlijsten(int playerId);

    public void kiesVragenlijst(Vragenlijst lijst);

    public void beantwoordVraag(String antwoord, Vraag vraag, int tijd);

    public int eindigQuiz(String strategie);
}

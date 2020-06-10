package Vagado;



public interface iQuiz {
    String maakQuiz(Puntentelling strategie);
    Vragenlijst[] getBeschikbareVragenlijsten(int playerId);
    void kiesVragenlijst(Vragenlijst lijst);
    void beantwoordVraag(String antwoord, Vraag vraag, int tijd);
}

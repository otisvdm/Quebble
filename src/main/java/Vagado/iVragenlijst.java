package Vagado;

public interface iVragenlijst {
    Vraag[] getWillekeurigeVragen(Vragenlijst lijst);
    Vragenlijst[] getBeschikbareVragenlijsten(int playerId);
}

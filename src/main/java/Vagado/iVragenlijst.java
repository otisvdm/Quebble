package Vagado;

public interface iVragenlijst {
    public Vraag[] getWillekeurigeVragen(Vragenlijst lijst);
    public Vragenlijst[] getBeschikbareVragenlijsten(int playerId);
}

package Vagado;

public interface iRonde {
    void bewaarAntwoordInRonde(int rondenummer, String antwoord, int tijd, Vraag vraag);
    String getAntwoord();
    int getRondeTijd();
}

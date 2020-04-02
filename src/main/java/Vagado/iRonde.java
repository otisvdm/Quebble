package Vagado;

public interface iRonde {
    public void bewaarAntwoordInRonde(int rondenummer, String antwoord, int tijd, Vraag vraag);
    public String getAntwoord();
    public int getRondeTijd();
}

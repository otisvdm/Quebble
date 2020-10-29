package Quebble;

public abstract class Persoon implements iPersoon {

    protected String gebruikersnaam;
    protected String wachtwoord;

    protected Persoon(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public abstract String getGebruikersnaam();

    public abstract void setGebruikersnaam(String gebruikersnaam);

    public abstract String getWachtwoord();

    public abstract void setWachtwoord(String wachtwoord);
}

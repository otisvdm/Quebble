package Quebble;

public abstract class Persoon implements iPersoon {

    protected String gebruikersnaam;
    protected String wachtwoord;

    protected Persoon(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    @Override
    public abstract String getGebruikersnaam();

    @Override
    public abstract String getWachtwoord();

}

package Quebble;

public class Medewerker extends Persoon {

    public Medewerker(String gebruikersnaam, String wachtwoord) {
       super(gebruikersnaam, wachtwoord);
    }

    @Override
    public String getGebruikersnaam() {
       return this.gebruikersnaam;
    }

    @Override
    public String getWachtwoord() {
        return this.wachtwoord;
    }
}

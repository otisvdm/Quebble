package Quebble;

public class Speler implements iSpeler{
    private String gebruikersnaam;
    private String wachtwoord;
    private int credits;

    public Speler(String gebruikersnaam, String wachtwoord, int credits) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.credits = credits;
    }

    private void voegCreditsToe() {

    }

    public void verrekenCredits() throws Exception {
        if (this.credits <= 40) {
            throw new Exception("Niet genoeg credits!");
        } else {
            this.credits -= 40;
            //TODO
            //datastore credits updaten maar da mag niet direct vanuit Speler dus waddan
        }
    }

}

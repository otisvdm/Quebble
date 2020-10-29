package Quebble;

public class Speler extends Persoon implements iSpeler {


    private int credits;

    public Speler(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord);
        this.voegRegistratieCreditsToe();
    }



    private void voegRegistratieCreditsToe() {
        this.credits = 1000;
    }

    @Override
    public void verrekenCredits() throws Exception {
        if (this.credits < 40) {
            throw new Exception("Niet genoeg credits!");
        } else {
            this.credits -= 40;
        }
    }

    @Override
    public String getGebruikersnaam() {
        return this.gebruikersnaam;
    }

    @Override
    public String getWachtwoord() {
        return this.wachtwoord;
    }

    @Override
    public int getCredits() {
        return this.credits;
    }
}

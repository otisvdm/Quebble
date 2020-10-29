package Quebble.handlers;

import Quebble.Datastore;
import Quebble.Speler;
import Quebble.iSpeler;

public class SpelerHandler {

    private Datastore datastore;

    public void registreerSpeler(String gebruikersnaam, String wachtwoord) throws Exception {
        boolean bestaatSpeler = datastore.controleerGebruikersnaam(gebruikersnaam);
        if (!bestaatSpeler) {
            iSpeler speler = new Speler(gebruikersnaam, wachtwoord);
            datastore.opslaanSpeler(speler);
        } else {
            throw new Exception("Gebruikersnaam is al in gebruik. Voer een andere gebruikernaam in.");
        }
    }

    public String loginSpeler(String gebruikersnaam, String wachtwoord) throws Exception {
        boolean speler = datastore.loginSpeler(gebruikersnaam, wachtwoord);
        if (speler) {
            return gebruikersnaam;
        } else {
            throw new Exception("Geen speler gevonden met de ingevoerde gebruikernaam.");
        }
    }

    // Inject datastore in SpelerHandler
    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }

}

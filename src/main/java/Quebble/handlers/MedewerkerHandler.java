package Quebble.handlers;

import Quebble.Datastore;

public class MedewerkerHandler {

    private Datastore datastore;

    public void loginMedewerker(String gebruikersnaam, String wachtwoord) throws Exception {
        boolean speler = datastore.loginSpeler(gebruikersnaam, wachtwoord);
        if (!speler) {
            throw new Exception("Geen speler gevonden met de ingevoerde gebruikernaam.");
        }
    }

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }
}

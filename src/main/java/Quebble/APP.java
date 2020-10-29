package Quebble;

import Quebble.handlers.MedewerkerHandler;
import Quebble.handlers.QuizHandler;
import Quebble.handlers.SpelerHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class APP {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Datastore datastore = Datastore.getInstance();
        QuizHandler quizHandler = new QuizHandler();
        SpelerHandler spelerHandler = new SpelerHandler();
        MedewerkerHandler medewerkerHandler = new MedewerkerHandler();
        // Inject datastore in QuizHandler and SpelerHandler
        quizHandler.setDatastore(datastore);
        spelerHandler.setDatastore(datastore);
        medewerkerHandler.setDatastore(datastore);
        

        switch(confirmation) {
            case "1":
                System.out.println("Voer een gebruikersnaam in.");
                String gebruikersnaam = reader.readLine();
                System.out.println("Voer een wachtwoord in.");
                String wachtwoord = reader.readLine();
                try {
                    spelerHandler.registreerSpeler(gebruikersnaam, wachtwoord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public String showStartup() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welkom bij Quebble, de leukste quiz van Nederland");
        System.out.println("Kies 1 om te registreren.");
        System.out.println("Kies 2 om in te loggen.");
        System.out.println("Kies 3 om in te loggen als medewerker");
        return reader.readLine();
    }
}

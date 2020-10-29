package Quebble;

import Quebble.handlers.MedewerkerHandler;
import Quebble.handlers.QuizHandler;
import Quebble.handlers.SpelerHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class APP {

    private Datastore datastore = Datastore.getInstance();
    private QuizHandler quizHandler = new QuizHandler();
    private SpelerHandler spelerHandler = new SpelerHandler();
    private MedewerkerHandler medewerkerHandler = new MedewerkerHandler();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        APP app = new APP();
    }

    public APP() throws IOException {
        quizHandler.setDatastore(datastore);
        spelerHandler.setDatastore(datastore);
        medewerkerHandler.setDatastore(datastore);
        this.run();
    }

    private void run() throws IOException {
        String startupKeuze = this.showStartup();
        String ingelogdeGebruiker = processStartup(startupKeuze);
    }


    private String showStartup() throws IOException {
        System.out.println("Welkom bij Quebble, de leukste quiz van Nederland");
        System.out.println("Kies 1 om te registreren.");
        System.out.println("Kies 2 om in te loggen.");
        System.out.println("Kies 3 om in te loggen als medewerker");
        System.out.println("Kies 4 om de applicatie af te sluiten.");
        return (String) reader.readLine();
    }

    public String processStartup(String input) throws IOException {
        String naamInvoer = "Voer je gebruikersnaam in.";
        String wachtwoordInvoer = "Voer je wachtwoord in.";
        switch(input) {
            case "1":
                System.out.println(naamInvoer);
                String gebruikersnaam = reader.readLine();
                System.out.println(wachtwoordInvoer);
                String wachtwoord = reader.readLine();
                try {
                    spelerHandler.registreerSpeler(gebruikersnaam, wachtwoord);
                    return (String) showStartup();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return (String) processStartup("1");
                }
            case "2":
                System.out.println(naamInvoer);
                String gebruiker = reader.readLine();
                System.out.println(wachtwoordInvoer);
                String w = reader.readLine();
                try {
                    return spelerHandler.loginSpeler(gebruiker, w);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return (String) processStartup("2");
                }
            case "3":
                System.out.println(naamInvoer);
                String medewerker = reader.readLine();
                System.out.println(wachtwoordInvoer);
                String ww = reader.readLine();
                try {
                    String ingelogdeMedewerker = medewerkerHandler.loginMedewerker(medewerker, ww);
                    if (ingelogdeMedewerker != null) {
                        medewerkerMenu();
                    }
                } catch (Exception e) {
                    return (String) processStartup("3");
                }
            case "4":
                System.out.println("Bedankt voor het spelen van Quebble! Tot snel!");
                System.exit(0);
            default:
                return (String) showStartup();
        }
    }

    private void medewerkerMenu() throws IOException {
        System.out.println("Welkom in het medewerkerspaneel!");
        System.out.println("Kies 1 om een quiz toe te voegen.");
        System.out.println("Kies 2 om een quiz te wijzigen");
        System.out.println("Kies 3 om uit te loggen.");
        String menuOptie = (String) reader.readLine();
    }

    private void processMedewerkerMenu(String menuOptie) throws IOException {
        switch (menuOptie) {
            case "1":
                System.out.println("Voeg een quiz toe aan het systeem");
                System.out.println("Alle beschikbare vragen in het systeem");
                System.out.println("Kies 8 vragen uit voor de quiz, door het id's van de vragen op te geven");
                printVragen();
                maakNieuweQuiz();
            case "2":
                System.out.println("Wijzig een quiz");
                System.out.println("Kies een quiz om te wijzigen");
                wijzigQuiz();
        }
    }

    private void maakNieuweQuiz() throws IOException {
        int index = 0;
        int[] geselecteerdeIds = new int[8];
        while (index < 8) {
            System.out.println("Er zijn " + index + " vragen geselecteerd.");
            geselecteerdeIds[index] = parseInt(reader.readLine());
            ++index;
        }
        try {
            quizHandler.maakQuiz(geselecteerdeIds);
        } catch(Exception e) {
            maakNieuweQuiz();
        }
        medewerkerMenu();
    }


    private void wijzigQuiz() throws IOException {
        int[] quizIds = quizHandler.getQuizzen();
        for (int i = 0; i < quizIds.length; ++i) {
            System.out.println("Quiz id: " + quizIds[i]);
        }
        int quizId = parseInt(reader.readLine());
        printVragen();
        int index = 0;
        int[] geselecteerdeIds = new int[8];
        while (index < 8) {
            System.out.println("Er zijn " + index + " vragen geselecteerd.");
            geselecteerdeIds[index] = parseInt(reader.readLine());
            ++index;
        }
        try {
            quizHandler.wijzigQuiz(quizId, geselecteerdeIds);
        } catch(Exception e) {
            processMedewerkerMenu("2");
        }
        medewerkerMenu();
    }

    private void printVragen() {
        Map<Integer, String> vragen = quizHandler.getVragen();
        for (Map.Entry<Integer, String> entry : vragen.entrySet()) {
            System.out.println("Id: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

}

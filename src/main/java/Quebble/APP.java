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

    public static void main(String[] args) throws Exception {
        APP app = new APP();
    }

    public APP() throws Exception {
        quizHandler.setDatastore(datastore);
        spelerHandler.setDatastore(datastore);
        medewerkerHandler.setDatastore(datastore);
        this.run();
    }

    private void run() throws Exception {
        String startupKeuze = this.showStartup();
        String ingelogdeGebruiker = processStartup(startupKeuze);
        if (ingelogdeGebruiker != null) {
            System.out.println("Begin een quiz!");
            int quizId = quizHandler.startQuiz(ingelogdeGebruiker);
            Map<String, String[]> quizVragen = quizHandler.ophalenVragen(quizId, ingelogdeGebruiker);
            char[] letters = printVragen(quizId, ingelogdeGebruiker, quizVragen);
            String woord = printLetters(quizId, ingelogdeGebruiker, letters);
            int punten = quizHandler.setWoord(ingelogdeGebruiker, quizId, woord);
            System.out.println("Gefeliciteerd, je hebt " + punten  + " verdient!");
            System.exit(0);
        } else {
            run();
        }
    }

    private String printLetters(int quizId, String speler, char[] letters) throws IOException {
        System.out.println("Maak van de verdiende letters het bonus woord");
        System.out.print("De verkregen letters zijn: ");
        System.out.print("[");
        for (char letter: letters) {
            System.out.print(" " + letter + ", ");
        }
        System.out.print("]");
        return reader.readLine();
    }

    private char[] printVragen(int quizId, String speler, Map<String, String[]> quizVragen) throws IOException {
        int index = 1;
        char[] letters = null;
        String[] opties = {"A", "B", "C", "D"};
        for (Map.Entry<String, String[]> entry : quizVragen.entrySet()) {
            long start = System.currentTimeMillis();
            System.out.println("Vraag " + index);
            System.out.println(entry.getKey());
            if (entry.getValue() != null) {
                int optieIndex = 0;
                for(String s: entry.getValue()) {
                    System.out.println(opties[optieIndex] + ": " + s);
                    ++optieIndex;
                }
            }
            System.out.println("\n");
            System.out.println("Geef een antwoord op de vraag");
            String antwoord = reader.readLine();
            long end = System.currentTimeMillis();
            int time = (int) (end - start) / 1000;
            letters = quizHandler.beantwoordVraag(quizId, speler, index, antwoord, time);
            ++index;
        }
        return letters;
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
                    return null;
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
                    System.out.println(e.getMessage());
                    return (String) showStartup();
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
        processMedewerkerMenu(menuOptie);
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
            case "3":
                System.out.println("Uitlogd!");
                this.showStartup();
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
        for (int id : quizIds) {
            System.out.println("Quiz id: " + id);
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

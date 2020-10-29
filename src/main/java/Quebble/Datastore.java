package Quebble;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Datastore {

    private static Datastore datastore = new Datastore();

    private Datastore() {
        alleQuizzen.add(quiz1);
    }

    public static Datastore getInstance() {
        return datastore;
    }


    public boolean controleerGebruikersnaam(String gebruikersnaam) {
        return false;
    }

    public iVraag[] getAlleActieveVragen() {
        return this.vragenLijst;
    }

    // TODO => Deze nog goed laten werken
    public iQuiz getBeschikbareQuiz(String gebruikersnaam) {
        return alleQuizzen.get(0);
    }

    public iSpeler getSpeler(String gebruikersnaam) throws Exception {
        for (iSpeler speler : geregistreerdeSpelers) {
            if (speler.getGebruikersnaam().equals(gebruikersnaam)) {
                return speler;
            }
        }
        throw new Exception("De speler is niet gevonden in het systeem.");
    }

    public void slaVoortgangOp(iQuiz quiz, String gebruikersnaam) {
        SpelGeschiedenis spelGeschiedenis = null;
        for (SpelGeschiedenis sg: spelGeschiedenisLijst) {
            if (sg.getQuiz().getId() == quiz.getId() && sg.getSpeler().getGebruikersnaam().equals(gebruikersnaam)) {
                sg.setQuiz(quiz);
            }
        }
    }

    public iQuiz getQuiz(int quizId, String gebruikersnaam) {
        return alleQuizzen.get(0);
    }

    public void opslaanScore(SpelGeschiedenis spelGeschiedenis) {
         spelGeschiedenisLijst.add(spelGeschiedenis);
    }

    public void opslaanSpeler(iSpeler speler) {
        for (iSpeler s: geregistreerdeSpelers) {
            if (s.getGebruikersnaam().equals(speler.getGebruikersnaam())) {
                s = speler;
            }
        }
        geregistreerdeSpelers.add(speler);
    }

    public void updateSpeler(iSpeler speler) {
        for (iSpeler s: geregistreerdeSpelers) {
            if (s.getGebruikersnaam().equals(speler.getGebruikersnaam())) {
                s = speler;
            }
        }
    }

    public boolean loginSpeler(String gebruikersnaam, String wachtwoord) throws Exception {
        for (iSpeler speler : geregistreerdeSpelers) {
            if (speler.getGebruikersnaam().equals(gebruikersnaam)) {
                System.out.println(speler.getGebruikersnaam());
                if (speler.getWachtwoord().equals(wachtwoord)) {
                    return true;
                } else {
                    throw new Exception("Wachtwoord is onjuist");
                }
            }
        }
        return false;
    }

    public boolean loginMedewerker(String gebruikersnaam, String wachtwoord) throws Exception {
        for (Medewerker m : medewerkers) {
            if (m.getGebruikersnaam().equals(gebruikersnaam)) {
                System.out.println("haha" + m.wachtwoord);
                if (m.getWachtwoord().equals(wachtwoord)) {
                    return true;
                } else {
                    throw new Exception("Wachtwoord is onjuist");
                }
            }
        }
        return false;
    }

    public iVraag[] getVragen(int[] idVragen) throws Exception {
        List<iVraag> vragenlijst = new ArrayList<>();
        for (int i = 0; i < idVragen.length; ++i) {
            for(iVraag vraag: this.vragenLijst) {
               if (idVragen[i] == vraag.getId()) {
                   vragenlijst.add(vraag);
               }
            }
        }
        if (vragenlijst.size() == 8) {
            iVraag[] vragen = (iVraag[]) vragenlijst.toArray();
            return vragen;
        }
        throw new Exception("Een quiz dient acht vragen te beschikken.");
    }

    public void opslaanQuiz(iQuiz quiz) {
       this.actieveQuizzenLijst.add(quiz);
    }

    public iQuiz[] getAlleQuizzen() {
        return (iQuiz[]) this.alleQuizzen.toArray();
    }

    public iQuiz getQuiz(int quizId) throws Exception {
        for (iQuiz quiz: alleQuizzen) {
            if (quiz.getId() == quizId) {
                return quiz;
            }
        }
        throw new Exception("Er is geen quiz gevonden met dit id");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////// MOCKING DATA  ///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Vraag vraag1 = new KortAntwoordVraag(1, "Wat is de hoofdstad van het Franse departement Vaucluse die we " +
                                                          "kennen uit een heel bekend liedje over een brug?",
                                                  new KortAntwoord[]{new KortAntwoord("Avignon")}, 'A');
    private Vraag vraag2 = new KortAntwoordVraag(2, "Welke band stond in 2008 in de hitparade" +
                                                          " met de song Viva La Vida?",
                                                  new KortAntwoord[]{new KortAntwoord("Coldplay")}, 'C');
    private Vraag vraag3 = new MeerkeuzeVraag(3, "Wat is de hoofdstad van Peru?", new MeerkeuzeAntwoord[]{
                                new MeerkeuzeAntwoord("Arequipa", false), new MeerkeuzeAntwoord("Caracas",
                                                                                                false), new MeerkeuzeAntwoord(
                                "Lima", true), new MeerkeuzeAntwoord("Santiago", false)
                        }, 'L');
    private Vraag vraag4 = new MeerkeuzeVraag(4, "Hoe heet het officieuze landenkampioenschap tennis voor mannen?",
                                               new MeerkeuzeAntwoord[]{
                                                       new MeerkeuzeAntwoord("Davis Cup", true), new MeerkeuzeAntwoord(
                                                       "Diamond League", false), new MeerkeuzeAntwoord("Fed Cup",
                                                                                                       false), new MeerkeuzeAntwoord(
                                                       "Nations League", false)
                                               }, 'D');
    private Vraag vraag5 = new MeerkeuzeVraag(5, "Wat is de voornaam van de schepper van Miss Marple en Hercule " +
            "Poirot?",
                                               new MeerkeuzeAntwoord[]{
                                                       new MeerkeuzeAntwoord("Ruth", false), new MeerkeuzeAntwoord("Emmy",
                                                                                                                   false), new MeerkeuzeAntwoord(
                                                       "Joanne", false), new MeerkeuzeAntwoord("Agatha", true)
                                               }, 'A');
    private Vraag vraag6 = new KortAntwoordVraag(6, "Wat is de bijnaam van de Conservatieve Partij in Engeland?",
                                                  new KortAntwoord[]{
                                                          new KortAntwoord("Tory"), new KortAntwoord(
                                                          "Tories"), new KortAntwoord("The Tories")
                                                  }, 'T');
    private Vraag vraag7 = new MeerkeuzeVraag(7, "Welke van de volgende Engelse voetbalclub is afkomstig uit " +
            "Liverpool?",
                                               new MeerkeuzeAntwoord[]{
                                                       new MeerkeuzeAntwoord("Arsenal", false), new MeerkeuzeAntwoord(
                                                       "Chelsea", false), new MeerkeuzeAntwoord("Everton",
                                                                                                true), new MeerkeuzeAntwoord(
                                                       "Tottenham Hotspur", false)
                                               }, 'E');
    private Vraag vraag8 =  new KortAntwoordVraag(8, "Wat stad ligt in twee continenten?", new KortAntwoord[]{
            new KortAntwoord("Instanboel"), new KortAntwoord("Instanbul")
    }, 'I');

    private iVraag[] vragenLijst = {vraag1, vraag2, vraag3, vraag4, vraag5, vraag6, vraag7, vraag8};

    // Dit is een lijst met quizzen die worden gespeeld
    private List<iQuiz> actieveQuizzenLijst = new ArrayList<>();

    // Dit is een lijst met alle bestaande quizzen in de applicatie
    private iQuiz quiz1 = new Quiz(new Random().nextInt(), vragenLijst);
    private List<iQuiz> alleQuizzen = new ArrayList<>();

    // Dit is een lijst met alle gespeelde quizzen door spelers
    private List<SpelGeschiedenis> spelGeschiedenisLijst = new ArrayList<>();

    // Deze array bevat de medewerkers van Quebble
    Medewerker m1 = new Medewerker("Greta", "Secret1");

    private Medewerker[] medewerkers = {m1};

    // Dit is een lijst met alle geregistreerde spelers
    public ArrayList<iSpeler> geregistreerdeSpelers = new ArrayList<>();

}

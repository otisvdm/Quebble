package Quebble;

import java.util.Random;

public class Datastore {
    public boolean controleerGebruikersnaam(String gebruikersnaam) {return true;}
    public Vraag[] getAlleActieveVragen() {
        return null;
    }
    public Quiz getBeschikbareQuiz(String gebruikersnaam) {
        return mockedQuiz();
    }
    public Speler getSpeler(String gebruikersnaam) {
        return new Speler("speler", "wachtwoord", 50);
    }
    public void slaVoortgangOp(Quiz quiz, String gebruikersnaam) {}

    public Quiz getQuiz(String quizId, String gebruikersnaam) {
        return mockedQuiz();
    }

    public Quiz mockedQuiz() {
        return new Quiz(
                new Random().nextLong(),
                new Vraag[]{
                        new KortAntwoordVraag("Wat is de hoofdstad van het Franse departement Vaucluse die we kennen uit een heel bekend liedje over een brug?", new KortAntwoord[]{new KortAntwoord("Avignon")}, 'A'),
                        new KortAntwoordVraag("Welke band stond in 2008 in de hitparade met de song Viva La Vida?", new KortAntwoord[]{new KortAntwoord("Coldplay")}, 'C'),
                        new MeerkeuzeVraag("Wat is de hoofdstad van Peru?", new MeerkeuzeAntwoord[]{new MeerkeuzeAntwoord("Arequipa", false), new MeerkeuzeAntwoord("Caracas", false), new MeerkeuzeAntwoord("Lima", true), new MeerkeuzeAntwoord("Santiago", false)}, 'L'),
                        new MeerkeuzeVraag("Hoe heet het officieuze landenkampioenschap tennis voor mannen?", new MeerkeuzeAntwoord[]{new MeerkeuzeAntwoord("Davis Cup", true), new MeerkeuzeAntwoord("Diamond League", false), new MeerkeuzeAntwoord("Fed Cup", false), new MeerkeuzeAntwoord("Nations League", false)}, 'D'),
                        new MeerkeuzeVraag("Wat is de voornaam van de schepper van Miss Marple en Hercule Poirot?", new MeerkeuzeAntwoord[]{new MeerkeuzeAntwoord("Ruth", false), new MeerkeuzeAntwoord("Emmy", false), new MeerkeuzeAntwoord("Joanne", false), new MeerkeuzeAntwoord("Agatha", true)}, 'A'),
                        new KortAntwoordVraag("Wat is de bijnaam van de Conservatieve Partij in Engeland?", new KortAntwoord[]{new KortAntwoord("Tory"), new KortAntwoord("Tories"), new KortAntwoord("The Tories")}, 'T'),
                        new MeerkeuzeVraag("Welke van de volgende Engelse voetbalclub is afkomstig uit Liverpool?", new MeerkeuzeAntwoord[]{new MeerkeuzeAntwoord("Arsenal", false), new MeerkeuzeAntwoord("Chelsea", false), new MeerkeuzeAntwoord("Everton", true), new MeerkeuzeAntwoord("Tottenham Hotspur", false)}, 'E'),
                        new KortAntwoordVraag("Wat stad ligt in twee continenten?", new KortAntwoord[]{new KortAntwoord("Instanboel"), new KortAntwoord("Instanbul")}, 'I')
                }
        );
    }

    public void opslaanScore(SpelGeschiedenis spelGeschiedenis) {
        //Sla nieuwe spelgeschiedenis op wanneer de topScore is verbroken
    }
}

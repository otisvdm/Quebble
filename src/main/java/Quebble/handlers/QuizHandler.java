package Quebble.handlers;

import Quebble.Datastore;
import Quebble.MeerkeuzeAntwoord;
import Quebble.MeerkeuzeVraag;
import Quebble.Quiz;
import Quebble.SpelGeschiedenis;
import Quebble.iAntwoord;
import Quebble.iQuiz;
import Quebble.iSpeler;
import Quebble.iVraag;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuizHandler {

    private Datastore datastore;

    public Map<String, String[]> startQuiz(String gebruikersnaam) throws Exception {
        Map<String, String[]> quizVragen = new HashMap<>();
        iQuiz quiz = datastore.getBeschikbareQuiz(gebruikersnaam);
        iSpeler speler = datastore.getSpeler(gebruikersnaam);
        speler.verrekenCredits();
        iVraag[] v = quiz.getVragen();
        for (iVraag vraag: v) {
           if (vraag instanceof MeerkeuzeVraag) {
               String[] antwoorden = ((MeerkeuzeVraag) vraag).getAntwoordenVoorQuiz();
               quizVragen.put(vraag.getVraag(), antwoorden);
           }
        }
        datastore.slaVoortgangOp(quiz, gebruikersnaam);
        return quizVragen;
    }

    public char[] beantwoordVraag(String quizId, String gebruikersnaam, int vraagNummer, String antwoord, int tijd) {
        iQuiz quiz = datastore.getQuiz(quizId, gebruikersnaam);
        quiz.beantwoordVraag(vraagNummer, antwoord, tijd);
        datastore.slaVoortgangOp(quiz, gebruikersnaam);
        if (vraagNummer == 8) {
            char[] letters = quiz.getLetters();

            return letters;
        }
        return null;
    }

    public int setWoord(String gebruikersnaam, String quizId, String woord) {
        iQuiz quiz = datastore.getQuiz(quizId, gebruikersnaam);
        iSpeler speler = datastore.getSpeler(gebruikersnaam);
        quiz.setWoord(woord);
        SpelGeschiedenis sg = quiz.telPunten();
        SpelGeschiedenis sg = new SpelGeschiedenis(speler, quiz, punten);
        datastore.opslaanScore(sg);
        return punten;
    }


    public Map<Integer, String> getVragen() {
        Map<Integer, String> vragen = new HashMap<>();
        iVraag[] actieveVragen = datastore.getAlleActieveVragen();
        for (iVraag vraag: actieveVragen) {
           vragen.put(vraag.getId(), vraag.getVraag());
        }
        return vragen;
    }

    public void maakQuiz(int[] vragenlijst) throws Exception {
        if (vragenlijst.length == 8) {
            iVraag[] geselecteerdeVragen = datastore.getVragen(vragenlijst);
            iQuiz quiz = new Quiz(new Random().nextInt(), geselecteerdeVragen);
            datastore.opslaanQuiz(quiz);
        } else {
            throw new Exception("Een quiz dient acht vragen te beschikken.");
        }
    }

    public void getQuizzen() {
        iQuiz[] quizzen = datastore.getAlleQuizzen();
    }

    public void wijzigQuiz(int quizId, int[] gekozenVragen) throws Exception {
        if (gekozenVragen.length == 8) {
            iVraag[] geselecteerdeVragen = datastore.getVragen(gekozenVragen);
            iQuiz quiz = datastore.getQuiz(quizId);
            quiz.setVragen(geselecteerdeVragen);
            datastore.opslaanQuiz(quiz);
        }
    }

    // Inject datastore instance
    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }

}

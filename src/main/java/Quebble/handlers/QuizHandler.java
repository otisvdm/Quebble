package Quebble.handlers;

import Quebble.Datastore;
import Quebble.MeerkeuzeVraag;
import Quebble.Quiz;
import Quebble.SpelGeschiedenis;
import Quebble.iQuiz;
import Quebble.iSpeler;
import Quebble.iVraag;

import java.util.*;

public class QuizHandler {

    private Datastore datastore;

    public int startQuiz(String gebruikersnaam) throws Exception {
        iQuiz quiz = datastore.getBeschikbareQuiz(gebruikersnaam);
        iSpeler speler = datastore.getSpeler(gebruikersnaam);
        speler.verrekenCredits();
        datastore.updateSpeler(speler);
        return quiz.getId();
    }

    public Map<String, String[]> ophalenVragen(int quizId, String gebruikersnaam) throws Exception {
        iQuiz quiz = datastore.getQuiz(quizId);
        iVraag[] v = quiz.getVragen();
        Map<String, String[]> quizVragen = new LinkedHashMap<>();
        for (iVraag vraag: v) {
           if (vraag instanceof MeerkeuzeVraag) {
               String[] antwoorden = ((MeerkeuzeVraag) vraag).getAntwoordenVoorQuiz();
               quizVragen.put(vraag.getVraag(), antwoorden);
           } else {
               quizVragen.put(vraag.getVraag(), null);
           }
        }
        datastore.slaVoortgangOp(quiz, gebruikersnaam);
        return quizVragen;
    }

    public char[] beantwoordVraag(int quizId, String gebruikersnaam, int vraagNummer, String antwoord, int tijd) {
        iQuiz quiz = datastore.getQuiz(quizId, gebruikersnaam);
        quiz.beantwoordVraag(vraagNummer, antwoord, tijd);
        datastore.slaVoortgangOp(quiz, gebruikersnaam);
        if (vraagNummer >= 8) {
            return quiz.getLetters();
        }
        return null;
    }

    public int setWoord(String gebruikersnaam, int quizId, String woord) {
        iQuiz quiz = datastore.getQuiz(quizId, gebruikersnaam);
        quiz.setWoord(woord);
        SpelGeschiedenis sg = quiz.telPunten();
        datastore.opslaanScore(sg);
        return sg.getPunten();
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

    public int[] getQuizzen() {
        iQuiz[] quizzen = datastore.getAlleQuizzen();
        int[] quizIds = new int[quizzen.length];
        for (int i = 0; i < quizzen.length; ++i) {
            quizIds[i] = quizzen[i].getId();
        }
        return quizIds;
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

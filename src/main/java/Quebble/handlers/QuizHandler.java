package Quebble.handlers;

import Quebble.*;

public class QuizHandler extends Datastore {
    private Quiz quiz;
    private iSpeler speler;

    public String[][] startQuiz(String gebruikersnaam) throws Exception {
        this.quiz = getBeschikbareQuiz(gebruikersnaam);
        this.speler = getSpeler(gebruikersnaam);
        try {
            this.speler.verrekenCredits();
        } catch(Exception e) {
            throw new Exception(e);
        }
        slaVoortgangOp(this.quiz, gebruikersnaam);
        Vraag[] vragen = this.quiz.getVragen();
        String[][] parsedVragen = new String[8][5];

        for (int vraagnummer = 0; vraagnummer < vragen.length; vraagnummer++) {
            parsedVragen[vraagnummer][0] = vragen[vraagnummer].getVraag();
            if (vragen[vraagnummer] instanceof MeerkeuzeVraag)
                for (int mogelijkAntwoordnummer = 1; mogelijkAntwoordnummer < 5; mogelijkAntwoordnummer++) {
                    parsedVragen[vraagnummer][mogelijkAntwoordnummer] = vragen[vraagnummer].getAntwoorden()[mogelijkAntwoordnummer-1].getAntwoord();
                }
        }
        this.quiz = null;
        return parsedVragen;
    }

    public void beantwoordVraag(String quizId, String gebruikersnaam, int vraagNummer, String antwoord, int tijd) {
        if (this.quiz == null) {
            this.quiz = getQuiz(quizId, gebruikersnaam);
        }
        this.quiz.beantwoordVraag(vraagNummer, antwoord, tijd);

        if (vraagNummer == 8) {
            char[] letters = this.quiz.getLetters();
            slaVoortgangOp(quiz, gebruikersnaam);
            this.quiz = null;
            //TODO return letters;
        }
    }

    public int setWoord(String gebruikersnaam, String quizId, String woord) {
        this.quiz = getQuiz(quizId, gebruikersnaam);
        quiz.setWoord(woord);
        int punten = this.quiz.telpunten();
        SpelGeschiedenis sg = new SpelGeschiedenis(this.speler, this.quiz, punten);
        opslaanScore(sg);
        return punten;
    }
}

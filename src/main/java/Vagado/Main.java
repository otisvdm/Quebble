package Vagado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean chooseloginstate = true;
        boolean playerloginstate = false;
        boolean adminloginstate = false;
        boolean shopstate = false;
        boolean quizstate = false;
        int playerId = 0;
        String adminId = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (chooseloginstate) {
            System.out.println("Wilt u inloggen als medewerker(1) of speler(2)?");
            String number = reader.readLine();
            if (number.equals("1")) {
                System.out.println("medewerker");
                chooseloginstate = false;
                adminloginstate = true;
            } else if (number.equals("2")) {
                System.out.println("speler");
                chooseloginstate = false;
                playerloginstate = true;
            }
        }
        while (playerloginstate) {
            System.out.println("playerId:");
            playerId = Integer.parseInt(reader.readLine());
            System.out.println("Wat wilt u doen?");
            System.out.println("Quiz(1)");
            System.out.println("Shop(2)");
            String option = reader.readLine();
            if (option.equals("1")) {
                playerloginstate = false;
                quizstate = true;
            } else if (option.equals("2")) {
                playerloginstate = false;
                shopstate = true;
            }
        }
        while (adminloginstate) {

        }
        while (quizstate) {
            System.out.println("Quiz");
            Quiz quiz = new Quiz(playerId);
            TelStrategie2 strategie2 = new TelStrategie2();
            quiz.maakQuiz(strategie2);
            Vragenlijst[] vragenlijsten = quiz.getBeschikbareVragenlijsten(playerId);
            System.out.println("Kies het ID van een van de vragenlijsten:");
            for (Vragenlijst vragenlijst : vragenlijsten) {
                System.out.println("ID: "+vragenlijst.getId()+" -- Thema: "+vragenlijst.getThema().getNaam());
            }
            String id = reader.readLine();
            quiz.kiesVragenlijst(vragenlijsten[Integer.parseInt(id)-1]);
            for (int i = 0; i < 10; i++) {
                System.out.println(quiz.vragen[i].getVraag());
                if (quiz.vragen[i].isMultipleChoice()) {
                    for (Antwoord antwoord : quiz.vragen[i].getAntwoorden()) {
                        System.out.println(antwoord.getAntwoord());
                    }
                }

                String antwoord = reader.readLine();

                //Implement timer to give time till answer as third parameter
                quiz.beantwoordVraag(antwoord, quiz.vragen[i], 1);
            }
            int punten = quiz.getPunten();
            System.out.println("EINDE QUIZ!");
            System.out.println("Punten: "+punten);
            quizstate = false;
        }
        while (shopstate) {
            System.out.println("Shop");
        }
    }
}

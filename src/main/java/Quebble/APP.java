package Quebble;

import Quebble.handlers.QuizHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APP {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gebruikersnaam = "speler";
        QuizHandler quizHandler = new QuizHandler();

        System.out.println("Nieuwe quiz starten? (Y/N)");
        String confirmation = reader.readLine();
        if (confirmation.equals("Y")) {
            try {
                String[][] vragen = quizHandler.startQuiz(gebruikersnaam);
                int vraagnummer = 0;
                for (String[] vraag : vragen) {
                    vraagnummer++;
                    System.out.println(vraag[0]);
                    if (vraag[1] != null) {
                        for (int i = 1; i < vraag.length; i++) {
                            System.out.println(i + " " +vraag[i]);
                        }
                    }
                    String antwoord = reader.readLine();
                    //TODO Hoe komen we hier aan een quizId? En we moeten nog tijd bij gaan houden kutzooi
                    quizHandler.beantwoordVraag("quizid", gebruikersnaam, vraagnummer, antwoord, 1);
                }
                System.out.println();
            } catch(Exception e) {
                //TODO dit is niet netjes en moet anders
                e.printStackTrace();
            }


        }
    }
}

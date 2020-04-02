package Vagado;

import java.util.HashMap;
import java.util.Map;

public class Vraag {

    private String vraag;
    private boolean isMultipleChoice;
    private iAntwoord iAntwoord;

    public Vraag(String vraag, boolean isMultipleChoice) {
        this.vraag = vraag;
        this.isMultipleChoice = isMultipleChoice;
    }

    public Map<String, String[]> getVraag() {
        if (isMultipleChoice) {
            iAntwoord = new MeerKeuzeAntwoord();
            Map<String, String[]> antwoorden = new HashMap<>();
            antwoorden.put("meerkeuze", iAntwoord.getAlleOpties());
            return antwoorden;
        }
        Map<String, String[]> openAntwoord = new HashMap<>();
        openAntwoord.put("open", null);
        return openAntwoord;
    }


}

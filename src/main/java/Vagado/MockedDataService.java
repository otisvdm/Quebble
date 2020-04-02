package Vagado;

public class MockedDataService {
    public Vraag[] getMockVragen() {
        return new Vraag[]{
                new Vraag("Vraag1", true),
                new Vraag("Vraag2", false),
                new Vraag("Vraag3", false),
                new Vraag("Vraag4", false),
                new Vraag("Vraag5", true),
                new Vraag("Vraag6", false),
                new Vraag("Vraag7", true),
                new Vraag("Vraag8", true),
                new Vraag("Vraag9", true),
                new Vraag("Vraag10", false)
        };
    }

    public Vragenlijst[] getMockVragenlijsten() {
        Thema thema = new Thema();
        thema.maakThema("Thema1");
        return new Vragenlijst[]{
                new Vragenlijst(
                        this.getMockVragen(),
                        "1",
                        thema
                )
        };
    }

    public String[] getOpties() {
        return new String[]{"1", "2", "3", "4", "5"};
    }

    public String getAntwoord() {
        return "1";
    }
}

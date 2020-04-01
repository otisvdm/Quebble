package Vagado;

public class MockedDataService {
    public Vraag[] getMockVragen() {
        return new Vraag[]{
                new Vraag("Vraag1"),
                new Vraag("Vraag2"),
                new Vraag("Vraag3"),
                new Vraag("Vraag4"),
                new Vraag("Vraag5"),
                new Vraag("Vraag6"),
                new Vraag("Vraag7"),
                new Vraag("Vraag8"),
                new Vraag("Vraag9"),
                new Vraag("Vraag10")
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

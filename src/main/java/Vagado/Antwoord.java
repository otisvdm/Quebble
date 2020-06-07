package Vagado;

public class Antwoord {
    MockedDataService mockedDataService = new MockedDataService();
    private String antwoord;
    private boolean isJuist;
    public Antwoord(String antwoord, boolean isJuist) {
        this.antwoord = antwoord;
        this.isJuist = isJuist;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public boolean isJuist() {
        return isJuist;
    }
}

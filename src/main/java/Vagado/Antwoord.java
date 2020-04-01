package Vagado;

public abstract class Antwoord implements iAntwoord{
    MockedDataService mockedDataService = new MockedDataService();

    protected String antwoord;
    private String[] foutieveOpties;
    public String getAntwoord() {
        return mockedDataService.getAntwoord();
    }
}

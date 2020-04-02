package Vagado;

public abstract class Antwoord implements iAntwoord{
    MockedDataService mockedDataService = new MockedDataService();
    protected String antwoord = mockedDataService.getAntwoord();
    public abstract String[] getAlleOpties();
    public String getAntwoord() {
        return antwoord;
    }
}

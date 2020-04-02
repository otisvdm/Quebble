package Vagado;

public class MeerKeuzeAntwoord extends Antwoord {

    public MeerKeuzeAntwoord() {
        super();
    }
    private MockedDataService mockedDataService = new MockedDataService();
    private String[] mogelijkheden = mockedDataService.getOpties();

    @Override
    public String[] getAlleOpties() {
        String[] opties = new String[mogelijkheden.length+1];
        opties[0] = super.antwoord;
        for (int i = 1; i <= mogelijkheden.length; ++i) {
            opties[i] = mogelijkheden[i - 1];
        }
        return opties;
    }
}

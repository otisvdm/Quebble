package Vagado;

import java.util.ArrayList;
import java.util.Random;

public class Vragenlijst {
    MockedDataService mockedDataService = new MockedDataService();

    private String id;
    private Vraag[] vragen;
    private Thema thema;

    public Vragenlijst(Vraag[] vragen, String id, Thema thema) {
        this.id = id;
        this.vragen = vragen;
        this.thema = thema;
    }

    public Vraag[] getWillekeurigeVragen(Vragenlijst lijst) {
        // replace with actual randomizer based on given list
        return vragen;
    }

    public Vragenlijst[] getBeschikbareVragenlijsten(String playerId) {
        return mockedDataService.getMockVragenlijsten();
    }

    public Thema getThema() {
        return thema;
    }

    public void setThema(Thema thema) {
        this.thema = thema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package Vagado;

public class Vragenlijst {

    private String id;
    private Vraag[] vragen;
    private Thema thema;

    public Vragenlijst(Vraag[] vragen, String id, Thema thema) {
        this.id = id;
        this.vragen = vragen;
    }

    public Vraag[] getWillekeurigeVragen(Vragenlijst lijst) {
        // Hard coded
        vragen = new Vraag[]{
                new Vraag(1),
                new Vraag(2),
                new Vraag(3),
                new Vraag(4),
                new Vraag(5),
                new Vraag(6),
                new Vraag(7),
                new Vraag(8),
                new Vraag(9),
                new Vraag(10)
        };

        // Implementation based on lijstId

        // vragen =

        return vragen;
    }

    public Vragenlijst[] getBeschikbareVragenlijsten(String playerId) {
        // Hard coded
        thema = new Thema();
        thema.maakThema("Thema1");
        Vragenlijst[] vragenlijsten = new Vragenlijst[]{
                new Vragenlijst(
                        new Vraag[]{
                                new Vraag(1),
                                new Vraag(2),
                                new Vraag(3),
                                new Vraag(4),
                                new Vraag(5),
                                new Vraag(6),
                                new Vraag(7),
                                new Vraag(8),
                                new Vraag(9),
                                new Vraag(10)
                        },
                        "1",
                        thema
                        )
        };

        // Implementation based on playerId

        // Vragenlijst[] vragenlijsten =

        return vragenlijsten;
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

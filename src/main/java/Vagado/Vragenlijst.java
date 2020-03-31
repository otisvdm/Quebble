package Vagado;

public class Vragenlijst {
    String id;
    Vraag[] vragen;
    Thema thema;

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
}

package Vagado;

public class Shop {
    public ShopItem[] getVragenlijsten() {
        return (new ShopItem[]{
            new ShopItem(
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
                            new Thema()
                    ))
        });

        // get available questionnaires from json data
    }

    public void koopVragenlijst(String playerId, ShopItem item) {
        // Add playerId and shopitem to json data of purchase
    }

    private boolean controleerSaldo(float saldo, ShopItem item) {
        // Hard coded
        return true;

        // Implementation based on json data of player:
    }
}

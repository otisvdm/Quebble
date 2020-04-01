package Vagado;

import java.util.Date;

public class Aankoop {
    private Date datum;
    private int lifeTimeBest;

    public void opslaanAankoop(Date datum, ShopItem item) {
        this.datum = datum;
        // Save purchase data as json
    }

    public void opslaanLifeTimeBest(int lifeTimeBest) {
        this.lifeTimeBest = lifeTimeBest;

        // save lifetimebest in json data for this aankoop
    }
}

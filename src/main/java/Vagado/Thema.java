package Vagado;

import java.util.UUID;

public class Thema {
    String id;
    String naam;

    public Thema() {
        id = UUID.randomUUID().toString();
    }

    public Thema[] getThemas() {
        // Hard coded
        Thema[] themas = new Thema[]{new Thema()};

        // Implementation based on json data
        // Thema[] themas =

        return themas;
    }

    public void maakThema(String naam) {
        // Create json data for theme with name
        this.naam = naam;
    }

    public void verwijderThema(String id) {
        // Delete json data for theme with id
    }
}

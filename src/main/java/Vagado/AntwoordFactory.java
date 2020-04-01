package Vagado;

public class AntwoordFactory {
public Antwoord getJuisteAntwoord(){

}
public Antwoord[] getJuisteAntwoorden() {
    return new MeerKeuzeAntwoord().getAlleOpties();
}
}

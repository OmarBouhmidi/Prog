/**
 * Oppgave1:
 * Eksempel på state problem:
 * Vi skal implementere et program for en El-sykkel med tre gir. Når gir-opp knappen trykkes på,
 * skal hastigheten på El-sykkelen økes, og når gir-ned knappen trykkes på skal hastigheten minkes.
 */
interface ElsykkelStatus {
    ElsykkelStatus girOpp();

    ElsykkelStatus girNed();

    String getStatus();
}

class Elsykkel_Førstegir implements ElsykkelStatus {

    @Override
    public ElsykkelStatus girOpp() {
        return new Elsykkel_Andregir();
    }

    @Override
    public ElsykkelStatus girNed() {
        return new Elsykkel_Førstegir();
    }

    @Override
    public String getStatus() {
        return "Første gir";
    }
}

class Elsykkel_Andregir implements ElsykkelStatus {

    @Override
    public ElsykkelStatus girOpp() {
        return new Elsykkel_Tredjegir();
    }

    @Override
    public ElsykkelStatus girNed() {
        return new Elsykkel_Førstegir();
    }

    @Override
    public String getStatus() {
        return "Andre gir";
    }
}

class Elsykkel_Tredjegir implements ElsykkelStatus {

    @Override
    public ElsykkelStatus girOpp() {
        return new Elsykkel_Tredjegir();
    }

    @Override
    public ElsykkelStatus girNed() {
        return new Elsykkel_Andregir();
    }

    @Override
    public String getStatus() {
        return "Tredje gir";
    }
}

class Elsykkel {
    ElsykkelStatus status = new Elsykkel_Førstegir();

    //gir opp
    public void giropp() {
        status = status.girOpp();
    }

    //gir ned
    public void girned() {
        status = status.girNed();
    }

    public void printStatus() {
        System.out.println(status.getStatus());
    }
}

public class State {

    public static void main(String[] args) {
        Elsykkel elsykkel = new Elsykkel();

        elsykkel.giropp();
        elsykkel.printStatus();
        elsykkel.giropp();
        elsykkel.printStatus();
        elsykkel.girned();
        elsykkel.printStatus();

    }
}

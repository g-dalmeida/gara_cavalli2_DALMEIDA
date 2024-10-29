import java.util.ArrayList;

public class Gara {
    private ArrayList<Cavallo> cavalli;
    private int percorso;

    public Gara(int percorso) {
        this.percorso = percorso;
        this.cavalli = new ArrayList<>();
    }

    public void addCavallo(String nome) {
        Cavallo cavallo = new Cavallo(nome, percorso);
        cavalli.add(cavallo);
    }

    public void startGara() {
        System.out.println("Gara iniziata");

        Cavallo.resetGara();

        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Gara terminata");
    }


}

import java.util.Random;

public class Cavallo extends Thread {
    private String nome;
    private int percorso;
    private int metriPercorsi = 0;
    private static boolean garaTerminata = false;

    public Cavallo(String nome, int percorso) {
        this.nome = nome;
        this.percorso = percorso;
    }

    public void run() {
        Random random = new Random();

        while (!garaTerminata && metriPercorsi < percorso) {
            int step = random.nextInt(10) + 1;
            metriPercorsi += step;
            if (metriPercorsi >= percorso) {
                metriPercorsi = percorso;
                garaTerminata = true;
                System.out.println(nome + "ha vinto la gara percorrendo " + metriPercorsi + "metri");
            } else System.out.println(nome + "ha percorso " + metriPercorsi + "metri");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetGara() {
        garaTerminata = false;
    }
}

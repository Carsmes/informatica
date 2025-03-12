import java.util.ArrayList;
import java.util.Scanner;

public class ListaAttesaPazienti {
    private static Queue codaPazienti = new Queue();
    private static int prossimoNumero = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\nGestione lista d'attesa");
            System.out.println("1. Entrata di un paziente");
            System.out.println("2. Estrazione del paziente");
            System.out.println("3. Stampa pazienti in lista d'attesa");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> aggiungiPaziente();
                case 2 -> estraiPaziente();
                case 3 -> stampaListaAttesa();
                case 0 -> System.out.println("Chiusura del programma.");
                default -> System.out.println("Opzione non valida.");
            }
        } while (scelta != 0);

        scanner.close();
    }

    private static void aggiungiPaziente() {
        codaPazienti.add(prossimoNumero++);
        System.out.println("Paziente aggiunto alla lista d'attesa.");
    }

    private static void estraiPaziente() {
        if (codaPazienti.isEmpty()) {
            System.out.println("Nessun paziente in lista d'attesa.");
        } else {
            int paziente = (int) codaPazienti.remove();
            System.out.println("Paziente numero " + paziente + " chiamato per la visita.");
        }
    }

    private static void stampaListaAttesa() {
        if (codaPazienti.isEmpty()) {
            System.out.println("Nessun paziente in lista d'attesa.");
        } else {
            System.out.println("Pazienti in lista d'attesa: " + codaPazienti.elementi);
        }
    }
}

class Queue {
    public ArrayList<Integer> elementi;

    public Queue() {
        elementi = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elementi.isEmpty();
    }

    public void add(int value) {
        elementi.add(value);
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Coda vuota, nessun paziente da estrarre.");
            return -1;
        } else {
            return elementi.remove(0);
        }
    }
}

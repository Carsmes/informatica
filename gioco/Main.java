import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Movimenti");
        GamePanel gioco = new GamePanel();

        frame.add(gioco);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Inserisci un movimento (w, a, s, d), 'N' per tornare indietro, 'x' per ripristinare o 'exit' per uscire:");
                String input = scanner.nextLine().trim().toLowerCase();

                switch (input) {
                    case "exit":
                        System.exit(0);
                        break;

                    case "n":
                        gioco.reverse();
                        break;

                    case "x":
                        gioco.reset();
                        break;

                    case "w":
                    case "a":
                    case "s":
                    case "d":
                        gioco.move(input.charAt(0));
                        break;

                    default:
                        System.out.println("Comando non valido.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Errore durante l'inserimento.");
        } finally {
            scanner.close();
        }
    }
}
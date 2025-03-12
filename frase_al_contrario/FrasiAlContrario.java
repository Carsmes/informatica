import java.util.ArrayList;
import java.util.Scanner;

class Pila {
    private ArrayList<String> elementi;

    public Pila() {
        elementi = new ArrayList<>();
    }

    public void push(String parola) {
        elementi.add(parola);
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            return elementi.remove(elementi.size() - 1);
        }
    }

    public boolean isEmpty() {
        return elementi.isEmpty();
    }
}

public class FrasiAlContrario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una frase: ");
        String frase = scanner.nextLine();
        String[] parole = frase.split(" ");

        Pila pila = new Pila();

        for (String parola : parole) {
            pila.push(parola);
        }

        System.out.println("Frase invertita:");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }

        scanner.close();
    }
}

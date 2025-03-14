import java.util.ArrayList;

public class Stack {
    private ArrayList<String> elementi;

    public Stack() {
        elementi = new ArrayList<>();
    }

    public void push(String movimento) {
        if (elementi.size() < 10) {
            elementi.add(movimento);
        } else {
            System.out.println("Hai raggiunto il limite massimo di 10 movimenti.");
        }
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

    public int size() {
        return elementi.size();
    }
    public void clear() {
        elementi.clear();
    }
}
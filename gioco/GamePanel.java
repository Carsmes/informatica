import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    private int x = 150, y = 150;
    private Stack movimenti;
    private char direzioneCorrente = 'w';
    public GamePanel() {
        movimenti = new Stack();
        setPreferredSize(new Dimension(300, 300));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.black);
        Polygon freccia = new Polygon();
        if (direzioneCorrente == 'w') { 
            freccia.addPoint(x, y - 15);
            freccia.addPoint(x - 10, y + 10);
            freccia.addPoint(x + 10, y + 10);
        } else if (direzioneCorrente == 's') {
            freccia.addPoint(x, y + 15);
            freccia.addPoint(x - 10, y - 10);
            freccia.addPoint(x + 10, y - 10);
        } else if (direzioneCorrente == 'a') {
            freccia.addPoint(x - 15, y);
            freccia.addPoint(x + 10, y - 10);
            freccia.addPoint(x + 10, y + 10);
        } else if (direzioneCorrente == 'd') {
            freccia.addPoint(x + 15, y);
            freccia.addPoint(x - 10, y - 10);
            freccia.addPoint(x - 10, y + 10);
        }

        g.fillPolygon(freccia);
    }

    public void move(char direzione) {
        if (movimenti.size() >= 10) {
            System.out.println("Hai raggiunto il limite massimo di 10 movimenti.");
            return;
        }
        direzioneCorrente = direzione;
        switch (direzione) {
            case 'w':
                movimenti.push("w");
                y -= 10;
                break;
            case 's':
                movimenti.push("s");
                y += 10;
                break;
            case 'a':
                movimenti.push("a");
                x -= 10;
                break;
            case 'd':
                movimenti.push("d");
                x += 10;
                break;
            default:
                break;
        }
        repaint();
    }

    public void reverse() {
        while (!movimenti.isEmpty()) {
            String movimento = movimenti.pop();
            if (movimento != null) {
                switch (movimento) {
                    case "w":
                        direzioneCorrente = 's';
                        y += 10;
                        break;
                    case "s":
                        direzioneCorrente = 'w';
                        y -= 10;
                        break;
                    case "a":
                        direzioneCorrente = 'd';
                        x += 10;
                        break;
                    case "d":
                        direzioneCorrente = 'a';
                        x -= 10;
                        break;
                }
                repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
    public void reset() {
        x = 150;
        y = 150;
        direzioneCorrente = 'w';
        movimenti.clear();
        repaint();
    }
}

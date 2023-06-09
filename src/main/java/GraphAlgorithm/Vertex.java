package GraphAlgorithm;

import java.awt.*;

public class Vertex extends Component {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(getX()-25,getY()-25,50,50);

    }

    private int x;
    private int y;


    public Vertex(int xPosition, int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        int size = 50;  // Rozmiar wierzchołka
        int x = getX() - size/2;  // Współrzędna X lewego górnego rogu wierzchołka
        int y = getY() - size/2;  // Współrzędna Y lewego górnego rogu wierzchołka

        return mouseX >= x && mouseX <= x + size && mouseY >= y && mouseY <= y + size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

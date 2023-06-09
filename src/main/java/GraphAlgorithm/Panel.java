package GraphAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Panel extends JPanel implements MouseListener, MouseMotionListener {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Vertex vertex : graph.getVerticesNotConnected()){
            vertex.paint(g);
        }

        for (Edge edge : graph.getEdgesList()){
            edge.paint(g);
        }
    }

    private Graph graph;
    public Panel(){

        graph = new Graph();
        addMouseListener(this);
        addMouseMotionListener(this);

        setSize(750,750);



    }

    private Vertex selectedVertex;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            graph.getVerticesNotConnected().add(new Vertex(e.getX(),e.getY()));
            repaint();
            System.out.println("klik");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {

            for (Vertex vertex : graph.getVerticesNotConnected()) {
                if (vertex.isMouseOver(e.getX(),e.getY())) {
                    selectedVertex = vertex;
                    break;
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedVertex = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedVertex != null) {
            selectedVertex.setX(e.getX());
            selectedVertex.setY(e.getY());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

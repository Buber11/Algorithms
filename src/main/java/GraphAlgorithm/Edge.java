package GraphAlgorithm;

import java.awt.*;

public class Edge extends Component {
    private Vertex v1;
    private Vertex v2;
    private int weight;
    private boolean directed;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    public Edge(Vertex v1, Vertex v2, int weight, boolean directed) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        this.directed = directed;
    }

    public Edge(Vertex v1,int weight,boolean directed) {
        this.v1 = v1;
        this.v2 = null;
        this.weight = weight;
        this.directed = directed;
    }

}

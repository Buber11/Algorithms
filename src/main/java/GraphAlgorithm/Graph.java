package GraphAlgorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Graph {

    private ArrayList<Vertex> verticesNotConnected;
    private ArrayList<Edge> edgesList;
    public Graph() {

        edgesList = new ArrayList<>();
        verticesNotConnected = new ArrayList<>();

    }

    public ArrayList<Edge> getEdgesList() {
        return edgesList;
    }

    public ArrayList<Vertex> getVerticesNotConnected() {
        return verticesNotConnected;
    }


}

package GraphAlgorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private LinkedList<Vertex> verticesNotConnected;
    private LinkedList<Edge> edgesList;
    public Graph() {

        edgesList = new LinkedList();
        verticesNotConnected = new LinkedList();

    }

    public  LinkedList<Edge> getEdgesList() {
        return edgesList;
    }

    public  LinkedList<Vertex> getVerticesNotConnected() {
        return verticesNotConnected;
    }


}

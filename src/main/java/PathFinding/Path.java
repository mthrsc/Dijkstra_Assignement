package PathFinding;

/**
 *
 * @author Matthieu Roscio
 * Path.java
 * 18 11 2020
 */
public class Path {

    int node;
    double distanceFromSource;
    int previousNode;

    public Path(int node, double distanceFromSource, int previousNode) {
        this.node = node;
        this.distanceFromSource = distanceFromSource;
        this.previousNode = previousNode;
    }

    public Path() {
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public double getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public int getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(int previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        String s = new String();

        s = "Node: " + (node + 1) + " - Distance from source: " + distanceFromSource
                + " - previous node: " + (previousNode + 1);

        return s;
    }
}

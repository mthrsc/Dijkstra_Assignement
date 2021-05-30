package Dijkstra;

import MathStuff.Calculus;
import PathFinding.PathFinding;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthieu Roscio
 * Dijkstra.java
 * 18 11 2020
 */
public class Dijkstra {

    int vertices;
    PathFinding pathFinding;
    Calculus calculus;
    double[][] distanceTable;

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        pathFinding = new PathFinding();
        calculus = new Calculus();
    }

    public void DijAlg(double[][] arr2d, int source) {
        //'cloud' of visited node
        boolean[] visited = new boolean[vertices];
        //distance from source for each nodes
        double distanceFromSource[] = new double[vertices];
        //adjancy matrix
        distanceTable = arr2d;

        //Initialization
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            distanceFromSource[i] = Integer.MAX_VALUE;
        }
        distanceFromSource[source] = 0;
        
        //Creating source node for path finding. Note the -1 as previous node
        pathFinding.addNode(source, distanceFromSource[source], -1);

        for (int k = 0; k < vertices - 1; k++) {
            //Find closest node of current node
            int closestNode = calcClosestNode(distanceFromSource, visited);
            //closest node is now visited
            visited[closestNode] = true;
            //We have our closest node (the line in the matrix), now we look at the column values of the said line
            for (int col = 0; col < vertices; col++) {
                if (!visited[col]
                        && distanceTable[closestNode][col] != 0
                        && distanceFromSource[closestNode] != Integer.MAX_VALUE
                        && distanceFromSource[closestNode] + distanceTable[closestNode][col] < distanceFromSource[col]) {
                    distanceFromSource[col] = distanceFromSource[closestNode] + distanceTable[closestNode][col];
                    distanceFromSource[col] = roundDouble(distanceFromSource[col]);
                    //Adding discovered node to the pathfinding, with the closestNode as predecessor
                    pathFinding.addNode(col, distanceFromSource[col], closestNode);
                }
            }
        }
    }

    int calcClosestNode(double[] distanceFromSource, boolean[] visited) {
        double minDist = Float.MAX_VALUE;
        int nodeIndex = -99;

        for (int i = 0; i < distanceFromSource.length; i++) {
            if (distanceFromSource[i] <= minDist && !visited[i]) {
                minDist = distanceFromSource[i];
                nodeIndex = i;
            }
        }
        return nodeIndex;
    }

    public void getShortestPath(int source, int destination) {
        pathFinding.getShortestPath(source, destination);
    }

    public void showCalculus() {
        double sum;
        double average;
        double standDev;

        sum = calculus.getSum(pathFinding.getResultList(), distanceTable);
        sum = roundDouble(sum);
        average = calculus.getAverage(pathFinding.getResultList(), distanceTable);
        average = roundDouble(average);
        standDev = calculus.getStandDev(pathFinding.getResultList(), distanceTable);
        standDev = roundDouble(standDev);
        String output = new String();
        
        output += "Path resolved in " + (pathFinding.getResultList().size() - 1) + " hops\n";
        
        for (int i = 0; i < pathFinding.getResultList().size(); i++) {
            output += pathFinding.getResultList().get(i) + "\n";
        }
        output += "\nThe sum of the path is " + sum
                + "\nThe average is " + average
                + "\nThe standard deviation is " + standDev;

        JOptionPane.showMessageDialog(null, output);

    }

    private double roundDouble(double in) {
        double out = 0.00;
        out = (double) Math.round(in * 100) / 100;
        return out;
    }
}

package MathStuff;

import PathFinding.Path;
import java.util.LinkedList;

/**
 *
 * @author Matthieu Roscio
 * Calculus.java
 * 18 11 2020
 */
public class Calculus {

    double sum;
    double average;
    double standDev;

    public double getSum(LinkedList<Path> resultList, double[][] distanceTable) {
        double d = 0.00;

        for (int i = 0; i < resultList.size() - 1; i++) {
            int a = resultList.get(i).getNode();
            int b = resultList.get(i + 1).getNode();
            d = d + distanceTable[a][b];
        }
        return d;
    }

    public double getAverage(LinkedList<Path> resultList, double[][] distanceTable) {
        double d = 0.00;
        for (int i = 0; i < resultList.size() - 1; i++) {
            int a = resultList.get(i).getNode();
            int b = resultList.get(i + 1).getNode();
            d = d + distanceTable[a][b];
        }
        d = d / (resultList.size() - 1);
        return d;
    }

    public double getStandDev(LinkedList<Path> resultList, double[][] distanceTable) {
        double d = 0.00;
        for (int i = 0; i < resultList.size() - 1; i++) {
            int a = resultList.get(i).getNode();
            int b = resultList.get(i + 1).getNode();
            double temp = distanceTable[a][b] * distanceTable[a][b];
            d = d + temp;
        }
        d = d / (resultList.size() - 1);
        return d;
    }
}

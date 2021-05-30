package importCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthieu Roscio
 * CSVReader.java
 * 18 11 2020
 */
public class CSVReader {

    String fileName;
    FileReader fr;
    BufferedReader in;
    LinkedList<Integer> vertList;

    public CSVReader() {
    }

    //This method reads each line of the CSV
    //It uses StringTokenizer with "," as a separator to only access the source of the edge connection
    //If a source is not in the file, the method will add it to a LinkedList
    //If it is already in the file, the method will go to the next line
    //At the en of the method, I just return the size of the LL to get the amount of vertices
    public int getVerticesAmount() {
        int va  = 0;
        vertList = new LinkedList();

        fileName = "edges.csv";
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        in = new BufferedReader(fr);
        String line = new String();
        try {
            while ((line = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                int v = Integer.parseInt(st.nextToken(","));
                if (!isVertInList(v)) {
                    vertList.add(v);
                }
                va  = vertList.size();
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return va;
    }

    //Boolean to check if a vertex is already in the list
    boolean isVertInList(int v) {
        boolean b = false;
        if (vertList.contains(v)) {
            b = true;
        }
        return b;
    }

    //This method translate the csv file into a 2d array
    //It also use StringTokenizer with "," as a separator
    //source and destination are stored in int and the weight is stored in a double
    //Then x and y are used as coordinate to store the weight in the right position
    public double[][] csvToArray(int vertices) {
        double[][] arr2d = new double[vertices][vertices];
        fileName = "edges.csv";
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        in = new BufferedReader(fr);
        String line = new String();

        try {
            while ((line = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                int x = Integer.parseInt(st.nextToken(","));
                int y = Integer.parseInt(st.nextToken(","));
                double v = Double.parseDouble(st.nextToken(","));
                arr2d[x - 1][y - 1] = v;
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr2d;
    }
}

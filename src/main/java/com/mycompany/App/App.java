package com.mycompany.App;

import Dijkstra.Dijkstra;
import Input.UserInput;
import importCSV.CSVReader;

/**
 *
 * @author Matthieu Roscio
 * App.java
 * 18/11/2020
 */
public class App {

    public static void main(String[] args) {
        //Count the number of vertices in the CSV file
        CSVReader csvReader = new CSVReader();
        UserInput userInput = new UserInput();
        
        int vertices = csvReader.getVerticesAmount();

        Dijkstra dij = new Dijkstra(vertices);

        //Load csv file in Array 
        double[][] distanceTable = csvReader.csvToArray(vertices);

        //Print matrix
//        for (int i = 0; i < distanceTable.length; i++) {
//            for (int j = 0; j < distanceTable.length; j++) {
//                System.out.print(distanceTable[i][j] + " ");
//            }
//            System.out.println();
//        }

        //Get user input
        userInput.promptUser(vertices);

        int source = userInput.getInput1() - 1;
        int destination = userInput.getInput2() - 1;
        
        //Start dijkstra from source
        dij.DijAlg(distanceTable, source);
        //Generate shortest path
        dij.getShortestPath(source, destination);
        //Display all requiered results
        dij.showCalculus();
    }
}

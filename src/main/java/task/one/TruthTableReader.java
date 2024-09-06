package task.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TruthTableReader {

    public static int[][] readTruthTableFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int numVars = scanner.nextInt();
        int numRows = 1 << numVars;
        int[][] truthTable = new int[numRows][numVars + 1];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= numVars; j++) {
                truthTable[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        return truthTable;
    }
}
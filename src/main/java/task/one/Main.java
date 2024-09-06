package task.one;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/main/java/task/one/input.txt";

        try {
            int[][] truthTable = TruthTableReader.readTruthTableFromFile(inputFile);

            String result = ZhegalkinPolynomial.computeZhegalkinPolynomial(truthTable);
            System.out.println("Полином Жегалкина: " + result);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
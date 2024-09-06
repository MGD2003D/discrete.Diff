package task.one;

import java.util.List;
import java.util.ArrayList;

public class ZhegalkinPolynomial {

    public static String computeZhegalkinPolynomial(int[][] truthTable) {
        int numVars = truthTable[0].length - 1;
        int numTerms = 1 << numVars;

        int[] coefficients = new int[numTerms];

        for (int[] row : truthTable) {
            int index = 0;
            for (int j = 0; j < numVars; j++) {
                if (row[j] == 1) {
                    index |= (1 << j);
                }
            }
            coefficients[index] ^= row[numVars];
        }

        return generatePolynomial(coefficients, numVars);
    }

    private static String generatePolynomial(int[] coefficients, int numVars) {
        List<String> terms = new ArrayList<>();

        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] == 1) {
                StringBuilder term = new StringBuilder();
                for (int j = 0; j < numVars; j++) {
                    if ((i & (1 << j)) != 0) {
                        if (term.length() > 0) {
                            term.append(" * ");
                        }
                        term.append((char) ('a' + j));
                    }
                }
                terms.add(term.length() == 0 ? "1" : term.toString());
            }
        }

        return String.join(" + ", terms);
    }
}
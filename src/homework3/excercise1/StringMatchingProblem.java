package homework3.excercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatchingProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String P = "abc";
        String T = "abcaabccccabbbacbabc";
        List<Integer> occurrences = stringMatching(P, T);
        System.out.println("Occurrences found at indices: " + occurrences);
    }

    public static List<Integer> stringMatching(String P, String T) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < T.length() - P.length() + 1; i++) {
            int j = 0;
            while (j < P.length() && (P.charAt(j) == T.charAt(i + j))) {
                j++;
            }
            if (j == P.length()) {
                indices.add(i);
            }
        }
        return indices;
    }
}

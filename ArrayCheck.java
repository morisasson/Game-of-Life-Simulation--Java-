package Ex5;

import java.util.HashSet;
import java.util.Set;

public class ArrayCheck {
    public static boolean checkElements(int[] A, int[] B, int[] C) {
        Set<Integer> elementsSet = new HashSet<>();

        for (int num : A) {
            elementsSet.add(num);
        }
        for (int num : B) {
            elementsSet.add(num);
        }
        for (int num : C) {
            if (!elementsSet.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};
        int[] C = {2, 5, 3};

        boolean result = checkElements(A, B, C);
        System.out.println(result);
    }
}
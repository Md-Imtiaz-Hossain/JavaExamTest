package problem_03;

public class HackerFind {
    public static void main(String[] args) {
        int numDigits = 3;
        generateWellOrdered(numDigits, 0, "");
    }

    public static void generateWellOrdered(int remainingDigits, int previousDigit, String result) {
        if (remainingDigits == 0) {
            System.out.println(result);
            return;
        }

        for (int i = previousDigit + 1; i <= 9; i++) {
            generateWellOrdered(remainingDigits - 1, i, result + i);
        }
    }
}

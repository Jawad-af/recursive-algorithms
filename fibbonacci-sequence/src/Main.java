public class Main {

    public static int findFibbonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return findFibbonacci(n - 1) + findFibbonacci(n - 2);
    }

    public static void printFibbonacciSequence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(findFibbonacci(i) + " ");
        }
    }

    public static void main(String[] args) {
        printFibbonacciSequence(25);
    }
}
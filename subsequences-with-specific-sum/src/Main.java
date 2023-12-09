import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void printArray(ArrayList<Integer> array) {
        Consumer<Integer> printArray = (element) -> System.out.print(element + " ");
        System.out.print("[ ");
        array.forEach(printArray);
        System.out.print("]");
        System.out.println();
    }
    public static void printSpecificSum(int[] initArray, int sum, int maxArraySize) {
        int currentSum = 0;
        ArrayList<Integer> array = new ArrayList<>();
        if (!printSum(0, array, initArray, sum, currentSum, maxArraySize)) {
            System.out.println("There are no " + maxArraySize + " elements that adds up to " + sum);
        }
    }
    public static boolean printSum(int index, ArrayList<Integer> array, int[] initArray, int sum, int currentSum, int maxArraySize) {
        int length = initArray.length;
        if (index == length) {
            if (currentSum == sum && array.size() <= maxArraySize) {
                printArray(array);
                return true;
            } else {
                return false;
            }
        }
        array.add(initArray[index]);
        currentSum += initArray[index];

        if (printSum(index + 1, array, initArray, sum, currentSum, maxArraySize)) {
            return true;
        }
        array.remove(array.size() - 1);
        currentSum -= initArray[index];
        if(printSum(index + 1, array, initArray, sum, currentSum, maxArraySize)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] initArray = {-2, -3, 1, 1, 1, 0, -1, 2, 1, 1};
        System.out.print("The elements with sum = -5 => ");
        printSpecificSum(initArray, -5, 3);
        printSpecificSum(initArray, -9, 3);
    }
}
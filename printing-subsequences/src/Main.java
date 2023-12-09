import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

public class Main {

    public static void printSubsequences(int[] initArray) {
        ArrayList<Object> array = new ArrayList<>();
        int index = 0;
        printSubsequencesImplementation(index, initArray, array);
    }

    public static void printSubsequencesImplementation(int index, int[] initArray, ArrayList<Object> array) {
        int length = initArray.length;
        if (index == length) {
            printArray(array);
            return;
        }
        array.add(initArray[index]);
        printSubsequencesImplementation(index + 1, initArray, array);
        array.remove(array.size() - 1);
        printSubsequencesImplementation(index + 1, initArray, array);
    }
    
    public static void printArray(ArrayList<Object> array) {
        Consumer<Object> print = (element) -> System.out.print(element + " ");
        System.out.print("[ ");
        array.forEach(print);
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] initArray = {-2, -3, 1};
        printSubsequences(initArray);
    }
}
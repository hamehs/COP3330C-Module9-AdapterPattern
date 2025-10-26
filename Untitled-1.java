// ConceptDemo.java
// Halah Hameed
// October 26, 2025
// Demonstrates the Adapter Pattern and Java Collection operations

import java.util.*;

// Adapter class that adapts an Integer[] array into a List<Integer>
class ArrayToListAdapter {
    private Integer[] array;

    // Constructor accepts the array to adapt
    public ArrayToListAdapter(Integer[] array) {
        this.array = array;
    }

    // Returns a List<Integer> view of the array
    public List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        for (Integer num : array) {
            list.add(num);
        }
        return list;
    }
}

public class ConceptDemo {

    // Method that uses unbounded wildcard to print any list
    public static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {

        // Step 1: Create an Integer array (the adaptee)
        Integer[] numbers = {5, 2, 9, 1, 4, 7};

        // Step 2: Apply Adapter Pattern to convert array into a List
        ArrayToListAdapter adapter = new ArrayToListAdapter(numbers);
        List<Integer> numberList = adapter.getList();

        // Step 3: Use Diamond Operator (<>) to create another list
        List<Integer> moreNumbers = new ArrayList<>();
        Collections.addAll(moreNumbers, 8, 3, 6);
        numberList.addAll(moreNumbers);

        // Step 4: Print before sorting
        System.out.println("Before sorting: " + numberList);

        // Sort the list
        Collections.sort(numberList);

        // Step 5: Print after sorting
        System.out.println("After sorting: " + numberList);

        // Step 6: Remove element (value 4)
        numberList.remove(Integer.valueOf(4));
        System.out.println("After removing 4: " + numberList);

        // Step 7: Print using unbounded wildcard method
        System.out.print("Printing list using unbounded wildcard: ");
        printList(numberList);
    }
}
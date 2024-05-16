package homework4.excercise2.ex15;

public class Test {

    public static void main(String[] args) {
        testMinHeapPriorityQueue();
    }

    public static void testMinHeapPriorityQueue() {
        MinHeapPriorityQueue<Integer, String> minHeap = new MinHeapPriorityQueue<>();

        minHeap.insert(3, "Entry 3");
        minHeap.insert(1, "Entry 1");
        minHeap.insert(4, "Entry 4");
        minHeap.insert(2, "Entry 2");
        minHeap.insert(5, "Entry 5");

        System.out.println("MinHeap Priority Queue:");
        while (!minHeap.isEmpty()) {
            Entry<Integer, String> minEntry = minHeap.removeMin();
            System.out.println("Key: " + minEntry.getKey() + ", Value: " + minEntry.getValue());
        }
        System.out.println();
    }
}

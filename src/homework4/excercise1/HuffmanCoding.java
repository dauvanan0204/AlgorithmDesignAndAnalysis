package homework4.excercise1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {

    // Class to represent Huffman Tree nodes
    static class HuffmanNode {
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;
    }

    // Comparator class for HuffmanNodes
    static class MyComparator implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.data - y.data;
        }
    }

    // Function to print Huffman Codes through tree traversal
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    // Main function
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        // Priority queue to store Huffman nodes
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        // Create a leaf node for each character and add it to the priority queue
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        // Create a root node
        HuffmanNode root = null;

        // Build Huffman Tree
        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        // Print Huffman Codes
        System.out.println("Huffman Codes:");
        printCode(root, "");
    }
}

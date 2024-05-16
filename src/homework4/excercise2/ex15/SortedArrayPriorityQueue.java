package homework4.excercise2.ex15;

import java.util.Arrays;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (n == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        if (n == 0) {
            array[0] = (ArrEntry<K, E>) entry;
        } else {
            int i = n - 1;
            while (i >= 0 && array[i].getKey().compareTo(entry.getKey()) > 0) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = (ArrEntry<K, E>) entry;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> newEntry = new ArrEntry<>(k,e);
        insert(newEntry);
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minEntry = array[0];
        for (int i = 1; i < n; i++) {
            array[i - 1] = array[i];
        }
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }
}


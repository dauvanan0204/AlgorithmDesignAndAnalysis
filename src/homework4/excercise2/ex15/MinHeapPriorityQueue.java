package homework4.excercise2.ex15;
import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    protected ArrEntry<K, E>[] heapPQ;
    int n = 0;
    int defaultSize = 1000;
    public MinHeapPriorityQueue() {
        this.heapPQ = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    protected void upHeap() {
        int current = size() - 1; // Lấy chỉ số của phần tử mới được chèn vào heap
        while (current > 0) {
            int parent = (current - 1) / 2; // Tìm chỉ số của nút cha

            if (heapPQ[current].getKey().compareTo(heapPQ[parent].getKey()) >= 0) {
                break; // Đã đúng vị trí trong heap, thoát khỏi vòng lặp
            }

            // Nếu không, swap nút hiện tại với nút cha
            ArrEntry<K, E> temp = heapPQ[current];
            heapPQ[current] = heapPQ[parent];
            heapPQ[parent] = temp;

            current = parent; // Cập nhật chỉ số hiện tại cho nút cha và tiếp tục lặp
        }
    }

    protected void downHeap() {
        int current = 0;
        int leftChild, rightChild, smallerChild;

        while (current < (size() - 1) / 2) {
            leftChild = 2 * current + 1;
            rightChild = 2 * current + 2;
            smallerChild = leftChild; // Giả sử nút con trái nhỏ nhất ban đầu

            // Tìm nút con nhỏ nhất (nếu có)
            if (rightChild < size() && heapPQ[rightChild].getKey().compareTo(heapPQ[leftChild].getKey()) < 0) {
                smallerChild = rightChild;
            }

            // Nếu nút hiện tại lớn hơn nút con nhỏ nhất, thực hiện hoán đổi
            if (heapPQ[current].getKey().compareTo(heapPQ[smallerChild].getKey()) > 0) {
                ArrEntry<K, E> temp = heapPQ[current];
                heapPQ[current] = heapPQ[smallerChild];
                heapPQ[smallerChild] = temp;

                current = smallerChild; // Cập nhật chỉ số hiện tại và tiếp tục lặp
            } else {
                break; // Đã đúng vị trí trong heap, thoát khỏi vòng lặp
            }
        }
    }

    @Override
    public void insert(Entry entry) {
        if (size() >= heapPQ.length) {
            // Mở rộng kích thước mảng heap nếu cần thiết
            heapPQ = Arrays.copyOf(heapPQ, heapPQ.length * 2);
        }

        heapPQ[n] = (ArrEntry<K, E>) entry; // Thêm phần tử vào cuối heap
        upHeap(); // Tạo lại heap sau khi chèn
        n++; // Tăng kích thước của hàng đợi ưu tiên
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> newEntry = new ArrEntry<K, E>(k,e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        Entry<K, E> min = heapPQ[0]; // Phần tử có giá trị nhỏ nhất là gốc của heap
        heapPQ[0] = heapPQ[n - 1]; // Ghi đè gốc bằng phần tử cuối cùng
        heapPQ[n - 1] = null; // Xóa phần tử cuối cùng
        n--; // Giảm kích thước của hàng đợi ưu tiên
        downHeap(); // Tạo lại heap sau khi loại bỏ phần tử nhỏ nhất

        return min; // Trả về phần tử nhỏ nhất đã bị loại bỏ
    }
    @Override
    public Entry min() {
        if (isEmpty()) {
            return null;
        }
        return heapPQ[0];
    }
}


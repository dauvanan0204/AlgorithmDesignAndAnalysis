package homework3.excercise2;
/*
Bài toán: Liệt kê các hoán vị của n phần tử.

Phân tích bài toán:

Đề bài yêu cầu liệt kê tất cả các hoán vị của n phần tử. Mỗi hoán vị là một sắp xếp khác nhau của các phần tử.
Số lượng hoán vị của n phần tử là n! (n giai thừa), với n là số lượng phần tử.
Xây dựng thuật toán:

Sử dụng phương pháp Backtracking để sinh ra tất cả các hoán vị của n phần tử.
Bắt đầu với một hoán vị rỗng và một danh sách chứa tất cả các phần tử.
Trong mỗi bước, chọn một phần tử từ danh sách và thêm vào hoán vị. Sau đó, loại bỏ phần tử đã chọn ra khỏi danh sách.
Khi hoán vị đã đủ n phần tử, in ra hoán vị đó.
Quay lui để thử tất cả các khả năng, cho đến khi tất cả các hoán vị được sinh ra.
Phân tích thuật toán:

Thuật toán sử dụng phương pháp backtracking để sinh ra tất cả các hoán vị của n phần tử.
Độ phức tạp của thuật toán là O(n!), với n là số lượng phần tử.
Do số lượng hoán vị tăng nhanh theo giai thừa, vì vậy thuật toán này chỉ hiệu quả đối với các giá trị nhỏ của n.
*/
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // Mảng các phần tử

        System.out.println("Các hoán vị của mảng nums:");
        generatePermutations(nums);
    }

    // Hàm sinh các hoán vị của mảng nums
    static void generatePermutations(int[] nums) {
        ArrayList<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generate(nums, permutation, used);
    }

    // Hàm đệ quy sinh các hoán vị
    static void generate(int[] nums, ArrayList<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            System.out.println(permutation); // In ra một hoán vị
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                generate(nums, permutation, used);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }
}


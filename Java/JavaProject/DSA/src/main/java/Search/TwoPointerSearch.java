package Search;


/*
🔹 Khi nào sử dụng Two Pointer?
Khi mảng hoặc danh sách được sắp xếp.
Khi cần tìm cặp phần tử hoặc dãy con thỏa mãn điều kiện nào đó.
Khi muốn giảm độ phức tạp từ O(N²) xuống O(N).
 */
public class TwoPointerSearch {

    // VD1: Tìm 2 số có tổng bằng target 
    // Với giải thuật vét cạn (brute force)
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{-1, -1}; // Không tìm thấy
    }

    // với giải thuật two pointer (mảng đã sắp xếp)
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Không tìm thấy
    }

    // xóa phần tử trùng lặp trong mảng {0,1,1,2,2,4} and return the number of unique elements in nums.
    public int removeDuplicates(int[] nums) {
        /*
        i (chỉ mục kết quả): Xác định vị trí tiếp theo để ghi giá trị duy nhất.
        j (chỉ mục duyệt): Duyệt qua toàn bộ mảng để tìm giá trị mới.
         */
        if (nums.length == 0) {
            return 0; // Xử lý trường hợp mảng rỗng
        }
        int i = 0; // Vị trí của phần tử duy nhất cuối cùng
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { // Nếu gặp số mới
                i++;                  // Tăng chỉ mục `i`
                nums[i] = nums[j];    // Cập nhật giá trị duy nhất mới
            }
        }
        return i + 1; // Số phần tử duy nhất
    }

}

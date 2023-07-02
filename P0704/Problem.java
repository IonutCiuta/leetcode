class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid, ref;
        
        while (start <= end) {
            mid = (start + end) / 2;
            ref = nums[mid];
            if (ref == target) {
                return mid;
            }

            if (ref < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}
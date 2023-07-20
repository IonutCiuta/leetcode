class Solution {
  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int min = 5000;

    while (left < nums.length && right >= 0) {
      int leftVal = nums[left];
      int rightVal = nums[right];
      if (leftVal < rightVal) {
          return Math.min(min, leftVal);
      }

      int mid = (left + right) / 2;
      int midVal = nums[mid];
      min = Math.min(min, midVal);

      if (leftVal <= midVal) {
          left = mid + 1;
      } else {
          right = mid - 1;
      }
    }

    return min;
  }
}
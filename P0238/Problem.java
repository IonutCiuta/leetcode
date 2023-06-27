class Solution {
  public int[] productExceptSelf(int[] nums) {
      var len = nums.length;
      var pfx = new int[len];
      var res = new int[len];

      pfx[0] = 1;
      for (var i = 1; i < len; i++) {
          pfx[i] = nums[i - 1] * pfx[i - 1];
      }

      var sfx = 1;
      res[len - 1] = pfx[len - 1];
      for (var i = len - 2; i >= 0; i--) {
          var currentSfx = nums[i + 1] * sfx;
          res[i] = pfx[i] * currentSfx;
          sfx = currentSfx;
      }

      return res;
  }
}
import java.util.HashMap;

class Solution {
  public int longestConsecutive(int[] nums) {
      if (nums.length == 0) {
          return 0;
      }

      var cache = new HashMap<Integer, Integer[]>();
      var max = 0;
     
      for (int n : nums) {
          var seq = cache.get(n);
          if (seq != null) {
              continue;
          }

          var left = n - 1;
          var leftSeq = cache.get(left);

          var right = n + 1;
          var rightSeq = cache.get(right);

          if (leftSeq == null && rightSeq == null) {
              cache.put(n, new Integer[]{n, n});
              if (max == 0) max = 1;
          } else {
              if (leftSeq != null && rightSeq != null) {
                  rightSeq[0] = leftSeq[0];
                  leftSeq[1] = rightSeq[1];
                  cache.put(n, rightSeq);
                  cache.put(leftSeq[0], rightSeq);
                  var len = rightSeq[1] - rightSeq[0] + 1;
                  if (len > max) max = len;
              } else {
                  if (leftSeq != null) {
                      leftSeq[1] = n;
                      cache.put(n, leftSeq);
                      var len = leftSeq[1] - leftSeq[0] + 1;
                      if (len > max) max = len;
                  }
                  
                  if (rightSeq != null) {
                      rightSeq[0] = n;
                      cache.put(n, rightSeq);
                      var len = rightSeq[1] - rightSeq[0] + 1;
                      if (len > max) max = len;
                  }
              }
          }
      }

      return max;
  }
}
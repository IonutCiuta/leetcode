import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
  public static List<List<Integer>> threeSum(int[] n) {
      var r = new HashSet<List<Integer>>();
      Arrays.sort(n);

      var iPrev = 0;

      for (int i = 0; i < n.length; i++) {
          // If we're already on the positive side, there's no point to continue
          if (n[i] > 0) {
              break;
          }

          // If we solved the sum for this number
          if (i > 0 && n[iPrev] == n[i]) {
              continue;
          }

          // Setup to find the other 2 numbers
          int j = i + 1;
          int k = n.length - 1;
          int target = -1 * n[i];

          while (j < k) {
              int sum = n[j] + n[k];

              // If the sum is right:
              // 1) create the solution
              // 2) sort solution and rely on hashing to eliminate duplicates
              // 3) move both pointers
              if (sum == target) {
                  var solution = new ArrayList<Integer>();
                  solution.add(n[i]);
                  solution.add(n[j]);
                  solution.add(n[k]);

                  Collections.sort(solution);
                  r.add(solution);

                  j++;
                  k--;

                  continue;
              }

              // If sum lower, increase left pointer else decrease right pointer
              if (sum < target) {
                  j++;
              } else {
                  k--;
              }
          }

          iPrev = i;
      }

      return new ArrayList<>(r);
  }
}
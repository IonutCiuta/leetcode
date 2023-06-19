import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
  public int[] twoSum(int[] nums, int target) {
      var idxMap = new HashMap<Integer, List<Integer>>();
      for (var i = 0; i < nums.length; i++) {
          var num = nums[i];
          if (idxMap.containsKey(num)) {
              idxMap.get(num).add(i);
          } else {
              var idxs = new ArrayList<Integer>();
              idxs.add(i);
              idxMap.put(num, idxs);
          }
      }

      for (var i = 0; i < nums.length; i++) {
          var diff = target - nums[i];
          if (idxMap.containsKey(diff)) {
              var idxs = idxMap.get(diff);
              for (int j = 0; j < idxs.size(); j++) {
                  if (idxs.get(j) != i) {
                      return new int[] {i, idxs.get(j)};
                  }
              }
          }
      }

      return null;
  }
}
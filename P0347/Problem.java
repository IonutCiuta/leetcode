import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
      var top = new HashMap<Integer, Integer>();
      for (var n : nums) {
          var freq = top.get(n);
          top.put(n, freq == null ? 1 : (freq + 1));
      }

      var l = new ArrayList<>(top.entrySet());
      l.sort((e1, e2) -> e2.getValue() - e1.getValue());
      
      var r = new int[k];
      for (var i = 0; i < k; i++) {
          r[i] = l.get(i).getKey();
      }
      
      return r;
  }
}
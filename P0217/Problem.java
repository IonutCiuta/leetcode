import java.util.HashSet;

class Solution {
  public boolean containsDuplicate(int[] nums) {
      final var seen = new HashSet<Integer>();

      for (var i : nums) {
          if (seen.contains(i)) {
              return true;
          }
          seen.add(i);
      }

      return false;
  } 
}
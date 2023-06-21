import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
      var store = new HashMap<Integer, List<String>>();
      for (var s : strs) {
          var chars = s.toCharArray();
          Arrays.sort(chars);
          var hash = Arrays.hashCode(chars);

          if (store.containsKey(hash)) {
              store.get(hash).add(s);
          } else {
              var anagrams = new ArrayList<String>();
              anagrams.add(s);
              store.put(hash, anagrams);
          }
      }
      return new ArrayList<>(store.values());
  }
}
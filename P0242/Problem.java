import java.util.HashMap;

class Solution {
  public boolean isAnagram(String s, String t) {
      var sCharMap = new HashMap<Character, Integer>();
      var sChars = s.toCharArray();
      s.length()

      for (var c : sChars) {
          if (sCharMap.containsKey(c)) {
              var occ = sCharMap.get(c);
              sCharMap.put(c, occ + 1);
          } else {
              sCharMap.put(c, 1);
          }
      }

      var tChars = t.toCharArray();
      for (var c : tChars) {
          if (!sCharMap.containsKey(c)) {
              return false;
          }

          var occ = sCharMap.get(c);
          if (occ < 0) {
              return false;
          }

          sCharMap.put(c, occ - 1);
      }

      for (var occ : sCharMap.values()) {
          if (occ != 0) {
              return false;
          }
      }

      return true;
  }
}
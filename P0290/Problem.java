import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public boolean wordPattern(String pattern, String s) {
      var symArr = pattern.toCharArray();
      var wordArr = s.split("\\s");

      if (symArr.length != wordArr.length) {
          return false;
      }

      var symWordMap = new HashMap<Character, String>();
      var usedWords = new HashSet<String>();
      
      for (int i = 0; i < symArr.length; i++) {
          var currWord = wordArr[i];
          var sym = symArr[i];
          var mappedWord = symWordMap.get(sym);
          
          if (mappedWord == null) {
              if (usedWords.contains(currWord)) {
                  return false;
              } else {
                  symWordMap.put(sym, currWord);
                  usedWords.add(currWord);
              }
          } else {
              if (!currWord.equals(mappedWord)) {
                  return false;
              }
          }
      }

      return true;
  }
}
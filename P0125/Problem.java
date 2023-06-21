class Solution {
  public boolean isPalindrome(String s) {
      var chars = s.toLowerCase().toCharArray();
      var i = 0;
      var j = chars.length - 1;

      while (i < j) {
          var ichar = chars[i] - 'a';
          var jchar = chars[j] - 'a';

          var iIsAlphaNum = (ichar >= -49 && ichar <= -40) || (ichar >= 0 && ichar <= 25);
          var jIsAlphaNum = (jchar >= -49 && jchar <= -40) || (jchar >= 0 && jchar <= 25);

          if (iIsAlphaNum && jIsAlphaNum) {
              if (chars[i] == chars[j]) {
                  i += 1;
                  j -= 1;
                  continue;
              } else {
                  return false;
              }
          }

          if (!iIsAlphaNum) i += 1;
          if (!jIsAlphaNum) j -= 1;
      }

      return true;
  }
}
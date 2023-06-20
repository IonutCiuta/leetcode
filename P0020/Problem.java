import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
      var chars = s.toCharArray();
      var stack = new Stack<Character>();

      for (var c : chars) {
          if (c == '(' || c == '[' || c == '{') {
              stack.push(c);
          } else {
              if (stack.isEmpty()) {
                  return false;
              }
              var diff = c - stack.pop();
              if (diff != 1 && diff != 2) {
                  return false;
              }
          }
      }

      return stack.isEmpty();
  }
}
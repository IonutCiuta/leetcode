import java.util.ArrayDeque;

class Solution {
  public int evalRPN(String[] tokens) {
      var n = new ArrayDeque<Integer>();
      for (var input : tokens) {
          if (input.length() > 1) {
              n.push(Integer.parseInt(input));
          } else {
              int first, second;
              switch (input.charAt(0)) {
                  case '+':
                      n.push(n.pop() + n.pop());
                      break;
                  case '-':
                      first = n.pop();
                      second = n.pop();
                      n.push(second - first);
                      break;
                  case '*':
                      n.push(n.pop() * n.pop());
                      break;
                  case '/':
                      first = n.pop();
                      second = n.pop();
                      n.push(second / first);
                      break;
                  default:
                      n.push(input.charAt(0) - '0');
              }
          }
      }
      return n.pop();
  }
}
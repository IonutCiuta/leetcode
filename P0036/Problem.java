class Solution {
  public boolean isValidSudoku(char[][] board) {
      var seen = new HashSet<Character>();
      for (var line : board) {
          for (var c : line) {
              if ('.' == c) {
                  continue;
              } else {
                  if (seen.contains(c)) {
                      return false;
                  } else {
                      seen.add(c);
                  }
              }
          }
          seen.clear();
      }

      for (var col = 0; col < 9; col++) {
          for (var line = 0; line < 9; line++) {
              var c = board[line][col];
              if ('.' == c) {
                  continue;
              } else {
                  if (seen.contains(c)) {
                      return false;
                  } else {
                      seen.add(c);
                  }
              }
          }
          seen.clear();
      }

      for (var lineOffset = 0; lineOffset < 7; lineOffset += 3) {
          for (var colOffset = 0; colOffset < 7; colOffset += 3) {
              for (var line = lineOffset; line < lineOffset + 3; line++) {
                  for (var col = colOffset; col < colOffset + 3; col++) {
                      var c = board[line][col];
                      if ('.' == c) {
                          continue;
                      } else {
                          if (seen.contains(c)) {
                              return false;
                          } else {
                              seen.add(c);
                          }
                      }
                  }
              }
              seen.clear();
          }
      }

      return true;
  }
}
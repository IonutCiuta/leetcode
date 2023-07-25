class Solution {
  public int[] dailyTemperatures(int[] ts) {
      var len = ts.length;
      var r = new int[len];
      
      // Nothin greater than last element;
      r[len - 1] = 0;

      // Start from the end minus last
      var i = len - 2;
      
      while (i >= 0) {
          if (ts[i + 1] > ts[i]) {
              // if the next one is greater, set 1 and move to the left
              r[i] = 1;
          } else {
              var j = i + 1;
              while (j < len) {
                  if (ts[i] >= ts[j]) {
                      // if next temp is lower
                      if (r[j] == 0) {
                          // and no other following temp is higher than this, stop
                          r[i] = 0;
                          break;
                      } else {
                          // move to first higher and add offset
                          r[i] += r[j];
                          j += r[j];
                      }
                  } else {
                      // if next temp is higher, inc
                      r[i]++;
                      break;
                  }
              }
          }
          i--;
      }

      return r;
  }
}
class Solution {
  public int peakIndexInMountainArray(int[] arr) {
      int i = 0;
      int j = arr.length - 1;
      int max = -1;
      int r = -1;

      while (i <= j) {
          var m = (i + j) / 2;
          var mid = arr[m];
          var prevM = m - 1;
          var nextM = m + 1;

          if (mid > max) {
              max = mid;
              r = m;

              var leftBigger = prevM >= 0 && arr[prevM] > mid;
              var rightBigger = nextM < arr.length && arr[nextM] > mid;
              if (leftBigger && !rightBigger) {
                  j = prevM;
              } else {
                  i = nextM;
              }
          } else {
              if (arr[i] < arr[j]) {
                  i = m + 1;
              } else {
                  j = m - 1;
              }
          }
      }

      return r;
  }
}
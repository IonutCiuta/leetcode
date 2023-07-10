class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length - 1;
      int cols = matrix[0].length - 1;
      
      int vertMin = 0;
      int vertMax = rows;
      while (vertMin <= vertMax) {
          int vertMid = (vertMin + vertMax) / 2;
          int[] midLine = matrix[vertMid];
          int horizMin = midLine[0];
          int horizMax = midLine[cols];

          if (target < horizMin) {
              vertMax = vertMid - 1;
              continue;
          }

          if (target > horizMax) {
              vertMin = vertMid + 1;
              continue;
          }

          int min = 0;
          int max = cols;
          while (min <= max) {
              int mid = (min + max) / 2;
              int ref = midLine[mid];

              if (target == ref) {
                  return true;
              }

              if (target < ref) {
                  max = mid - 1;
              } else {
                  min = mid + 1;
              }
          }
          
          return false;
      }

      return false;
  }
}
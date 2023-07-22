class Solution {
  public int maxArea(int[] h) {
      int max = -1;
      int i = 0, j = h.length - 1;
      
      while (i < j) {
          var wall = h[i] < h[j] ? h[i] : h[j];
          var vol = wall * (j - i);
          if (vol > max) max = vol;
          
          while(h[i] <= wall && i < j) i++;
          while(h[j] <= wall && i < j) j--;
      }

      return max;
  }
}
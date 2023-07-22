class Solution {
  public int[] asteroidCollision(int[] rocks) {
      int i = 0;
      int j = 1;
      int rocksLeft = rocks.length;
      
      while (i < j && j < rocks.length) {            
          // collision can happen only if leftRock is positive and rightRock is negative
          // 🪨 --> 💥 <-- -🪨

          // Both negative, moving to the right
          if (rocks[i] < 0 && rocks[j] < 0) {
              i += 2;
              j = i + 1;
              continue;
          }

          // If not on coliision course, move to the rights
          if (!(rocks[i] > 0 && rocks[j] < 0)) {                
              i = j;
              j += 1;
              continue;
          }

          if (Math.abs(rocks[i]) == Math.abs(rocks[j])) {
              // If rocks of same size, explode both rocks
              rocks[i] = 0;
              rocks[j] = 0;
              rocksLeft -= 2;

              // Find next possible collision target on the left side
              while (i >= 1 && rocks[i] == 0) {
                  i -= 1;
              }

              if (i == 0 && rocks[i] == 0) {
                  // If nothing to collide with on the left, move forward with both pointers
                  i = j;
                  j = i + 1;
              } else {
                  // If there's something to collide with on the left, explore what's on the right
                  j += 1;
              }
          } else {
              rocksLeft -= 1;

              if (Math.abs(rocks[i]) < Math.abs(rocks[j])) {
                  // If left side rock is the smaller one, explode it
                  rocks[i] = 0;

                  // Find next possible collision target on the left side
                  while (i >= 1 && rocks[i] == 0) {
                      i -= 1;
                  }
                 
                  // If nothing to collide with on the left, move forward with both pointers
                  if (i == 0 && rocks[i] == 0) {
                      i = j;
                      j = i + 1;
                  }
              } else {
                // If left side rock is the bigger one, explode the right rock and move right pointer
                  rocks[j] = 0;
                  j += 1;
              }
          }
      }

      // Copy non-exploded rocks
      var r = new int[rocksLeft];
      for (i = 0, j = 0; i < rocks.length; i++) {
          if (rocks[i] != 0) {
              r[j] = rocks[i];
              j += 1;
          }
      }

      return r;
  }
}
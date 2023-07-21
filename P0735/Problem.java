import java.util.LinkedList;

class Solution {
  public int[] asteroidCollision(int[] asteroids) {
      var rocks = new LinkedList<Integer>();
      for(var i : asteroids) rocks.add(i);

      int i = 0;
      int j = 1;
      
      while (i < j && j < rocks.size()) {
          var iRock = rocks.get(i);
          var jRock = rocks.get(j);

          var bothPositive = iRock >= 0 && jRock >= 0;
          var bothNegative = iRock < 0 && jRock < 0;
          
          // collision can happen only if leftRock is positive and rightRock is negative
          // \U0001faa8 --> \U0001f4a5 <-- \U0001faa8

          // Nothing to collide with on the right
          if (bothNegative) {
              i += 2;
              j = i + 1;
              continue;
          }

          // Might find a rock moving left on the right seide
          if (bothPositive) {
              i = j;
              j += 1;
              continue;
          }

          var collisionCourse = iRock > 0 && jRock < 0;
          if (!collisionCourse) {                
              i = j;
              j += 1;
              continue;
          }

          if (Math.abs(iRock) == Math.abs(jRock)) {
              // explode both rocks
              rocks.remove(j);
              rocks.remove(i);
              i = Math.max(0, i - 1);
              j = i + 1;
          } else {
              if (Math.abs(iRock) < Math.abs(jRock)) {
                  rocks.remove(i);
                  i = Math.max(0, i - 1);
                  j = i + 1;
              } else {
                  rocks.remove(j);
              }
          }
      }

      var r = new int[rocks.size()];
      for (i = 0; i < rocks.size(); i++) {
          r[i] = rocks.get(i);
      }

      return r;
  }
}
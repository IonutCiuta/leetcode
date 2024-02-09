class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var _1step = cost[0];
        var _2step = cost[1];

        for (int i = 2; i < cost.length; i++) {
            var currentCost = cost[i] + Math.min(_1step, _2step);
            _1step = _2step;
            _2step = currentCost;
        }

        return Math.min(_1step, _2step);
    }
}
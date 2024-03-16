class Solution {
    public int totalMoney(int n) {
        int money = 0;
        int week = 0;
        int i = 0;
        while (i < n) {
            var day = i % 7;
            if (day == 0) {
                week++;
            }
            money += (day + week);
            i++;
        }

        return money;
    }
}
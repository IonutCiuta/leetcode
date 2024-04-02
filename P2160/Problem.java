class Solution {
    public int minimumSum(int num) {
        var digits = new ArrayList<Integer>();
        while (num != 0) {
            digits.add(num % 10);
            num = num / 10;
        }

        Collections.sort(digits);

        return (digits.get(0) * 10 + digits.get(2))
                + (digits.get(1) * 10 + digits.get(3));
    }
}
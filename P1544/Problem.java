class Solution {
    public String makeGood(String s) {
        if (s.isEmpty()) {
            return s;
        }

        var deq = new ArrayDeque<Character>();
        var chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];
            if (deq.isEmpty()) {
                deq.push(c);
            } else {
                var top = deq.peek();
                var diff = Math.abs((int)(top - c));
                if (diff == 32) {
                    deq.pop();
                } else {
                    deq.push(c);
                }
            }
        }

        var sb = new StringBuilder();
        while (!deq.isEmpty()) {
            sb.append(deq.pollLast());
        }
        return sb.toString();
    }
}

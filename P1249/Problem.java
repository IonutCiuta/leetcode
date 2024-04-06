class Solution {
    public String minRemoveToMakeValid(String s) {
        var chars = s.toCharArray();
        var toRemove = new HashSet<Integer>();
        var deq = new ArrayDeque<Integer>();

        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];
            if (c == '(') {
                deq.push(i);
                continue;
            }

            if (c == ')') {
                if (deq.isEmpty()) {
                    toRemove.add(i);
                } else {
                    deq.pop();
                }
            }
        }

        while (!deq.isEmpty()) {
            toRemove.add(deq.pop());
        }


        var r = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!toRemove.contains(i)) {
                r.append(chars[i]);
            }
        }

        return r.toString();
    }
}
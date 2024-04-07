class Solution {
    public boolean checkValidString(String s) {
        var chars = s.toCharArray();
        var open = new Stack<Integer>();
        var stars = new Stack<Integer>();

        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];
            switch (c) {
                case '(' -> open.push(i);
                case '*' -> stars.push(i);
                case ')' -> {
                    if (open.size() > 0) {
                        open.pop();
                    } else if (stars.size() > 0) {
                        stars.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        // We need to check if the available stars are at indexes
        // bigger tha those of the reamaining open paranthesis
        while (!open.isEmpty() && !stars.isEmpty()) {
            var o = open.pop();
            var star = stars.pop();
            if (o > star) {
                open.push(o);
            }
        }

        // if there are no open paranthesis left
        // we're done
        if (open.isEmpty()) {
            return true;
        }

        return false;
    }
}
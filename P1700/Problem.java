class Solution {
    record P(int val, int pos) {}

    public int countStudents(int[] students, int[] sandwiches) {
        var studentsQ = new ArrayDeque<P>();
        var sandwichesQ = new ArrayDeque<P>();

        for (int i = 0; i < students.length; i++) {
            studentsQ.add(new P(students[i], i));
            sandwichesQ.add(new P(sandwiches[i], i));
        }

        var seen = new HashMap<Integer, Integer>();
        while (!studentsQ.isEmpty()) {
            var stud = studentsQ.poll();
            var sanw = sandwichesQ.peek();

            if (stud.val == sanw.val) {
                sandwichesQ.poll();
            } else {
                if (Objects.equals(seen.get(stud.pos), sanw.pos)) {
                    return studentsQ.size() + 1;
                } else {
                    seen.put(stud.pos, sanw.pos);
                    studentsQ.add(stud);
                }
            }
        }

        return 0;
    }
}
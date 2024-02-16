class RandomizedSet {
    private final HashMap<Integer, Integer> set;
    private final List<Integer> list;

    public RandomizedSet() {
        this.set = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        var stored = set.get(val);
        if (stored != null) {
            return false;
        }

        list.add(val);
        set.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        var stored = set.get(val);
        if (stored == null) {
            return false;
        }

        list.remove(stored);
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int i = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
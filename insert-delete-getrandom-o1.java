class RandomizedSet {

    
    Map<Integer, Integer> map;
    List<Integer> arrayList;
    int idx;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        idx = -1;
        map = new HashMap<>();
        arrayList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            arrayList.add(val);
            map.put(val, ++idx);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int i = map.get(val);
            if(i != idx){
                arrayList.set(i, arrayList.get(idx));
                map.put(arrayList.get(idx), i);
            }
            map.remove(val);
            arrayList.remove(idx--);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // int rand = Math.random(idx);
        int rand = ThreadLocalRandom.current().nextInt(0, idx + 1);
        return arrayList.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
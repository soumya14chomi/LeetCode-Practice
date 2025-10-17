class RandomizedCollection {

    HashMap<Integer, TreeSet<Integer>> nums;

    HashMap<Integer, Integer> idx;
    
    int len;

    public RandomizedCollection() {
        nums = new HashMap<>();
        idx = new HashMap<>();
        len = 0;
    }
    
    public boolean insert(int val) {
        len++;
        idx.put(len, val);
        if(nums.containsKey(val)){
            nums.get(val).add(len);

        // System.out.println("After insert: " + )
            return false;
        }
        else{
            nums.put(val, new TreeSet<>((a, b) -> b-a));
            nums.get(val).add(len);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!nums.containsKey(val)) return false;

        int i = nums.get(val).pollFirst();

        if(nums.get(val).size() == 0)    nums.remove(val);
        if( i == len){
            idx.remove(len);
            len--;
            return true;
        }

        int newVal = idx.get(len);

        idx.put(i, newVal);

        nums.get(newVal).remove(len);

        nums.get(newVal).add(i);

        len--;


        return true;

    }
    
    public int getRandom() {

        return idx.get((int)(Math.random() * len) + 1);

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
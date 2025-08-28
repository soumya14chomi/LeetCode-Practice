
class RandomizedSet {

    Map<Integer, Integer> hm;
    List<Integer> nums; 
    Random rand;


    public RandomizedSet() {
        hm = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;

        hm.put(val, nums.size());
        nums.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        
        if(!hm.containsKey(val)) return false;

        int  n = nums.size();
        int idx = hm.get(val);

        int temp = nums.get(n-1);
        nums.set(n-1, nums.get(idx));
        nums.set(idx, temp);

        hm.put(temp, idx);
        hm.remove(val);
        nums.remove(n-1);
        return true;
    }
    
    public int getRandom() {
        
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
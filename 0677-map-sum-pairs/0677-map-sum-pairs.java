class MapSum {

    Map<String, Integer> hm;
    Map<String, Integer> hs;

    public MapSum() {
        hm = new HashMap<>();
        hs= new HashMap<>();
    }
    
    public void insert(String key, int val) {

        if(hs.containsKey(key)){
            int temp = val-hs.get(key);
            hs.put(key, val);
            val = temp;
        } 
        else    hs.put(key, val);

        for(int i=0; i<key.length(); i++){
            hm.put(key.substring(0, i+1), hm.getOrDefault(key.substring(0, i+1), 0)+val);

        //  System.out.println(key.substring(0, i+1)+" "+val+" "+hm.toString());
        }
    }
    
    public int sum(String prefix) {
        return hm.containsKey(prefix)? hm.get(prefix) : 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
class LFUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
            this.freq = 1;
        }
    }

    int capacity;
    HashMap<Integer, Node> hm;
    HashMap<Integer, Node> freqHead;
    HashMap<Integer, Node> freqTail;
    PriorityQueue<Integer> leastFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<Integer, Node>();
        freqHead = new HashMap<>();
        freqTail = new HashMap<>();
        this.leastFreq  = new PriorityQueue<>();
    }
    
    public int get(int key) {
        if(hm.containsKey(key))  {
            Node node = hm.get(key);
            remove(node, node.freq);
            node.freq++;
            insert(node);
            return hm.get(key).value;
        } 

        return -1;
    }
    
    public void put(int key, int value) {
        Node node= new Node(key, value);
        if(hm.containsKey(key)){
            node = hm.get(key);
            int freq = hm.get(key).freq;   
            remove(node, freq);    
            node.value = value;
            node.freq = freq+1;
             
            // System.out.println("Edited node values:" + node.value+" "+node.freq);  
        }
        if(hm.size() == capacity){
            removeLeastFreq();
        }
        int freq = node.freq;
        
        insert(node);
    }

    void remove(Node node, int freq){
        // System.out.println("Removing node: "+node.key+" freq: "+freq);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        Node fh = freqHead.get(freq);
        // System.out.println("Freq:"+ freq+" head: "+freqHead.get(freq).value+" tail:"+freqTail.get(freq).value+" NEXTS: ("+freqHead.get(freq).next.value+", "+freqTail.get(freq).prev.value+")");
        if(fh.next.value == -1){
            // System.out.println("Removing freq head and tails: "+freq);
            freqHead.remove(freq);
            freqTail.remove(freq);
            leastFreq.remove(freq);
        }

        hm.remove(node.key);
 
    }   

    void removeLeastFreq(){
        int lf = leastFreq.peek();
        Node ft = freqTail.get(lf).prev;

        // System.out.println("removing least freq:"+lf+" - "+ft.key);
        remove(ft, lf);
    }

    void insertFreq(int freq){
        
        Node dummyHead = new Node(-1, -1);
        Node dummyTail = new Node(-1, -1);

        dummyHead.next = dummyTail;
        dummyTail.next = dummyHead;

        freqHead.put(freq, dummyHead);
        freqTail.put(freq, dummyTail);

        

        leastFreq.add(freq);

    }

    void insert(Node node){
        int freq = node.freq;
        if(!freqHead.containsKey(freq)){
            // System.out.println("Inserting freq:"+freq+" for:"+node.key);
            insertFreq(freq);
        } 

        //  System.out.println("Adding node: "+node.key+ ", "+node.value +" freq: "+freq);

        // System.out.println("Accessing:"+freq);
        Node next = freqHead.get(freq).next;
        freqHead.get(freq).next = node;
        node.next = next;
        next.prev = node;
        node.prev = freqHead.get(freq);
        hm.put(node.key, node);
        // capacity--;
        // System.out.println("New Capacity:" + capacity);
    }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
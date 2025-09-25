class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Integer capacity;
    private HashMap<Integer, Node> hm;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))    return -1;
        Node node = hm.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }
        if(hm.size() == capacity){
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insert(node);
    }

    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        hm.remove(node.key);
    }

    void insert(Node node){

        node.next = head.next;
        node.next.prev = node;

        node.prev = head;
        head.next = node;

        hm.put(node.key, node);


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
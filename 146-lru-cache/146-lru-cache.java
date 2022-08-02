

class LRUCache {
    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
        
    }
    public void addNode(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void removeNode(DNode node) { //helper function
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToHead(DNode node) { //this one used when we use a pair making it the MRU
        removeNode(node);
        addNode(node);
    }
    public DNode popTail() { //removing the LRU
        DNode temp = tail.prev;
        removeNode(temp);
        return temp;
}
    private HashMap<Integer, DNode> map = new HashMap();
    private DNode head;
    private int size; //current size of cache
    private int capacity;
    private DNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DNode temp = map.get(key);
            moveToHead(temp); //since we accessed this node it is now the MRU
            return temp.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        DNode temp = map.get(key);
        if (temp == null) {
            DNode node = new DNode();
            node.key = key;
            node.value = value;
            addNode(node); //this will add the node to the linked list and to the head because its mru
            map.put(key, node);
            ++this.size;
        if (this.size > this.capacity) {
            DNode t = popTail(); //remove the LRU from double linked list and from map
            map.remove(t.key);
            --this.size;
        }
        }
        else {
            temp.value = value;
            moveToHead(temp);
            
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
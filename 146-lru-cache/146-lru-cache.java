class LRUCache {
    public class DNode {
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
        public void removeNode(DNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        public void moveToHead(DNode node) { //recently been accessed
            removeNode(node);
            addNode(node);
}
        public DNode popTail() {
            DNode temp = tail.prev;
            removeNode(temp);
            return temp;
        }
    private HashMap<Integer, DNode> map = new HashMap();
    private DNode head;
    private DNode tail;
    private int capacity;
    private int size;

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
            moveToHead(temp);
            return temp.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        DNode node = map.get(key);
        if (node == null) {
            DNode temp = new DNode();
            temp.key = key;
            temp.value = value;
            addNode(temp);
            ++this.size;
            map.put(key, temp);
            if (this.size > this.capacity) {
                DNode rem = popTail();
                map.remove(rem.key);
                --this.size;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
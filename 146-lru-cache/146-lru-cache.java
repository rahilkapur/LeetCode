class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    //add
    //remove
    //moveToFront
    public void add(Node nd) {
        nd.prev = head;
        nd.next = head.next;
        head.next.prev = nd;
        head.next = nd;
    }
    public void remove(Node nd) {
        nd.prev.next = nd.next;
        nd.next.prev = nd.prev;
    }
    public Node popTail() {
        Node tmp = tail.prev;
        remove(tmp);
        return tmp;
    }
    public void moveToFront(Node nd) {
        remove(nd);
        add(nd);
    }
    private HashMap<Integer, Node> map;
    int currSize = 0;
    int maxSize = 0;
    Node head = null;
    Node tail = null;
    public LRUCache(int capacity) {
        maxSize = capacity;
        currSize = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap();
    }
    
    public int get(int key) {
        Node t = map.get(key);
        if (t == null) {
            return -1;
        }
        moveToFront(t);
        return t.value;
    }
    
    public void put(int key, int value) {
        Node t = map.get(key);
        if (t == null) {
            Node toadd = new Node();
            toadd.key = key;
            toadd.value = value;
            add(toadd);
            map.put(key, toadd);
            ++this.currSize;
            if (this.currSize > this.maxSize) {
                Node nd = popTail();
                map.remove(nd.key);
                --this.currSize;
            }
        }
        else {
            t.value = value;
            map.replace(key, t);
            moveToFront(t);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
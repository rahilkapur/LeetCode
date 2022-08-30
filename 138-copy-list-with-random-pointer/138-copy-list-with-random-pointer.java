/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>(); //will be old node -> new node
    
    public Node getCloned(Node curr) {
        if (curr != null) {
            if (this.map.containsKey(curr)) {
                return this.map.get(curr);                
            }
            this.map.put(curr, new Node(curr.val, null, null));
            return this.map.get(curr);
            
            
        }
        return null;
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(head.val);
        this.map.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.random = getCloned(oldNode.random);
            newNode.next = getCloned(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
            
        }
        return this.map.get(head);
        
    }
}
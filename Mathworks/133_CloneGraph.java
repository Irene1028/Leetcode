/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> newNodes = new HashMap<>();
        return helper(node, newNodes);
    }
    public Node helper(Node node, Map<Integer, Node> newNodes) {
        if (node == null) return null;
        if (newNodes.containsKey(node.val)) {
            return newNodes.get(node.val);
        } else {
            Node newNode = new Node(node.val, new ArrayList<>());
            // newNode.val = node.val;
            newNodes.put(node.val, newNode);
            // System.out.print("Cur Old Node = ");
            // System.out.println(node.val);
            for (Node n : node.neighbors) {
                // System.out.print("New Cur neighbor: ");
                // System.out.println(newNodes.size());
                newNode.neighbors.add(helper(n, newNodes));
            }
            return newNode;
        }
        
    }
}
/*

*/

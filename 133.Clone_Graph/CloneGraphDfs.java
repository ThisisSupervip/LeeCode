import java.util.*;

public class CloneGraphDfs{
    public static void main(String[] args) {
        List<Node> neighbors = new LinkedList<>();
        Node a = new Node(1,neighbors);
        Node b = new Node(2,new LinkedList<>());
        b.neighbors.add(a);
        neighbors.add(b);
        Solution solution = new Solution();
        Node node = solution.cloneGraph(a);
    }
}
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> visited = new HashMap<>();
        Node res = recur(node,visited);
        return res;
    }

    public Node recur(Node node, Map<Node,Node> visited){
        List<Node> copyOfNeighbors = new LinkedList<>();
        Node newNode = new Node(node.val,copyOfNeighbors);
        visited.put(node,newNode);
        for(Node neighbor:node.neighbors){
            Node copyOfNeighbor = visited.containsKey(neighbor)?visited.get(neighbor):recur(neighbor,visited);
            copyOfNeighbors.add(copyOfNeighbor);
        }
        return newNode;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
package leetcode;

import java.util.*;

public class Num104 {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null){
            return maxDepth;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root,1));

        while (!q.isEmpty()){
            Node curNode = q.poll();
            if (curNode.treeNode.left != null){
                q.offer(new Node(curNode.treeNode.left,curNode.depth+1));
            }
            if (curNode.treeNode.right != null){
                q.offer(new Node(curNode.treeNode.right,curNode.depth+1));
            }
            maxDepth = Math.max(maxDepth, curNode.depth);
        }
        return maxDepth;
    }
}

class Node{
    TreeNode treeNode;
    int depth;

    public Node(TreeNode treeNode, int depth) {
        this.treeNode = treeNode;
        this.depth = depth;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
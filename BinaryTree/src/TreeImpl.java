import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Tree bt = new Tree();
	        bt.insert(1);
	        bt.insert(2);
	        bt.insert(5);
	        bt.insert(4);
	        bt.insert(5);
	        bt.insert(6);

	        System.out.println(new TreeImpl().countKey(bt.root, 5));
	        System.out.println(new TreeImpl().countNodes(bt.root));
//	        bt.printInorder();  // Output: 4 2 5 1 3
	}
	
	int countNodes(TreeNode root)
	{
		if(root==null) return 0;
		return 1+countNodes(root.left)+countNodes(root.right);
	}
	
	int countKey(TreeNode root, int key)
	{
		if(root==null) return 0;
		if(root.left==null && root.right==null && root.val==key) return 1;
		return countKey(root.left, key)+countKey(root.right, key);
	}
}

//TreeNode definition
class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	
	 TreeNode(int val) {
	     this.val = val;
	 }
}

//Binary Tree class
class Tree {
	 TreeNode root;

 	 // Insert nodes in level-order (for a complete binary tree structure)
	 public void insert(int val) {
	     TreeNode newNode = new TreeNode(val);
	     if (root == null) {
	         root = newNode;
	         return;
	     }
	
	     Queue<TreeNode> queue = new LinkedList<>();
	     queue.offer(root);
	
	     while (!queue.isEmpty()) {
	         TreeNode curr = queue.poll();
	
	         if (curr.left == null) {
	             curr.left = newNode;
	             return;
	         } else {
	             queue.offer(curr.left);
	         }
	
	         if (curr.right == null) {
	             curr.right = newNode;
	             return;
	         } else {
	             queue.offer(curr.right);
	         }
	     }
	 }
	
	 // Inorder Traversal
	 public void inorder(TreeNode node) {
	     if (node == null) return;
	     inorder(node.left);
	     System.out.print(node.val + " ");
	     inorder(node.right);
	 }
	
	 public void printInorder() {
	     inorder(root);
	     System.out.println();
	 }
}







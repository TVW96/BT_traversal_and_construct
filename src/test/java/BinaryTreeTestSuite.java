import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTestSuite {

    @Test
    public void testEmptyTree() {
        // Create an empty tree (root is null)
        TreeNode root = null;

        // Initialize the BinaryTreeTraversals instance
        BinaryTreeTraversals bt = new BinaryTreeTraversals();

        // Test Preorder Traversal
        List<Integer> preorder = bt.preorderTraversal(root);
        assertTrue(preorder.isEmpty(), "Preorder traversal of an empty tree should return an empty list");

        // Test Inorder Traversal
        List<Integer> inorder = bt.inorderTraversal(root);
        assertTrue(inorder.isEmpty(), "Inorder traversal of an empty tree should return an empty list");

        // Test Postorder Traversal
        List<Integer> postorder = bt.postorderTraversal(root);
        assertTrue(postorder.isEmpty(), "Postorder traversal of an empty tree should return an empty list");

        // Test Level Order Traversal
        List<List<Integer>> levelOrder = bt.levelOrderTraversal(root);
        assertTrue(levelOrder.isEmpty(), "Level order traversal of an empty tree should return an empty list");
    }

    @Test
    public void testSingleNodeTree() {
        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        BinaryTreeConstructs constructs = new BinaryTreeConstructs();

        // Single Node Tree
        TreeNode root = new TreeNode(1);

        // Traversals
        assertEquals(List.of(1), traversals.preorderTraversal(root));
        assertEquals(List.of(1), traversals.inorderTraversal(root));
        assertEquals(List.of(1), traversals.postorderTraversal(root));
        assertEquals(List.of(List.of(1)), traversals.levelOrderTraversal(root));

        // Construction
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode constructedRoot = constructs.buildTreeFromPreIn(preorder, inorder);
        assertEquals(List.of(1), traversals.preorderTraversal(constructedRoot));
    }

    @Test
    public void testTwoNodesTreeLeftChild() {
        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        BinaryTreeConstructs constructs = new BinaryTreeConstructs();
        // Tree: 1 -> 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // Traversals
        assertEquals(List.of(1, 2), traversals.preorderTraversal(root));
        assertEquals(List.of(2, 1), traversals.inorderTraversal(root));
        assertEquals(List.of(2, 1), traversals.postorderTraversal(root));
        assertEquals(List.of(List.of(1), List.of(2)), traversals.levelOrderTraversal(root));

        // Construction
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        TreeNode constructedRoot = constructs.buildTreeFromPreIn(preorder, inorder);
        assertEquals(List.of(1, 2), traversals.preorderTraversal(constructedRoot));
    }

    @Test
    public void testFullBinaryTree() {
        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        BinaryTreeConstructs constructs = new BinaryTreeConstructs();
        
        // Tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Traversals
        assertEquals(List.of(1, 2, 4, 5, 3, 6), traversals.preorderTraversal(root));
        assertEquals(List.of(4, 2, 5, 1, 3, 6), traversals.inorderTraversal(root));
        assertEquals(List.of(4, 5, 2, 6, 3, 1), traversals.postorderTraversal(root));
        assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6)), traversals.levelOrderTraversal(root));

        // Construction
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 3, 6};
        TreeNode constructedRoot = constructs.buildTreeFromPreIn(preorder, inorder);
        assertEquals(List.of(1, 2, 4, 5, 3, 6), traversals.preorderTraversal(constructedRoot));
    }

    @Test
    public void testSkewedTreeRight() {
        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        BinaryTreeConstructs constructs = new BinaryTreeConstructs();
        
        // Tree: Skewed to the right
        // 1 -> 2 -> 3 -> 4
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Traversals
        assertEquals(List.of(1, 2, 3, 4), traversals.preorderTraversal(root));
        assertEquals(List.of(1, 2, 3, 4), traversals.inorderTraversal(root));
        assertEquals(List.of(4, 3, 2, 1), traversals.postorderTraversal(root));
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)), traversals.levelOrderTraversal(root));

        // Construction
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        TreeNode constructedRoot = constructs.buildTreeFromPreIn(preorder, inorder);
        assertEquals(List.of(1, 2, 3, 4), traversals.preorderTraversal(constructedRoot));
    }

    @Test
    public void testSkewedTreeLeft() {
        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        BinaryTreeConstructs constructs = new BinaryTreeConstructs();
        
        // Tree: Skewed to the left
        //        4
        //       /
        //      3
        //     /
        //    2
        //   /
        //  1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        // Traversals
        assertEquals(List.of(4, 3, 2, 1), traversals.preorderTraversal(root));
        assertEquals(List.of(1, 2, 3, 4), traversals.inorderTraversal(root));
        assertEquals(List.of(1, 2, 3, 4), traversals.postorderTraversal(root));
        assertEquals(List.of(List.of(4), List.of(3), List.of(2), List.of(1)), traversals.levelOrderTraversal(root));

        // Construction
        int[] preorder = {4, 3, 2, 1};
        int[] inorder = {1, 2, 3, 4};
        TreeNode constructedRoot = constructs.buildTreeFromPreIn(preorder, inorder);
        assertEquals(List.of(4, 3, 2, 1), traversals.preorderTraversal(constructedRoot));
    }
}

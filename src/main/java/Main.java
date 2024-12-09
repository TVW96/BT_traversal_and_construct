public class Main {

    public static void main(String[] args) {
        BinaryTreeTraversals traversal = new BinaryTreeTraversals();
        BinaryTreeConstructs construct = new BinaryTreeConstructs();

        // leaf nodes: tree end {4, 5, 3, 6}
        // branch nodes: parent node {1, 2, 3}
        // root node: tree origin {1}

        // Example Tree:
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

        System.out.println("Preorder: " + traversal.preorderTraversal(root)); // [1, 2, 4, 5, 3, 6]
        System.out.println("Inorder: " + traversal.inorderTraversal(root));   // [4, 2, 5, 1, 3, 6]
        System.out.println("Postorder: " + traversal.postorderTraversal(root)); // [4, 5, 2, 6, 3, 1]
        System.out.println("Level Order: " + traversal.levelOrderTraversal(root)); // [[1], [2, 3], [4, 5, 6]]

        // Constructing Tree from Preorder and Inorder
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 3, 6};
        TreeNode constructedRoot = construct.buildTreeFromPreIn(preorder, inorder);
        System.out.println("Constructed Tree Preorder: " + traversal.preorderTraversal(constructedRoot)); // [1, 2, 4, 5, 3, 6]
    }
}

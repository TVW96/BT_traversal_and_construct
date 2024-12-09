
import java.util.HashMap;
import java.util.Map;

class BinaryTreeConstructs {

    public TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
    }

    private TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inOrderMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = constructTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inOrderMap);
        root.right = constructTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inOrderMap);

        return root;
    }
}

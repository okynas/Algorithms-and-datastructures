
public class BinCharTree {
    TreeNode root;

    public BinCharTree() {
        root = null;
    }

    public boolean contains(char x) {
        return contains(root, x);
    }

    public boolean contains(TreeNode root, char x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        return (contains(root.left, x) || contains(root.right, x));
    }

    public int numNodes (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + numNodes(root.left) + numNodes(root.right);
    }

    public int numLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return (numLeaves(root.left) + numLeaves(root.right));
    }

    public int numTwoChildren(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int add = 0;
        if (root.left != null && root.right != null) {
            add = 1;
        }
        return add + numTwoChildren(root.left) + numTwoChildren(root.right);
    }

    public int numLevels(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nLeft = numLevels(root.left);
    }

}

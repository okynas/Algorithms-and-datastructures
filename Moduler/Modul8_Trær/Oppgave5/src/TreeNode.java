import com.sun.source.tree.Tree;

public class TreeNode {
    char data;
    TreeNode left, right;

    public TreeNode(char c, TreeNode l, TreeNode r) {
        data = c;
        left = l;
        right = r;
    }

    public static TreeNode CopyBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new TreeNode(root.data, CopyBinaryTree(root.left), CopyBinaryTree(root.right));
    }

    public static void InOrder(TreeNode root) {
        if (root != null) {
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode('D',
                            new TreeNode('B',
                                    new TreeNode('A', null, null),
                                    new TreeNode('C', null, null)
                            ),
                            new TreeNode('F',
                                    new TreeNode('E', null, null),
                                    new TreeNode('G', null, null)
                            )
        );

        TreeNode copy = CopyBinaryTree(root);
        InOrder(root);
        System.out.println();
        InOrder(copy);
        System.out.println();
    }
}

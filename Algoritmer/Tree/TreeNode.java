package Tree;

public class TreeNode{

    int data;
    TreeNode left, right;
    TreeNode forelder;

    public TreeNode(int data, TreeNode l, TreeNode r) {
        this.data = data;
        this.left = l;
        this.right = r;
    }

    public void sett_forelder(TreeNode rot) {
        if (rot != null) {
            sett_forelder(rot.left);
            sett_forelder(rot.right);

            if (rot.left != null) {
                rot.left.forelder = rot;
            }

            if (rot.right != null) {
                rot.right.forelder = rot;
            }

            rot.forelder = null;
        }
    }


}

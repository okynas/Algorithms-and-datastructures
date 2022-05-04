public class BinarySearchCount {

    public class treeNode {
        String data;
        treeNode left, right;
        public treeNode(String _data){
            data = _data;
            left = null;
            right = null;
        }
    }

    /**
     *
     * @param root, roten i treet som skal regnes fra
     * @return  antall noder i treet med rot i noden root
     */
    public int numNodes(treeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + numNodes(root.left) + numNodes(root.right);
    }

    /**
     *
     * @param root, roten i treet som skal regnes fra
     * @return antall bladnoder i treet med rot i roten root
     */
    public int numLeaves(treeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        return (numLevels(root.left) + numLeaves(root.right));
    }

    /**
     *
     * @param root, roten i treet som skal regnes fra
     * @return antall noder i treet som har to barn
     */
    public int numTwoChildren(treeNode root) {
        if (root == null) {
            return 0;
        }

        int add = 0;

        if (root.left != null && root.right != null) {
            add++;
        }
        return add + numTwoChildren(root.left) + numTwoChildren(root.right);
    }

    /**
     *
     * @param root, roten i treet som skal regnes fra
     * @return antall nivåer (høyden) i treet med rot i roten root
     */
    public int numLevels(treeNode root) {
        if (root == null) {
            return 0;
        }

        int num_levels_left = numLeaves(root.left);
        int num_levels_right = numLeaves(root.right);
        int max = 0;

        if (num_levels_left > num_levels_right) {
            max = num_levels_left;
        } else {
            max = num_levels_right;
        }

        return max + 1;
    }

}

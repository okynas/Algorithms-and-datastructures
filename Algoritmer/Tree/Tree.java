package Tree;

public class Tree implements TreeADT<Integer> {

    TreeNode rot = null;
    TreeNode venstre = null;
    TreeNode hoyre  = null;

    public Tree(TreeNode rot) {
        this.rot = rot;
    }

    @Override
    public void Insert(Integer value) {
        /*
         If root is NULL
           then create root node
           return

         If root exists then
             compare the data with node.data

             while until insertion position is located

                If data is greater than node.data
                   goto right subtree
                else
                   goto left subtree

             endwhile

             insert data

         end If
         */
        TreeNode temp = new TreeNode(value, null, null);

        if (IsEmpty()) {
            rot = temp;
            return;
        }

        else {
            TreeNode current = rot;
            boolean finished = false;

            while (!finished) {
                if (value < rot.data) {
                    if (current.left == null) {
                        current.left = temp;
                        finished = true;
                    }
                    else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = temp;
                        finished = true;
                    }
                    else {
                        current = current.right;
                    }
                }
            }
        }
    }

    @Override
    public boolean Search(Integer value) {
        /*
        If root.data is equal to search.data
           return root
        else
           while data not found

              If data is greater than node.data
                 goto right subtree
              else
                 goto left subtree

              If data found
                 return node
           endwhile

           return data not found

        end if
        */
        TreeNode current = rot;
        boolean found = false;

        if (current.data == value) {
            return true;
        } else {
            while(!found) {
                if (value > rot.data) {
                    current = current.right;
                } else {
                    current = current.left;
                }

                if (current.data == value) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void PreOrder(TreeNode rot) {

    }

    @Override
    public void InOrder(TreeNode rot) {
        if (rot != null) {
            InOrder(rot.left);
            System.out.print(rot.data + " ");
            InOrder(rot.right);
        }
    }

    @Override
    public void PostOrder(TreeNode rot) {

    }

    @Override
    public boolean IsEmpty() {
        return (rot == null);
    }

    @Override
    public TreeNode CopyTree(TreeNode rot) {
        if (rot == null) {
            return null;
        }
        return new TreeNode(rot.data, CopyTree(rot.left), CopyTree(rot.right));
    }

    //
    // Remove node with given value from binary search tree.
    //
    // Accepts attempts to remove from an empty tree or removal of
    // non-existing values.
    //
    // Uses the method "replacement" to do the removal and
    // restructuring of the tree, after the node to be removed has
    // been located.
    //
    @Override
    public void remove(Integer value) {

    }

    //
    // Handles the three different cases of removal of a treenode
    // t from a binary tree:
    //
    // 1. t is a leaf
    // 2. t has only one non-empty subtree
    // 3. t has two non-empty subtreest
    //
    // Returns the node (or null) that replaces the deleted node
    // in the tree.
    //

    @Override
    public TreeNode replacement(TreeNode t) {
        return null;
    }

    @Override
    public int antallMedToBarn(TreeNode rot) {
        if (rot == null) {
            return 0;
        }

        int leggTil = 0;

        if (rot.left != null && rot.right != null) {
            leggTil = 1;
        }

        return leggTil + antallMedToBarn(rot.left) + antallMedToBarn(rot.right);
    }

    @Override
    public int antallMedEttBarn(TreeNode rot) {
        if (rot == null) {
            return 0;
        }

        int leggTil = 0;

        if ( (rot.left == null && rot.right != null) || (rot.left != null && rot.right == null)) {
            leggTil = 1;
        }

        return leggTil + antallMedEttBarn(rot.left) + antallMedEttBarn(rot.right);
    }

    @Override
    public int antallBlader(TreeNode rot) {
        if (rot == null) {
            return 0;
        }
        if (rot.left == null && rot.right == null) {
            return 1;
        }
        return (antallBlader(rot.left) + antallBlader(rot.right));
    }
}

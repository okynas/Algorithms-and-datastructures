public class TreeNodeInt implements TreeNodeADT<Integer>{

    int data;
    TreeNodeInt left, right;

    public TreeNodeInt(int data, TreeNodeInt l, TreeNodeInt r) {
        this.data = data;
        this.left = l;
        this.right = r;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

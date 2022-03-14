package Tree;

public interface TreeADT<T> {
    public void Insert(T value);
    public boolean Search(T value);
    public void PreOrder(TreeNode rot);
    public void InOrder(TreeNode rot);
    public void PostOrder(TreeNode rot);
    public boolean IsEmpty();
    public TreeNode CopyTree(TreeNode rot);
    public void remove(T value);
    public TreeNode replacement(TreeNode t);

    int antallBlader(TreeNode rot);
    int antallMedEttBarn(TreeNode rot);
    int antallMedToBarn(TreeNode rot);
}

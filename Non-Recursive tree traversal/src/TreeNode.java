/**
 * Created by ouren on 15-2-2016.
 */
class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    protected boolean isPopped = false;
    protected TreeNode<E> root;
    public TreeNode(E e) {
        element = e;
    }
}
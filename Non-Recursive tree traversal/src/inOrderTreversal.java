
import java.util.Stack;

/**
 * Created by ouren on 15-2-2016.
 */
public class inOrderTreversal{
    public static void main(String[]args)
    {
        // Create the root node
        TreeNode<Integer> root = new TreeNode<>(60);

        // Create the left child node
        root.left = new TreeNode<>(55);

        root.left.left = new TreeNode<>(30);
        root.left.right = new TreeNode<>(56);

        // Create the right child node
        root.right = new TreeNode<>(100);

        root.right.left = new TreeNode<>(90);
        root.right.right = new TreeNode<>(110);


        inOrder(root);
    }

    public static void inOrder(TreeNode tree)
    {
        TreeNode current = tree;
        Stack stack = new Stack();

        while (current != null || !stack.isEmpty())
        {
            if (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else
            {
                current = (TreeNode)stack.pop();
                System.out.println(current.element);
                current = current.right;
            }
        }
    }

    public static void preOrder()
    {

    }
}

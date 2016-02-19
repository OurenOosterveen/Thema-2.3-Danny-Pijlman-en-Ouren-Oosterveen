
import java.util.Stack;

/**
 * Created by ouren on 15-2-2016.
 */
public class inOrderTreversal{
    public static void main(String[]args)
    {
        // Create the root node
        TreeNode<Integer> root = new TreeNode<>(60);
        root.root = root;

        // Create the left child node
        root.left = new TreeNode<>(55);

        root.left.left = new TreeNode<>(30);
        root.left.right = new TreeNode<>(56);

        // Create the right child node
        root.right = new TreeNode<>(100);

        root.right.left = new TreeNode<>(90);
        root.right.right = new TreeNode<>(110);

        System.out.println("inOrder: ");
        // order should be: 30, 55, 56, 60, 90, 100, 110
        inOrder(root);
        System.out.println("preOrder: ");
        // order should be: 60, 55, 30, 56, 100, 90, 110
        preOrder(root);
        System.out.println("postOrder: ");
        // order should be: 30, 56, 55, 90, 110, 100, 60
        postOrder(root);

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

    public static void preOrder(TreeNode tree)
    {
        TreeNode current = tree;
        Stack stack = new Stack();

        while (current != null || !stack.isEmpty())
        {
            if (current != null)
            {
                stack.push(current);
                System.out.println(current.element);
                current = current.left;
            }
            else
            {
                current = (TreeNode)stack.pop();
                current = current.right;
            }
        }
    }

    public static void postOrder(TreeNode tree)
    {
        TreeNode current = tree;
        Stack stack = new Stack();

        //while (current != null || !stack.isEmpty())
        while (true)
        {
            if (current != null)
            {
                if (current.right != null)
                {
                    stack.push(current.right);
                }
                stack.push(current);
                current = current.left;
                continue;
            }

            if (stack.isEmpty())
                return;
            current = (TreeNode)stack.pop();

            if (current.right != null && !stack.isEmpty()&& current.right == stack.peek())
            {
                stack.pop();
                stack.push(current);
                current = current.right;
            } else {
                System.out.println(current.element);
                current = null;
            }
        }
    }
}

import java.util.*;
public class Bst
{
    static class Node 
        {
        int data;
        Node right, left;

        Node(int data)
        {
            this.data = data;
            right = left = null;
        }
        public String toString() 
         {
            return "Node [data=" + data + ", right=" + right + ", left=" + left + "]";
        }
    }

    public static void preOrder(Node root) 
    {
        if (root != null)
        {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root)
    {
        if (root != null)
         {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
    public static Node insert(Node node, int data)
     {
        if (node == null)
        {
            return new Node(data);
        }
        Node cur;
        if (data <= node.data)
         {
            cur = insert(node.left, data);
            node.left = cur;
        }
       else 
        {
            cur = insert(node.right, data);
            node.right = cur;
        }
        return node;
    }

    public static void main(String args[])
      {
        Bst bst = new Bst();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;
        while (t-- > 0)
         {
            int data = sc.nextInt();
            root = insert(root, data);
        }
      System.out.println();
      preOrder(root);
      System.out.println();  
      inOrder(root);
      System.out.println();
       postOrder(root);
    }

}
 
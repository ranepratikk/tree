package Tree;

public class Tree_Class {
    static DNode root;
    static void insert_node(DNode r, DNode n) {
        if(root== null)
            root=n;
        else {
            if(n.data<r.data)
            {
                if (r.left == null) {
                    r.left = n;
                    System.out.println("\n"+n.data+" inserted");
                }
                else
                    insert_node(r.left, n);
            }
            else {
                if(r.right == null) {
                    r.right = n;
                    System.out.println("\n"+n.data+" inserted");
                }
                else
                    insert_node(r.right, n);
            }
        }
    }
    static void inorder(DNode r)
    {
        if(r!=null)
        {
            inorder(r.left);	//L
            System.out.print(r.data+",");	//P
            inorder(r.right);//R
        }
    }
    static void preorder(DNode r) {
        if(r!=null) {
            System.out.print("\n"+r.data+",");
            preorder(r.left);
            preorder(r.right);
        }
    }
    static void postorder(DNode r) {
        if(r!=null) {

            postorder(r.left);
            postorder(r.right);
            System.out.print("\n"+r.data+",");
        }
    }

    static DNode get_root()
    {
        return Tree_Class.root;
    }

    static int count_nodes(DNode r)
    {
        if(r==null)
            return 0;
        return 1+count_nodes(r.left)+count_nodes(r.right);
    }
    static int count_leaf_nodes(DNode r) {
        if(r==null)
            return 0;
        else if (r!=null && r.left == null && r.right == null)
        {
            return 1;
        }
        return 1+count_leaf_nodes(r.left)+count_leaf_nodes(r.right);

    }
    static int sumoftree(DNode r){
        if(r==null){
            return 0;
        }
        return r.data+sumoftree(r.left)+sumoftree(r.right);
    }
    public static void main(String[] args) {
        Tree_Class.insert_node(Tree_Class.get_root(),new DNode(10));
        Tree_Class.insert_node(Tree_Class.get_root(),new DNode(5));
        Tree_Class.insert_node(Tree_Class.get_root(),new DNode(20));
        Tree_Class.insert_node(Tree_Class.get_root(),new DNode(15));
        Tree_Class.insert_node(Tree_Class.get_root(),new DNode(6));
        Tree_Class.insert_node(Tree_Class.get_root(),new DNode(19));
//		static_Tree.inorder(root);
//		static_Tree.preorder(root);
//		static_Tree.postorder(root);
        System.out.println(Tree_Class.count_nodes(root));
        System.out.println(Tree_Class.count_leaf_nodes(root));
        System.out.println(Tree_Class.sumoftree(root));
    }
}
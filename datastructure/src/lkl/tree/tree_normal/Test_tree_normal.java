package lkl.tree.tree_normal;

public class Test_tree_normal {
    public static void main(String[] args) {
        tree_normal tree = new tree_normal(1);
        System.out.println("判断树是否为空："+tree.EmptyOrNot());
        System.out.println("判断是否为叶子结点："+tree.isLeaf());
        System.out.println("求树的深度："+tree.get_depth());
        //向树中添加子树
        tree_normal node1 = new tree_normal(2);
        tree_normal node2 = new tree_normal(3);
        tree_normal node3 = new tree_normal(4);
        tree_normal node4 = new tree_normal(5);
        tree_normal node5 = new tree_normal(6);
        tree.childs.add(node1);
        tree.childs.add(node2);
        tree.childs.add(node3);
        node1.childs.add(node4);
        node1.childs.add(node5);
        System.out.println("树的深度为："+tree.get_depth());
        System.out.println("计算树中结点的总数："+tree.calculate_node_num());

        System.out.println("先序遍历树：");
        tree.PreprintTree();
        System.out.println("后序遍历树：");
        tree.PostprintTree();
        System.out.println("树清空后，树中节点的总数："+tree.calculate_node_num());
    }
}

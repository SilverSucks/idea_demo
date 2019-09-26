package lkl.tree.tree_normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
一般的树，用孩子表示法来表示
 */
public class tree_normal {
    Object data;   //树中结点的值
    List<tree_normal> childs;  //结点的孩子

    public tree_normal() {
        this.data = null;
        this.childs = new ArrayList<>();
    }

    public tree_normal(Object data) {
        this.data = data;
        this.childs = new ArrayList<>();
    }
    /*
    添加子树
     */
    public void addNode(tree_normal tree){
        childs.add(tree);
    }
    /*
    置空树
     */
    public void  clearTree(){
        data = null;
        childs.clear();
    }
    /*
    判断是否为空树
     */
    public boolean EmptyOrNot(){
        if (data==null && childs.size()==0){
            return true;
        }else {
            return false;
        }
    }
    /*
    判断树是否为叶子结点
     */
    public boolean isLeaf(){
        if (childs.isEmpty())
            return true;
        return false;
    }
    /*
    求树的深度
     */
    public int get_depth(){
        return get_depth(this);
    }
    public int get_depth(tree_normal tree){

        if (EmptyOrNot()){
            return 0;
        }else if (isLeaf()){
            return 1;
        }else{
            int size = tree.childs.size();
            int dept[] = new int[size];
            int depth = 1;
            for (int i = 0; i < size; i++) {
                if (!childs.get(i).isLeaf()){  //如果孩子结点不是叶子结点，继续遍历,一次循环求出根结点到一个叶子结点的深度
                    childs.get(i).get_depth();
                    ++depth;
                }
                //把从根结点到叶子结点的每个深度都存放在数组dept中，最大的深度就是树的深度
                dept[i] = depth;
                //对dept数组进行排序，返回dept的深度，即为树的深度
                Arrays.sort(dept);

            }
            //返回dept的最后一个元素，即为树的深度
            return dept[size-1];
        }
    }
    /*
    返回树的根结点的data
     */
    public Object getRootData(){
        return data;
    }
    /*
    返回第i个子树
     */
    public tree_normal getChild(int i){
        return this.childs.get(i);
    }
    /*
    返回第一个子树
     */

    /*public tree_normal getFirstChild(){
        return this.childs.get(0);
    }*/
    /*
    返回最后一个子树
     */
    /*public tree_normal getLastChild(){
        return this.childs.get(childs.size()-1);
    }*/
    /*
    求结点数
     */
    public int calculate_node_num(){
        return calculate_node_num(this);
    }
    public int calculate_node_num(tree_normal tree){
        int sum = 0;
        if (tree.EmptyOrNot()){  //如果是空树
            return 0;
        }else if (tree.isLeaf()){  //如果树是叶子结点
            return 1;
        }else{   //对于每一个子树，递归地计算子树中的结点数
            int size = tree.childs.size();
            for (int i = 0; i < size; i++) {
                int num_child = calculate_node_num(tree.childs.get(i));
                sum += num_child;    //此处num_child+1 是因为num_child的数量是每一个子树的叶子结点的总数，不包括子树的根结点
            }
            //对于每次求子树中结点的个数，最后都要加上根结点，即：子树中的孩子结点数+1（根结点）==子树中所有结点的个数
            ++sum;

        }
        return sum;
    }
    /*
    遍历树中所有的结点
     */
    public void PreprintTree(){
        //打印根结点data
        System.out.printf("%3d",this.data);
        //打印子树中的data
        first_printTree(this);
        System.out.println();
    }
    /*
    递归遍历子树，先根遍历  遍历的顺序为：根结点-->左孩子-->右孩子
     */
    public void first_printTree(tree_normal tree){

        if (EmptyOrNot()){
            System.out.println("为空树！");
            return ;
        }else if (isLeaf()){
            System.out.printf("%3d",this.data);
        }else{
            int size = tree.childs.size();
            for (int i = 0; i < size; i++) {
                System.out.printf("%3d",tree.childs.get(i).data);
                first_printTree(tree.childs.get(i));
            }

        }
    }
    public void PostprintTree(){
        //打印子树中的data
        Last_printTree(this);
        //打印根结点data
        System.out.printf("%3d",this.data);
        System.out.println();
    }

    /*递归遍历子树，先根遍历  遍历的顺序为：根结点-->左孩子-->右孩子*/

    public void Last_printTree(tree_normal tree){

        if (EmptyOrNot()){
            System.out.println("为空树！");
            return ;
        }else if (isLeaf()){
            System.out.printf("%3d",this.data);
        }else{
            int size = tree.childs.size();
            for (int i = 0; i < size; i++) {
                Last_printTree(tree.childs.get(i));
                System.out.printf("%3d",tree.childs.get(i).data);
            }

        }
    }
    /*
    打印结点中的data
     */
    public void visit(tree_normal tree){
        System.out.print(tree.getRootData()+" ");
    }
    /*
    树的先根遍历
     */
    public void preOrder(){
        preOrder(this);
    }
    public void preOrder(tree_normal tree){
        if (!tree.EmptyOrNot()){
            visit(tree);
            List<tree_normal> childs = tree.childs;
            for (tree_normal child : childs) {
                visit(child);
                preOrder(child);
            }
        }
        System.out.println();
    }
}

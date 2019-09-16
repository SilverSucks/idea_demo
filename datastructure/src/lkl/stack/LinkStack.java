package lkl.stack;
/*
链式栈
 */
public class LinkStack {

    Node top;  //栈顶结点  这里的栈顶结点没有什么实际含义，相当于链表中的头结点

    public LinkStack() {
        this.top = new Node();
    }
    //初始化栈,给栈头指针top初始化
    public void initStack(){
        this.top.data = -1;
        this.top.next = null;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        boolean b = top.next==null?true:false;
        return b;
    }
    //压栈方式一   栈尾插入新的结点（不可行）
    public void PushStack(Node node){
        //判断栈是否为空
        if (isEmpty()){  //如果栈为空
            top.next = node;
            node.next = null;
        }else{  //栈不为空的情况下，压栈
            //先找到链栈中的最后一个元素 temp
            Node temp = top;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;    //把node放到temp的后面
            node.next = null;    //把node.next指向空
        }
    }
    //弹栈方式一:在栈尾插入元素，就要在栈尾就行进行弹栈操作 （不可行）
    public void PopStack(){
        //如果栈空,直接返回
        if (isEmpty()){
            return ;
        }else{
            //同样地，先找到栈尾元素
            Node temp = top;
            while (temp.next!=null){
                temp = temp.next;
            }
            System.out.println(temp.data);
            /*输出了栈尾元素，
            虽然获取了链表中的最后一个结点，但是不能够获取链表中的倒数第二个结点，除非在链表是有长度的。
            这样就没办法删除最后一个结点（即弹栈操作） ，由此可见，尾部插入结点的方式不可行

             */
        }
    }
    //第二种压栈的方式：每次进栈的结点都添加在top节点后面  (在这里我称之为：逆序插入)
    public void pushStack(Node node){
        if (isEmpty()){  //如果栈为空
            top.next = node;
            node.next = null;
        }else{  //栈不为空，在top结点后面插入结点
            node.next = top.next;
            top.next = node;
        }
    }
    //第二种弹栈的方式：对应上面压栈的操作
    public void popStack(){
        if (isEmpty()){  //如果栈为空，不做任何操作
            System.out.println("空栈");
            return ;
        }else{
            System.out.printf("%3d",top.next.data);   //输出栈顶结点的data
            top = top.next;     //修改top指针指向，完成弹栈操作
        }
    }




}
class Node{
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}
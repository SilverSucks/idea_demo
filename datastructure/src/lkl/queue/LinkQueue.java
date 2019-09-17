package lkl.queue;
/*
链式队列:内部用链表进行存储,链式队列理论上没有大小，除非电脑的内存用完了。
 */
public class LinkQueue {
    Node front;  //头指针，始终指向队列的第一个元素
    //初始化链队列
    public LinkQueue() {
        front = new Node();
    }
    //判断链队列是否为空
    public boolean isEmpty(){
        return front.next==null?true:false;
    }
    //获取链队列的长度
    public int GetLength(){
        int len = 0;
        Node temp = front;
        while(temp.next!=null){
            temp = temp.next;
            ++len;
        }
        return len;
    }
    //进队列
    public void InLinkQueue(int data){
        Node newNode = new Node(data);
        Node temp = front;
        //如果front的next指针为空（空队列的情况），直接在front后面插入，不为空找到最后一个结点，在最后一个结点后面进行插入
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
    }
    //出队列
    public void OutLinkQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }else{
            System.out.println(front.next.data);
            front.next = front.next.next;
        }
    }
    //打印链队列中的值
    public void printLinkQueue(){
        Node temp = front;
        while(temp.next!=null){
            System.out.printf("%3d",temp.next.data);
            temp = temp.next;
        }
        System.out.println();
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

package lkl.linkedList;
/*
数据结构链表的操作

 */
public class Question01 {
    private static class Node{
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
    private static class LinkedList{
        int size;
        Node head;     //对第一顶点的引用
        Node current;  //对下一个结点的引用

        public LinkedList(int size) {
            this.size = size;
        }

        public void add(int data){
            if (head==null){
                head = new Node(data);
                current = head;
            }else{
                current.next = new Node(data);
                current = current.next;
            }
        }
        //打印链表中的data
        public void print(Node node){
            if (node == null){
                return;
            }
            while (node!=null){
                System.out.printf("%3d",node.data);
                node = node.next;
            }
            System.out.println();
        }
        //获取第i个结点
        public Node GetNode(int index){
            int j = 1;
            current = head;
            while (current.next!=null && j<index){
                current = current.next;
                j++;
            }
            return current;
        }
        //打印倒数第K个结点中的data
        public void printK(int k){
            //转换为正序：倒数第一个 对应 正数第 size-k+1个
            int index = size-k+1;
            if (head == null){
                return ;
            }
            if (index == -1)
                return;
            
            Node node = this.GetNode(index);
            System.out.println("第"+k+"小的元素是："+node.data);

        }
        //在指定位置插入结点
        public void insert(int k,Node node){
            Node temp = this.GetNode(k);
            node.next = temp.next;
            temp.next = node;
        }
        //删除指定元素：即删除第k个结点
        public void delete(int k){
            //找到第k-1个结点
            Node temp = this.GetNode(k - 1);
            temp.next = temp.next.next;

        }
    }


    public static void main(String[] args) {
        //初始化链表
        LinkedList linkedList = new LinkedList(5);
        for (int i = 0; i <linkedList.size ; i++) {
            linkedList.add(i);
        }
        //打印链表中的data
        linkedList.print(linkedList.head);
        //打印链表中第k小元素
        linkedList.printK(2);
        //在指定结点后面插入结点
        linkedList.insert(2,new Node(5));
        System.out.println("在第2个结点后插入5：");
        linkedList.print(linkedList.head);
        //删除指定结点
        System.out.println("删除第3个结点：");
        linkedList.delete(3);
        linkedList.print(linkedList.head);
    }
}

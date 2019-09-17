package lkl.queue;

public class TestQueue {
    public static void main(String[] args) {
        SqQueue sqQueue = new SqQueue(5);
        System.out.println("队列初始化，是否为空："+sqQueue.isEmpty());
        System.out.println("队列初始化是否已满："+sqQueue.isFull());
        sqQueue.InQueue(1);
        sqQueue.InQueue(2);
        sqQueue.InQueue(3);
        sqQueue.InQueue(4);
        sqQueue.InQueue(5);
        System.out.println("向队列中添加了5个元素，队列是否为空："+sqQueue.isEmpty());
        System.out.println("向队列中添加了5个元素，队列是否已满："+sqQueue.isFull());
        System.out.println("打印队列中的值：");
        sqQueue.printQueue();
        /*while (!sqQueue.isEmpty()){
            sqQueue.OutQueue();
        }*/
        sqQueue.OutQueue();
        System.out.println("队列中的所有元素：");
        sqQueue.printQueue();
        sqQueue.InQueue(6);
        System.out.println("队列中的所有元素：");
        sqQueue.printQueue();


    }
}

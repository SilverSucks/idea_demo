package lkl.queue;

public class TestLinkQueue {
    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        System.out.println("初始化链队列,队列是否为空："+linkQueue.isEmpty());
        linkQueue.InLinkQueue(1);
        linkQueue.InLinkQueue(2);
        linkQueue.printLinkQueue();
        System.out.println("出队列");
        linkQueue.OutLinkQueue();
        linkQueue.InLinkQueue(3);
        System.out.println("打印队列中的值：");
        linkQueue.printLinkQueue();
        System.out.printf("获取链队列的长度：%d",linkQueue.GetLength());


    }
}
